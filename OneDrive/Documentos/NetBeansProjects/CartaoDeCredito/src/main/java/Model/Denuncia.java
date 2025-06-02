
package Model;

import java.time.LocalDate;

public class Denuncia {
    private int IdDenuncia;
    private int IdCompra;
    private int IdCliente;
    private LocalDate DataDenuncia;
    private String Motivo;
    private String Status;

    public int getIdDenuncia() {
        return IdDenuncia;
    }

    public void setIdDenuncia(int IdDenuncia) {
        this.IdDenuncia = IdDenuncia;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public LocalDate getDataDenuncia() {
        return DataDenuncia;
    }

    public void setDataDenuncia(LocalDate DataDenuncia) {
        this.DataDenuncia = DataDenuncia;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
      
    
    
}
