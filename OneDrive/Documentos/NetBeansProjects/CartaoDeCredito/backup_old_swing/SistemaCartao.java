
package com.mycompany.cartaodecredito;

import java.util.Random;

public class SistemaCartao {


        public static CartaoCredito emitirNovoCartao(CartaoCredito antigo, Usuario usuario) {
            if (!usuario.isAdmin()) {
                System.out.println("Acesso negado. Apenas administradores podem emitir um novo cartão.");
                return null;
            }

            antigo.desativar();
            String novoNumero = gerarNumeroCartao();
            CartaoCredito novo = new CartaoCredito(novoNumero, antigo.getLimite());
            
            // Mantém o saldo restante do antigo
            double usado = antigo.getLimite() - antigo.getSaldoDisponivel();
            novo.usarSaldo(usado);

            System.out.println("Novo cartão emitido com sucesso: " + novo.getNumero());
            return novo;
        }

        private static String gerarNumeroCartao() {
            Random rand = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                sb.append(rand.nextInt(10));
            }
            return sb.toString();
        }
        

    
}
