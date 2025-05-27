
package com.mycompany.banco;

public class Aula05 {
    
    public static void main(String[] args) {
        Banco p1 = new Banco();
        p1.setNumConta(165116);
        p1.setDono("Vinicius Lourenço");
        p1.estadoAtual();
        p1.abrirConta("CC");
        p1.estadoAtual();
    }
}
