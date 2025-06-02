

package com.mycompany.cartaodecredito;

import Connect.ConnectFactory;

public class CartaoDeCredito {

    public static void main(String[] args) {
        try{
            ConnectFactory a = new ConnectFactory(); //Conectando o Mysql 
            a.getConnection();
            System.out.println("Conexao estabelecida com sucesso!");
        } catch (Exception e){
            System.out.println("Não foi possível estabelecer a conexão.");
            
        }


            Usuario admin = new Usuario("Admin", "000.000.000-00", "admin123", true);
            Usuario cliente = new Usuario("João", "123.456.789-00", "senha123", false);

            CartaoCredito cartaoJoao = new CartaoCredito("1234567890123456", 2000);

            System.out.println("João usou R$500 do limite.");
            cartaoJoao.usarSaldo(500);

            System.out.println("Saldo restante: R$" + cartaoJoao.getSaldoDisponivel());

            // Tentativa de emitir novo cartão pelo cliente (deve falhar)
            SistemaCartao.emitirNovoCartao(cartaoJoao, cliente);

            // Agora o admin emite um novo cartão (deve funcionar)
            CartaoCredito novoCartao = SistemaCartao.emitirNovoCartao(cartaoJoao, admin);

            if (novoCartao != null) {
                System.out.println("Novo saldo disponível: R$" + novoCartao.getSaldoDisponivel());
            }
        }
    
}
    



