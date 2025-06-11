//Inserir/consultar uma denúncia
// DAO - Objeto de Acesso a Dados
package Dao;

import Connect.ConnectFactory;
import Model.Denuncia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class DenunciaDao {
    private Connection con;

    public DenunciaDao() {
        this.con = new ConnectFactory().getConnection();
    }

    //Cadastrar uma nova Denúncia
    public void cadastrarDenuncia(Denuncia d) {
        String sql = "INSERT INTO Denuncia (Id_Compra, Id_Cliente, Data_Denuncia, Motivo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getIdCompra());
            ps.setInt(2, d.getIdCliente());
            LocalDate data = d.getDataDenuncia();
            ps.setDate(3, java.sql.Date.valueOf(data));
            ps.setString(4, d.getMotivo());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Denúncia registrada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar denúncia: " + e.getMessage());
        }
    }
    
    public void processarReembolso(int idDenuncia) {
        String query_AtualizaSaldo = """
            UPDATE Cliente c
            JOIN Denuncia d ON c.Id_Cliente = d.Id_Cliente
            JOIN Compras cp ON d.Id_Compra = cp.Id_Compra
            SET c.Saldo = c.Saldo + cp.Valor_Compra
            WHERE d.Id_Denuncia = ? AND d.Status = 'Compra Fraudulenta';
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
            con.setAutoCommit(false);  // Começa transação

            try (PreparedStatement ps1 = con.prepareStatement(query_AtualizaSaldo);
                 PreparedStatement ps2 = con.prepareStatement(insere_Historico);
                 PreparedStatement ps3 = con.prepareStatement(atualiza_Status_Denuncia)) {

                ps1.setInt(1, idDenuncia);
                ps2.setInt(1, idDenuncia);
                ps3.setInt(1, idDenuncia);

                ps1.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();

                con.commit(); // Tudo ok, confirma as mudanças
                JOptionPane.showMessageDialog(null, "Reembolso processado e saldo atualizado com sucesso!");
            } catch (Exception e) {
                con.rollback(); // Erro, desfaz alterações
                JOptionPane.showMessageDialog(null, "Erro ao processar reembolso: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + e.getMessage());
        }
    }

    
    
}