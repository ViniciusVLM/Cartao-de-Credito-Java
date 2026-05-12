// ===== VaultBank Data Layer (LocalStorage) =====
const DB = {
  _get(key) { return JSON.parse(localStorage.getItem('vb_' + key) || '[]'); },
  _set(key, data) { localStorage.setItem('vb_' + key, JSON.stringify(data)); },

  init() {
    if (!localStorage.getItem('vb_initialized')) {
      this._set('clientes', [{
        id: 1, nome: 'Administrador VaultBank', cpf: '000.000.000-00', rg: '00.000.000-0',
        email: 'admin@vaultbank.com', telefone: '(11) 99999-9999',
        dataNascimento: '1990-01-01', nacionalidade: 'Brasileiro',
        cep: '01001-000', estado: 'SP', isAdmin: true,
        senha: 'admin123', saldo: 50000
      }, {
        id: 2, nome: 'João Silva', cpf: '123.456.789-00', rg: '12.345.678-9',
        email: 'joao@email.com', telefone: '(11) 98888-7777',
        dataNascimento: '1995-05-15', nacionalidade: 'Brasileiro',
        cep: '04001-000', estado: 'SP', isAdmin: false,
        senha: 'senha123', saldo: 3500.75
      }]);
      this._set('cartoes', [
        { id: 1, idCliente: 2, numero: '4532 8912 3456 7890', validade: '2028-12' }
      ]);
      this._set('compras', [
        { id: 1, idCartao: 1, transacao: '2026-05-01', valor: 150.00, estabelecimento: 'Amazon Brasil', descricao: 'Eletrônicos' },
        { id: 2, idCartao: 1, transacao: '2026-05-03', valor: 89.90, estabelecimento: 'iFood', descricao: 'Alimentação' },
        { id: 3, idCartao: 1, transacao: '2026-05-05', valor: 320.00, estabelecimento: 'Shopee', descricao: 'Roupas' },
        { id: 4, idCartao: 1, transacao: '2026-04-28', valor: 45.00, estabelecimento: 'Spotify', descricao: 'Assinatura' },
        { id: 5, idCartao: 1, transacao: '2026-04-20', valor: 1200.00, estabelecimento: 'Magazine Luiza', descricao: 'Eletrodomésticos' }
      ]);
      this._set('denuncias', [
        { id: 1, idCompra: 5, idCliente: 2, dataDenuncia: '2026-05-06', motivo: 'Compra Fraudulenta', status: 'Pendente' }
      ]);
      this._set('historico_reembolsos', []);
      this._set('nextId', { clientes: 3, cartoes: 2, compras: 6, denuncias: 2 });
      localStorage.setItem('vb_initialized', 'true');
    }
  },

  getClientes() { return this._get('clientes'); },
  getCartoes() { return this._get('cartoes'); },
  getCompras() { return this._get('compras'); },
  getDenuncias() { return this._get('denuncias'); },
  getHistoricoReembolsos() { return this._get('historico_reembolsos'); },

  _nextId(entity) {
    const ids = this._get('nextId');
    const id = ids[entity] || 1;
    ids[entity] = id + 1;
    this._set('nextId', ids);
    return id;
  },

  cadastrarCliente(data) {
    const clientes = this.getClientes();
    if (clientes.find(c => c.cpf === data.cpf)) return { error: 'CPF já cadastrado!' };
    const id = this._nextId('clientes');
    const cliente = { id, ...data, isAdmin: false, saldo: 0 };
    clientes.push(cliente);
    this._set('clientes', clientes);
    // Create card
    const cartoes = this.getCartoes();
    const cardId = this._nextId('cartoes');
    const num = Array.from({length: 16}, () => Math.floor(Math.random()*10)).join('').replace(/(.{4})/g, '$1 ').trim();
    const now = new Date(); const exp = `${now.getFullYear()+4}-${String(now.getMonth()+1).padStart(2,'0')}`;
    cartoes.push({ id: cardId, idCliente: id, numero: num, validade: exp });
    this._set('cartoes', cartoes);
    return { success: true, cliente };
  },

  autenticar(cpf, senha) {
    const clientes = this.getClientes();
    const c = clientes.find(cl => cl.cpf === cpf && cl.senha === senha);
    if (!c) return null;
    return c;
  },

  getClienteById(id) { return this.getClientes().find(c => c.id === id); },

  getCartoesByCliente(idCliente) { return this.getCartoes().filter(c => c.idCliente === idCliente); },

  getComprasByCartao(idCartao) { return this.getCompras().filter(c => c.idCartao === idCartao); },

  getComprasByCliente(idCliente) {
    const cartoes = this.getCartoesByCliente(idCliente);
    const ids = cartoes.map(c => c.id);
    return this.getCompras().filter(c => ids.includes(c.idCartao));
  },

  cadastrarCompra(data) {
    const compras = this.getCompras();
    const id = this._nextId('compras');
    compras.push({ id, ...data });
    this._set('compras', compras);
    // Update balance
    const cartao = this.getCartoes().find(c => c.id === data.idCartao);
    if (cartao) {
      const clientes = this.getClientes();
      const cl = clientes.find(c => c.id === cartao.idCliente);
      if (cl) { cl.saldo = (cl.saldo || 0) - data.valor; this._set('clientes', clientes); }
    }
    return { success: true };
  },

  cadastrarDenuncia(data) {
    const denuncias = this.getDenuncias();
    const id = this._nextId('denuncias');
    denuncias.push({ id, ...data, status: 'Pendente' });
    this._set('denuncias', denuncias);
    return { success: true };
  },

  getDenunciasPendentes() {
    return this.getDenuncias().filter(d => d.status !== 'Resolvida' && d.status !== 'Cancelada');
  },

  processarReembolso(idDenuncia) {
    const denuncias = this.getDenuncias();
    const d = denuncias.find(x => x.id === idDenuncia);
    if (!d) return { error: 'Denúncia não encontrada' };
    const compra = this.getCompras().find(c => c.id === d.idCompra);
    if (!compra) return { error: 'Compra não encontrada' };
    // Refund
    const clientes = this.getClientes();
    const cl = clientes.find(c => c.id === d.idCliente);
    if (cl) { cl.saldo = (cl.saldo || 0) + compra.valor; this._set('clientes', clientes); }
    // Update status
    d.status = 'Resolvida';
    this._set('denuncias', denuncias);
    // Add to history
    const hist = this.getHistoricoReembolsos();
    hist.push({ idCliente: d.idCliente, idCompra: d.idCompra, valor: compra.valor, data: new Date().toISOString().split('T')[0] });
    this._set('historico_reembolsos', hist);
    return { success: true };
  },

  cancelarDenuncia(idDenuncia) {
    const denuncias = this.getDenuncias();
    const d = denuncias.find(x => x.id === idDenuncia);
    if (d) { d.status = 'Cancelada'; this._set('denuncias', denuncias); }
    return { success: true };
  }
};

DB.init();

// ===== UI Helpers =====
function showToast(msg, type = 'info') {
  let container = document.querySelector('.toast-container');
  if (!container) { container = document.createElement('div'); container.className = 'toast-container'; document.body.appendChild(container); }
  const icons = { success: '✅', error: '❌', info: 'ℹ️' };
  const toast = document.createElement('div');
  toast.className = `toast ${type}`;
  toast.innerHTML = `<span>${icons[type] || ''}</span><span>${msg}</span>`;
  container.appendChild(toast);
  setTimeout(() => { toast.style.opacity = '0'; toast.style.transform = 'translateX(100px)'; setTimeout(() => toast.remove(), 300); }, 3500);
}

function formatCurrency(val) {
  return new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(val);
}

function formatDate(str) {
  if (!str) return '-';
  const d = new Date(str + 'T00:00:00');
  return d.toLocaleDateString('pt-BR');
}
