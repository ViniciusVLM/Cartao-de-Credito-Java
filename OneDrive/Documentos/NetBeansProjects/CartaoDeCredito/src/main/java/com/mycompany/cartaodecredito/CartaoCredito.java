
package com.mycompany.cartaodecredito;

public class CartaoCredito {

        private String numero;
        private double limite;
        private double saldoDisponivel;
        private boolean ativo;

        public CartaoCredito(String numero, double limite) {
            this.numero = numero;
            this.limite = limite;
            this.saldoDisponivel = limite;
            this.ativo = true;
            System.out.println("cu");
            System.out.println("anwdianwdon");
        }

        public String getNumero() {
            return numero;
        }

        public double getLimite() {
            return limite;
        }

        public double getSaldoDisponivel() {
            return saldoDisponivel;
        }

        public void usarSaldo(double valor) {
            if (valor <= saldoDisponivel) {
                saldoDisponivel -= valor;
            }
        }


        public boolean isAtivo() {
            return ativo;
        }

void desativar() {
    throw new UnsupportedOperationException("Not supported yet.");
}
    
}
