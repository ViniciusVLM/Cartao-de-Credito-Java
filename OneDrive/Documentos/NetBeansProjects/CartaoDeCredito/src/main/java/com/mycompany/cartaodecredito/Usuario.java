
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
        this.isAdmin = isAdmin;
    }


    public String getNome() {
        return nome;
    }

    boolean isAdmin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}






