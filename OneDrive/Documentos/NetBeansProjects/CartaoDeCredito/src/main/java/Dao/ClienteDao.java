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
    
    public void CadastrarUsuario(Cliente a) {
        String sql = "INSERT INTO Cliente (Nome, CPF, RG, Email, Telefone, Data_Nascimento, Nacionalidade, CEP, Estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, a.getNome());
            ps.setString(2, a.getCPF());
            ps.setString(3, a.getRG());
            ps.setString(4, a.getEmail());
            ps.setString(5, a.getTelefone());
            LocalDate data = a.getDataNascimento();
            ps.setDate(6, java.sql.Date.valueOf(data));
            ps.setString(7, a.getNacionalidade());
            ps.setString(8, a.getCEP());
            ps.setString(9, a.getEstado());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar realizar o cadastro do usuário." + e.getMessage());
        }
    }
    
    
}
