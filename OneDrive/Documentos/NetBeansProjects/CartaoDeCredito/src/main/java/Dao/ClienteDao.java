//Inserir/consultar um Cliente
// DAO - Objeto de Acesso a Dados
package Dao;

import Connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import Model.Cliente;

public class ClienteDao {
    private Connection con;
    
    
    public ClienteDao () {
        this.con = new ConnectFactory().getConnection();
    }
    
    public void CadastrarUsuario(Cliente c) {
        String sql = "INSERT INTO Cliente (Nome, CPF, RG, Email, Telefone, "
                + "Data_Nascimento, Nacionalidade, CEP, Estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCPF());
            ps.setString(3, c.getRG());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getTelefone());
            LocalDate data = c.getDataNascimento();
            ps.setDate(6, java.sql.Date.valueOf(data));
            ps.setString(7, c.getNacionalidade());
            ps.setString(8, c.getCEP());
            ps.setString(9, c.getEstado());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar realizar o cadastro do usuário." + e.getMessage());
        }
    }
    
    
}
