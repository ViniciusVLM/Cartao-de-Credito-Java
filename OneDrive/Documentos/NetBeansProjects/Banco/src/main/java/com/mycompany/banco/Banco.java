package com.mycompany.banco;

public class Banco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    // Construtor
    public Banco() {
        this.saldo = 0;
        this.status = false;
    }

    // Métodos públicos
    public void estadoAtual() {
        System.out.println("\n===== ESTADO ATUAL =====");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }

    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if (t.equals("CC")) {
            this.setSaldo(50);
        } else if (t.equals("CP")) {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso");
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta ainda não pode ser fechada, porque ainda tem dinheiro");
        } else if (this.getSaldo() < 0) {
            System.out.println("A conta não pode ser fechada porque tem débito");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(float v) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Depósito realizado com sucesso para " + this.getDono());
        } else {
            System.out.println("Impossível depositar em uma conta fechada");
        }
    }

    public void sacar(float v) {
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada!");
        }
    }

    public void pagarMensal() {
        int v = 0;
        if (this.getTipo().equals("CC")) {
            v = 12;
        } else if (this.getTipo().equals("CP")) {
            v = 20;
        }

        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        } else {
            System.out.println("Impossível pagar uma conta fechada");
        }
    }

    // Getters e Setters
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    
    public static void main(String[] args) {
        Banco p1 = new Banco();
        p1.setNumConta(165116);
        p1.setDono("Vinicius Lourenço");
        p1.estadoAtual();

        
        Banco p2 = new Banco();
        p2.setNumConta(454435);
        p2.setDono("Vitoria");
        p2.abrirConta("CC");
        
        p1.depositar(100);
        p2.depositar(500);
        p2.sacar(100);
        
        
        Banco p3 = new Banco();
        p3.setNumConta(40515151);
        p3.setDono("jairo Lourenço");
        p3.abrirConta("CC");
        
        
        Banco p4 = new Banco();
        
        p4.setDono("jairo Lourenço");
        p4.setNumConta(1651656);
        p4.abrirConta("CP");
        p4.depositar(10000);
        
        
        
        
        p4.estadoAtual();
        p3.depositar(1000);
        
        
        p3.estadoAtual();
        p1.abrirConta("CC");
        p1.estadoAtual();
        p2.estadoAtual();
        
        
    }


    
}

