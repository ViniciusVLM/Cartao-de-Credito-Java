package com.mycompany.cartaodecredito;
import Model.Compras;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Historico {
   private List<Compras> compras;

   public Historico() {
        this.compras = new ArrayList<>();

    }
   public void exibirHistorico() {
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra registrada.");
            return;
        }
        for (Compras compra : compras) {
            System.out.printf("[%s] %s - R$%.2f em %s (ID Cartão: %d)",
                    compra.getTransacao(),
                    compra.getDescricao(),
                    compra.getValorCompra(),
                    compra.getEstabelecimento(),
                    compra.getIdCartao());
        }
    }

    // filtro por mês e ano
    public void exibirPorMesEAno(int mes, int ano) {
        List<Compras> filtradas = compras.stream()
            .filter(c -> c.getTransacao().getMonthValue() == mes && c.getTransacao().getYear() == ano)
            .collect(Collectors.toList());

        if (filtradas.isEmpty()) {
            System.out.printf("Nenhuma compra encontrada para %02d/%d", mes, ano);
        } else {
            for (Compras compra : filtradas) {
                System.out.printf("[%s] %s - R$%.2f em %s (ID Cartão: %d)",
                        compra.getTransacao(),
                        compra.getDescricao(),
                        compra.getValorCompra(),
                        compra.getEstabelecimento(),
                        compra.getIdCartao());
            }
        }
    }

    //filtro por ID do cartão
    public void exibirPorCartao(int idCartao) {
        List<Compras> filtradas = compras.stream()
            .filter(c -> c.getIdCartao() == idCartao)
            .collect(Collectors.toList());

        if (filtradas.isEmpty()) {
            System.out.printf("Nenhuma compra encontrada para o cartão com ID %d", idCartao);
        } else {
            for (Compras compra : filtradas) {
                System.out.printf("[%s] %s - R$%.2f em %s",
                        compra.getTransacao(),
                        compra.getDescricao(),
                        compra.getValorCompra(),
                        compra.getEstabelecimento());
            }
        }
    }
}
        
        
   
   
   
   

        
   
   

    

    

