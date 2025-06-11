package Dao;

import Connect.ConnectFactory;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ClienteDao {
    private Connection con;

    public ClienteDao() {
        this.con = new ConnectFactory().getConnection();
    }

    // Cadastro de novo cliente
    public void CadastrarUsuario(Cliente c) {
        String sql = "INSERT INTO Cliente (Nome, CPF, RG, Email, Telefone, " +
                     "Data_Nascimento, Nacionalidade, CEP, Estado, isAdmin, Senha, Saldo) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCPF());
            ps.setString(3, c.getRG());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getTelefone());
            ps.setDate(6, java.sql.Date.valueOf(c.getDataNascimento()));
            ps.setString(7, c.getNacionalidade());
            ps.setString(8, c.getCEP());
            ps.setString(9, c.getEstado());
            ps.setBoolean(10, c.getIsAdmin());
            ps.setString(11, c.getSenha());
            ps.setDouble(12, c.getSaldo());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar realizar o cadastro do usuário: " + e.getMessage());
        }
    }

    // Autenticação de login por CPF e senha
    public Cliente autenticar(String CPF, String Senha) {
        String sql = "SELECT * FROM Cliente WHERE CPF = ? AND Senha = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, CPF);
            ps.setString(2, Senha);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("Id_Cliente"));
                c.setNome(rs.getString("Nome"));
                c.setCPF(rs.getString("CPF"));
                c.setRG(rs.getString("RG"));
                c.setEmail(rs.getString("Email"));
                c.setTelefone(rs.getString("Telefone"));
                c.setDataNascimento(rs.getDate("Data_Nascimento").toLocalDate());
                c.setNacionalidade(rs.getString("Nacionalidade"));
                c.setCEP(rs.getString("CEP"));
                c.setEstado(rs.getString("Estado"));
                c.setIsAdmin(rs.getBoolean("isAdmin"));
                c.setSenha(rs.getString("Senha"));
                c.setSaldo(rs.getDouble("Saldo"));
                return c;
            } else {
                JOptionPane.showMessageDialog(null, "CPF ou senha inválidos.");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + e.getMessage());
            return null;
        }
    }
}