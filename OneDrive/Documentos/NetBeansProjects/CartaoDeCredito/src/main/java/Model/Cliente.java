
package Model;

import com.mycompany.cartaodecredito.Usuario;
import java.time.LocalDate;

  public class Cliente extends Usuario {
    private int idCliente;
    private String rg;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private String cep;
    private String estado;

   public Cliente(String nome, String cpf, String senha, boolean isAdmin,
               String rg, String email, String telefone,
               LocalDate dataNascimento, String nacionalidade,
               String cep, String estado) {

    super(nome, cpf, senha, isAdmin); 

    this.rg = rg;
    this.email = email;
    this.telefone = telefone;
    this.dataNascimento = dataNascimento;
    this.nacionalidade = nacionalidade;
    this.cep = cep;
    this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Polimorfismo: sobrescrevendo método
    public void exibirPerfil() {
        System.out.println("Cliente: " + getNome() + ", Email: " + getEmail());
    }
}
    
        
    
    

