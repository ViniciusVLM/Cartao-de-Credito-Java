//Inserir/consultar um Cartão
// DAO - Objeto de Acesso a Dados
package Dao;

import Connect.ConnectFactory;
import Model.Cartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class CartaoDao {
    private Connection con;
    
    public CartaoDao(){
        this.con = new ConnectFactory().getConnection();
    }
    
    public boolean cadastrarCartao(Cartao c){
        String sql = "INSERT INTO Cartao (Id_Cliente, Numeros_Cartao, Validade) VALUES (?, ?, ?)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getIdCliente());
            ps.setString(2, c.getNumerosCartao());
            LocalDate data = c.getValidade();
            ps.setDate(3, java.sql.Date.valueOf(data));
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cartao> buscarCartoesPorCliente(int idCliente) {
        List<Cartao> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM Cartao WHERE Id_Cliente = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cartao c = new Cartao();
                    c.setIdCartao(rs.getInt("Id_Cartao"));
                    c.setIdCliente(rs.getInt("Id_Cliente"));
                    c.setNumerosCartao(rs.getString("Numeros_Cartao"));
                    c.setValidade(rs.getDate("Validade").toLocalDate());
                    cartoes.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartoes;
    }
}
