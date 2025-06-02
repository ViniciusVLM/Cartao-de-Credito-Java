// Inserir/consultar as Compras
// DAO - Objeto de Acesso a Dados
package Dao;

import Connect.ConnectFactory;
import Model.Compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class CompraDao {
    private Connection con;

    public CompraDao() {
        this.con = new ConnectFactory().getConnection();
    }

    // Registrando uma nova Compra
    public void cadastrarCompra(Compras c) {
        String sql = "INSERT INTO Compras (Id_Cartao, Transacao, Valor_Compra, Estabelecimento, Descricao) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getIdCartao());
            LocalDate data = c.getTransacao();
            ps.setDate(2, java.sql.Date.valueOf(data));
            ps.setDouble(3, c.getValorCompra());
            ps.setString(4, c.getEstabelecimento());
            ps.setString(5, c.getDescricao());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra registrada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar uma compra: " + e.getMessage());
        }
    }
}
