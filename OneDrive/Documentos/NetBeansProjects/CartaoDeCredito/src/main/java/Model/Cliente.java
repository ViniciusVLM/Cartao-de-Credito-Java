
package Model;

import java.time.LocalDate;

public class Cliente {
    private int IdCliente;
    private String Nome;
    private String CPF;
    private String RG;
    private String Email;
    private String Telefone;
    private LocalDate DataNascimento;
    private String Nacionalidade;
    private String CEP;
    private String Estado;
    
    public Cliente(){
        
    }
    public Cliente(String Nome, String CPF, String RG, String Email, String Telefone, LocalDate DataNascimento, String Nacionalidade, String CEP, String Estado){
        this.Nome = Nome;
        this.CPF = CPF;
        this.RG = RG;
        this.Email = Email;
        this.Telefone = Telefone;
        this.DataNascimento = DataNascimento;
        this.Nacionalidade = Nacionalidade;
        this.CEP = CEP;
        this.Estado = Estado;
        
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public void setNacionalidade(String Nacionalidade) {
        this.Nacionalidade = Nacionalidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
        
    
    
}
