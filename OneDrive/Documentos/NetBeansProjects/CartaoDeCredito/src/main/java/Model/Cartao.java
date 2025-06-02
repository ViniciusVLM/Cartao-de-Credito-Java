
package Model;

import java.time.LocalDate;

public class Cartao {
    private int IdCartao;
    private int IdCliente;
    private String NumerosCartao;
    private LocalDate Validade;
    
    public Cartao() {
        
    }
    public Cartao(int IdCartao, int IdCliente, String NumerosCartao, LocalDate Validade) {
        this.IdCartao = IdCartao;
        this.IdCliente = IdCliente;
        this.NumerosCartao = NumerosCartao;
        this.Validade = Validade;

    }

    public int getIdCartao() {
        return IdCartao;
    }

    public void setIdCartao(int IdCartao) {
        this.IdCartao = IdCartao;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNumerosCartao() {
        return NumerosCartao;
    }

    public void setNumerosCartao(String NumerosCartao) {
        this.NumerosCartao = NumerosCartao;
    }

    public LocalDate getValidade() {
        return Validade;
    }

    public void setValidade(LocalDate Validade) {
        this.Validade = Validade;
    }
    
}
