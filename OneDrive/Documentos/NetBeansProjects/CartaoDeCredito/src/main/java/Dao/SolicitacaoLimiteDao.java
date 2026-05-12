package Dao;

import Connect.ConnectFactory;
import Model.SolicitacaoLimite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoLimiteDao {
    private Connection con;

    public SolicitacaoLimiteDao() {
        this.con = new ConnectFactory().getConnection();
    }

    public boolean cadastrarSolicitacao(SolicitacaoLimite s) {
        String sql = "INSERT INTO Solicitacao_Limite (Id_Cliente, Valor_Solicitado, Status, Data_Solicitacao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getIdCliente());
            ps.setDouble(2, s.getValorSolicitado());
            ps.setString(3, s.getStatus());
            ps.setDate(4, java.sql.Date.valueOf(s.getDataSolicitacao()));
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
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SolicitacaoLimite s = new SolicitacaoLimite();
                s.setIdSolicitacao(rs.getInt("Id_Solicitacao"));
                s.setIdCliente(rs.getInt("Id_Cliente"));
                s.setValorSolicitado(rs.getDouble("Valor_Solicitado"));
                s.setStatus(rs.getString("Status"));
                s.setDataSolicitacao(rs.getDate("Data_Solicitacao").toLocalDate());
                lista.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean atualizarStatus(int idSolicitacao, String status) {
        String sql = "UPDATE Solicitacao_Limite SET Status = ? WHERE Id_Solicitacao = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
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
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSolicitacao);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    SolicitacaoLimite s = new SolicitacaoLimite();
                    s.setIdSolicitacao(rs.getInt("Id_Solicitacao"));
                    s.setIdCliente(rs.getInt("Id_Cliente"));
                    s.setValorSolicitado(rs.getDouble("Valor_Solicitado"));
                    s.setStatus(rs.getString("Status"));
                    s.setDataSolicitacao(rs.getDate("Data_Solicitacao").toLocalDate());
                    return s;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
