package Dao;

import Model.Cartao;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class CartaoDao {
    private final DataSource dataSource;

    public CartaoDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean cadastrarCartao(Cartao c) {
        String sql = "INSERT INTO Cartao (Id_Cliente, Numeros_Cartao, Validade) VALUES (?, ?, ?)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getIdCliente());
            ps.setString(2, c.getNumerosCartao());
            ps.setTimestamp(3, Timestamp.valueOf(c.getValidade().atStartOfDay()));

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
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cartao c = new Cartao();
                    c.setIdCartao(rs.getInt("Id_Cartao"));
                    c.setIdCliente(rs.getInt("Id_Cliente"));
                    c.setNumerosCartao(rs.getString("Numeros_Cartao"));
                    Timestamp val = rs.getTimestamp("Validade");
                    if (val != null) {
                        c.setValidade(val.toLocalDateTime().toLocalDate());
                    }
                    cartoes.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartoes;
    }
}
