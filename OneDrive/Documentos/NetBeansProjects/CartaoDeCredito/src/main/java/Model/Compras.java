
package Model;

import java.time.LocalDate;

public class Compras {
    private int IdCompra;
    private int IdCartao;
    private LocalDate Transacao;
    private double ValorCompra;
    private String Estabelecimento;
    private String Descricao;
    
    public Compras() {
        
    }
    public Compras (int IdCompra, int IdCartao, LocalDate Transacao, double ValorCompra, String Estabelecimento, String Descricao) {
        this.IdCompra = IdCompra;
        this.IdCartao = IdCartao;
        this.Transacao = Transacao;
        this.ValorCompra = ValorCompra;
        this.Estabelecimento = Estabelecimento;
        this.Descricao = Descricao;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public int getIdCartao() {
        return IdCartao;
    }

    public void setIdCartao(int IdCartao) {
        this.IdCartao = IdCartao;
    }

    public LocalDate getTransacao() {
        return Transacao;
    }

    public void setTransacao(LocalDate Transacao) {
        this.Transacao = Transacao;
    }

    public double getValorCompra() {
        return ValorCompra;
    }

    public void setValorCompra(double ValorCompra) {
        this.ValorCompra = ValorCompra;
    }

    public String getEstabelecimento() {
        return Estabelecimento;
    }

    public void setEstabelecimento(String Estabelecimento) {
        this.Estabelecimento = Estabelecimento;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
}
