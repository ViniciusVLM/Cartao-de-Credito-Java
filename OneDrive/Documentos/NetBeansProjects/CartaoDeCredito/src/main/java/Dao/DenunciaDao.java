package Dao;

import Connect.ConnectFactory;
import Model.Denuncia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DenunciaDao {
    private Connection con;

    public DenunciaDao() {
        this.con = new ConnectFactory().getConnection();
    }

    public boolean cadastrarDenuncia(Denuncia d) {
        String sql = "INSERT INTO Denuncia (Id_Compra, Id_Cliente, Data_Denuncia, Motivo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getIdCompra());
            ps.setInt(2, d.getIdCliente());
            LocalDate data = d.getDataDenuncia();
            ps.setDate(3, java.sql.Date.valueOf(data));
            ps.setString(4, d.getMotivo());

            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean processarReembolso(int idDenuncia) {
        String query_AtualizaSaldo = """
            UPDATE Cliente c
            JOIN Denuncia d ON c.Id_Cliente = d.Id_Cliente
            JOIN Compras cp ON d.Id_Compra = cp.Id_Compra
            SET c.Saldo = c.Saldo + cp.Valor_Compra
            WHERE d.Id_Denuncia = ? AND d.Status = 'Pendente';
        """;
        
        String insere_Historico = """
            INSERT INTO HistoricoReembolso (Id_Cliente, Id_Compra, Valor_Reembolsado, Data_Reembolso)
            SELECT d.Id_Cliente, d.Id_Compra, cp.Valor_Compra, CURDATE()
            FROM Denuncia d
            JOIN Compras cp ON d.Id_Compra = cp.Id_Compra
            WHERE d.Id_Denuncia = ?;
        """;
        
        String atualiza_Status_Denuncia = """
            UPDATE Denuncia
            SET Status = 'Resolvida'
            WHERE Id_Denuncia = ?;
        """;
        
        try (Connection con = new ConnectFactory().getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement ps1 = con.prepareStatement(query_AtualizaSaldo);
                 PreparedStatement ps2 = con.prepareStatement(insere_Historico);
                 PreparedStatement ps3 = con.prepareStatement(atualiza_Status_Denuncia)) {
                
                ps1.setInt(1, idDenuncia);
                ps2.setInt(1, idDenuncia);
                ps3.setInt(1, idDenuncia);
                
                ps1.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();
                
                con.commit();
                return true;
            } catch (Exception e) {
                con.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public List<Map<String, Object>> listarDenunciasPendentes() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = """
            SELECT d.Id_Denuncia, d.Motivo, d.Status, c.Nome, cp.Valor_Compra, c.Id_Cliente
            FROM Denuncia d
            JOIN Compras cp ON d.Id_Compra = cp.Id_Compra
            JOIN Cliente c ON d.Id_Cliente = c.Id_Cliente
            WHERE d.Status NOT IN ('Resolvida', 'Cancelada')
            ORDER BY d.Id_Denuncia
        """;

        try (Connection con = new ConnectFactory().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idDenuncia", rs.getInt("Id_Denuncia"));
                map.put("nomeCliente", rs.getString("Nome"));
                map.put("motivo", rs.getString("Motivo"));
                map.put("status", rs.getString("Status"));
                map.put("valorCompra", rs.getDouble("Valor_Compra"));
                map.put("idCliente", rs.getInt("Id_Cliente"));
                lista.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public List<Map<String, Object>> listarReembolsosPorCliente(int idCliente) {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = """
            SELECT hr.Id_Reembolso, hr.Id_Compra, hr.Valor_Reembolsado, hr.Data_Reembolso, cp.Estabelecimento
            FROM HistoricoReembolso hr
            JOIN Compras cp ON hr.Id_Compra = cp.Id_Compra
            WHERE hr.Id_Cliente = ?
        """;

        try (Connection con = new ConnectFactory().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("idReembolso", rs.getInt("Id_Reembolso"));
                    map.put("idCompra", rs.getInt("Id_Compra"));
                    map.put("valorReembolsado", rs.getDouble("Valor_Reembolsado"));
                    map.put("dataReembolso", rs.getDate("Data_Reembolso").toString());
                    map.put("estabelecimento", rs.getString("Estabelecimento"));
                    lista.add(map);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Map<String, Object>> listarTodosReembolsos() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = "SELECT * FROM HistoricoReembolso";

        try (Connection con = new ConnectFactory().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("idReembolso", rs.getInt("Id_Reembolso"));
                map.put("idCliente", rs.getInt("Id_Cliente"));
                map.put("idCompra", rs.getInt("Id_Compra"));
                map.put("valorReembolsado", rs.getDouble("Valor_Reembolsado"));
                map.put("dataReembolso", rs.getDate("Data_Reembolso").toString());
                lista.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}