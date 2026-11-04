package Dao;

import Model.SolicitacaoLimite;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoLimiteDao {
    private final DataSource dataSource;

    public SolicitacaoLimiteDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean cadastrarSolicitacao(SolicitacaoLimite s) {
        String sql = "INSERT INTO Solicitacao_Limite (Id_Cliente, Valor_Solicitado, Status, Data_Solicitacao) VALUES (?, ?, ?, ?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getIdCliente());
            ps.setDouble(2, s.getValorSolicitado());
            ps.setString(3, s.getStatus());
            ps.setTimestamp(4, Timestamp.valueOf(s.getDataSolicitacao().atStartOfDay()));
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SolicitacaoLimite> listarPendentes() {
        List<SolicitacaoLimite> lista = new ArrayList<>();
        String sql = "SELECT * FROM Solicitacao_Limite WHERE Status = 'Pendente' ORDER BY Data_Solicitacao ASC";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SolicitacaoLimite s = new SolicitacaoLimite();
                s.setIdSolicitacao(rs.getInt("Id_Solicitacao"));
                s.setIdCliente(rs.getInt("Id_Cliente"));
                s.setValorSolicitado(rs.getDouble("Valor_Solicitado"));
                s.setStatus(rs.getString("Status"));
                Timestamp ts = rs.getTimestamp("Data_Solicitacao");
                if (ts != null) {
                    s.setDataSolicitacao(ts.toLocalDateTime().toLocalDate());
                }
                lista.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean atualizarStatus(int idSolicitacao, String status) {
        String sql = "UPDATE Solicitacao_Limite SET Status = ? WHERE Id_Solicitacao = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, idSolicitacao);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public SolicitacaoLimite buscarPorId(int idSolicitacao) {
        String sql = "SELECT * FROM Solicitacao_Limite WHERE Id_Solicitacao = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSolicitacao);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    SolicitacaoLimite s = new SolicitacaoLimite();
                    s.setIdSolicitacao(rs.getInt("Id_Solicitacao"));
                    s.setIdCliente(rs.getInt("Id_Cliente"));
                    s.setValorSolicitado(rs.getDouble("Valor_Solicitado"));
                    s.setStatus(rs.getString("Status"));
                    Timestamp ts = rs.getTimestamp("Data_Solicitacao");
                    if (ts != null) {
                        s.setDataSolicitacao(ts.toLocalDateTime().toLocalDate());
                    }
                    return s;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
