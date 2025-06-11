package com.mycompany.cartaodecredito;



public class Usuario {
    private final String nome;
    private final String CPF;
    private final String Senha;
    private final boolean isAdmin;

    public Usuario(String nome, String CPF, String Senha, boolean isAdmin) {
        this.nome = nome;
        this.CPF = CPF;
        this.Senha = Senha;
        this.isAdmin = isAdmin;
    }


    public String getNome() {
        return nome;
    }

    boolean isAdmin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}