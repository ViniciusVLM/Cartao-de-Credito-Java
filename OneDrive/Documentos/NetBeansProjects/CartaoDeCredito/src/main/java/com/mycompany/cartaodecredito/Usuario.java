
package com.mycompany.cartaodecredito;



public class Usuario {
 private final String nome;
    private final String cpf;
    private final String senha;
     private final boolean isAdmin;

    public Usuario(String nome, String cpf, String senha, boolean isAdmin) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.isAdmin = false;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public String getSenha() {
        return senha;
        
    }   public boolean isAdmin() {
        return isAdmin;
    }

    public void exibirPerfil() {
        System.out.println("Usuário: " + nome);
    }
 
}







