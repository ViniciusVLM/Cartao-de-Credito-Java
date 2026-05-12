const DB = {
  async req(endpoint, method = 'GET', body = null) {
    const opts = { method, headers: { 'Content-Type': 'application/json' } };
    if (body) opts.body = JSON.stringify(body);
    try {
      const res = await fetch(endpoint, opts);
      if (!res.ok) {
        const text = await res.text();
        return { error: text || 'Erro na requisição' };
      }
      if (res.status === 201 || res.status === 204) return { success: true };
      
      const text = await res.text();
      try {
        return text ? JSON.parse(text) : { success: true };
      } catch (e) {
        return { success: true };
      }
    } catch (e) {
      console.error(e);
      return { error: 'Erro de rede ou servidor inativo' };
    }
  },

  async cadastrarCliente(data) {
    const res = await this.req('/api/clientes', 'POST', data);
    return res;
  },

  async autenticar(cpf, senha) {
    const res = await this.req('/api/login', 'POST', { cpf, senha });
    return res.error ? null : res;
  },

  async refreshUser(cpf, senha) {
    const res = await this.req(`/api/clientes/${cpf}/${senha}`);
    return res.error ? null : res;
  },

  async getClientes() {
    return await this.req('/api/clientes');
  },

  async getCartoesByCliente(idCliente) {
    return await this.req(`/api/cartoes/${idCliente}`);
  },

  async getComprasByCliente(idCliente) {
    return await this.req(`/api/compras/${idCliente}`);
  },

  async cadastrarCompra(data) {
    return await this.req('/api/compras', 'POST', data);
  },

  async cadastrarDenuncia(data) {
    return await this.req('/api/denuncias', 'POST', data);
  },

  async getDenunciasPendentes() {
    return await this.req('/api/denuncias/pendentes');
  },

  async getTodosReembolsos() {
    return await this.req('/api/reembolsos');
  },

  async processarReembolso(idDenuncia) {
    return await this.req(`/api/denuncias/${idDenuncia}/reembolsar`, 'POST');
  },

  async cancelarDenuncia(idDenuncia) {
    return { success: true };
  }
};

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
