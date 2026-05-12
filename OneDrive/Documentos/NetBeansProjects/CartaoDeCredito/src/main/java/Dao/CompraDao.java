package Dao;

import Connect.ConnectFactory;
import Model.Compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class CompraDao {
    private Connection con;

     // Construtor que obtém a conexão com o banco de dados
    public CompraDao() {
        this.con = new ConnectFactory().getConnection();
    }

    public boolean cadastrarCompra(Compras cp) {
        String sqlCompra = "INSERT INTO Compras (Id_Cartao, Transacao, Valor_Compra, Estabelecimento, Descricao) VALUES (?, ?, ?, ?, ?)";
        String sqlAtualizarSaldo = """
            UPDATE Cliente c
            JOIN Cartao ca ON c.Id_Cliente = ca.Id_Cliente
            SET c.Saldo = c.Saldo - ?
            WHERE ca.Id_Cartao = ?;
        """;

        try {
            con.setAutoCommit(false);
            try (PreparedStatement psCompra = con.prepareStatement(sqlCompra)) {
                psCompra.setInt(1, cp.getIdCartao());
                LocalDate data = cp.getTransacao();
                psCompra.setDate(2, java.sql.Date.valueOf(data));
                psCompra.setDouble(3, cp.getValorCompra());
                psCompra.setString(4, cp.getEstabelecimento());
                psCompra.setString(5, cp.getDescricao());
                psCompra.executeUpdate();
            }

            try (PreparedStatement psSaldo = con.prepareStatement(sqlAtualizarSaldo)) {
                psSaldo.setDouble(1, cp.getValorCompra());
                psSaldo.setInt(2, cp.getIdCartao());
                psSaldo.executeUpdate();
            }

            con.commit();
            return true;
        } catch (SQLException e) {
            try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
            return false;
        } finally {
            try { con.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public List<Compras> listarComprasPorCliente(int idCliente) {
        List<Compras> compras = new ArrayList<>();
        String sql = """
            SELECT cp.* 
            FROM Compras cp
            JOIN Cartao ca ON cp.Id_Cartao = ca.Id_Cartao
            WHERE ca.Id_Cliente = ?
            ORDER BY cp.Transacao DESC
        """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Compras c = new Compras();
                    c.setIdCompra(rs.getInt("Id_Compra"));
                    c.setIdCartao(rs.getInt("Id_Cartao"));
                    c.setTransacao(rs.getDate("Transacao").toLocalDate());
                    c.setValorCompra(rs.getDouble("Valor_Compra"));
                    c.setEstabelecimento(rs.getString("Estabelecimento"));
                    c.setDescricao(rs.getString("Descricao"));
                    compras.add(c);
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return compras;
    }
}
