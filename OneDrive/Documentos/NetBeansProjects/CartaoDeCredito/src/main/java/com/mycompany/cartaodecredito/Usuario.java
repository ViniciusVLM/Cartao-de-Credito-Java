
package com.mycompany.cartaodecredito;



public class Usuario {
 private final String nome;
    private final String cpf;
    private final String senha;

    public Usuario(String nome, String cpf, String senha, boolean isAdmin) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void exibirPerfil() {
        System.out.println("Usuário: " + nome);
    }
     boolean isAdmin() {
        throw new UnsupportedOperationException("Not supported yet.");
     }       
}







