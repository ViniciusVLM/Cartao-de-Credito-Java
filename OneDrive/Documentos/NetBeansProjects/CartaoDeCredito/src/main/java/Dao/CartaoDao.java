//Inserir/consultar um Cartão
// DAO - Objeto de Acesso a Dados
package Dao;

import Connect.ConnectFactory;
import Model.Cartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class CartaoDao {
    private Connection con;
    
    public CartaoDao(){
        this.con = new ConnectFactory().getConnection();
    }
    
    // Registrando um Cartão
    public void cadastrarCartao(Cartao c){
        String sql = "INSERT INTO Cartao (Id_Cliente, Numeros_Cartao, Validade) VALUES (?, ?, ?)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getIdCliente());
            ps.setString(2, c.getNumerosCartao());
            LocalDate data = c.getValidade();
            ps.setDate(3, java.sql.Date.valueOf(data));
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Cartão registrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar o cartão: " + e.getMessage());
        }
    }
}
