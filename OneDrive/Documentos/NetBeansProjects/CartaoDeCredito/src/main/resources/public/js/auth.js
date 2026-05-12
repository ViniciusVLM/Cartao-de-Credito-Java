// ===== Auth Module =====
const Auth = {
  async login(cpf, senha) {
    const user = await DB.autenticar(cpf, senha);
    if (user) {
      // Guarda a senha para permitir refresh de saldo (apenas para o prototipo)
      user._s = senha;
      sessionStorage.setItem('vb_user', JSON.stringify(user));
      return user;
    }
    return null;
  },

  logout() {
    sessionStorage.removeItem('vb_user');
    window.location.href = 'index.html';
  },

  getUserSync() {
    const data = sessionStorage.getItem('vb_user');
    return data ? JSON.parse(data) : null;
  },

  async getUser() {
    const cached = this.getUserSync();
    if (!cached) return null;
    // Refresh from DB for latest saldo
    if(cached._s) {
        const fresh = await DB.refreshUser(cached.cpf, cached._s);
        if(fresh) {
            fresh._s = cached._s;
            sessionStorage.setItem('vb_user', JSON.stringify(fresh));
            return fresh;
        }
    }
    return cached;
  },

  isLoggedIn() { return !!this.getUserSync(); },
  isAdmin() { const u = this.getUserSync(); return u && u.isAdmin; },

  requireAuth(redirectTo = 'login.html') {
    if (!this.isLoggedIn()) { window.location.href = redirectTo; return false; }
    return true;
  },

  requireAdmin() {
    if (!this.isLoggedIn()) { window.location.href = 'login.html'; return false; }
    if (!this.isAdmin()) { window.location.href = 'dashboard.html'; return false; }
    return true;
  }
};

// ===== Navbar scroll effect =====
window.addEventListener('scroll', () => {
  const nav = document.querySelector('.navbar');
  if (nav) nav.classList.toggle('scrolled', window.scrollY > 50);
});

// ===== Update navbar auth links =====
function updateNavbarAuth() {
  const authLinks = document.getElementById('auth-links');
  if (!authLinks) return;
  if (Auth.isLoggedIn()) {
    const user = Auth.getUserSync();
    const dest = user.isAdmin ? 'admin.html' : 'dashboard.html';
    authLinks.innerHTML = `
      <a href="${dest}">Minha Conta</a>
      <a href="#" onclick="Auth.logout(); return false;" class="btn btn-secondary btn-sm">Sair</a>
    `;
  } else {
    authLinks.innerHTML = `
      <a href="login.html">Entrar</a>
      <a href="cadastro.html" class="btn btn-primary btn-sm">Cadastrar</a>
    `;
  }
}

document.addEventListener('DOMContentLoaded', updateNavbarAuth);
