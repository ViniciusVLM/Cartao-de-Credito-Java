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

    // Construtor que inicializa a conexão com o banco
    public DenunciaDao() {
        this.con = new ConnectFactory().getConnection();
    }

    // Cadastra uma nova denúncia no banco de dados
    public void cadastrarDenuncia(Denuncia d) {
        String sql = "INSERT INTO Denuncia (Id_Compra, Id_Cliente, Data_Denuncia, Motivo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getIdCompra());
            ps.setInt(2, d.getIdCliente());
            LocalDate data = d.getDataDenuncia();
            ps.setDate(3, java.sql.Date.valueOf(data)); // Converte LocalDate para Date
            ps.setString(4, d.getMotivo());

            ps.execute(); // Executa a atualização
            JOptionPane.showMessageDialog(null, "Denúncia registrada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar denúncia: " + e.getMessage());
        }
    }
    
    // Processa o reembolso após a denúncia ser aprovada
    public void processarReembolso(int idDenuncia) {
        
        // Atualiza o saldo do cliente somando o valor da compra (se a denúncia for "Compra Fraudulenta")
        String query_AtualizaSaldo = """
            UPDATE Cliente c
            JOIN Denuncia d ON c.Id_Cliente = d.Id_Cliente
            JOIN Compras cp ON d.Id_Compra = cp.Id_Compra
            SET c.Saldo = c.Saldo + cp.Valor_Compra
            WHERE d.Id_Denuncia = ? AND d.Status = 'Compra Fraudulenta';
        """;
        
        // Insere registro no histórico de reembolsos
        String insere_Historico = """
            INSERT INTO HistoricoReembolso (Id_Cliente, Id_Compra, Valor_Reembolsado, Data_Reembolso)
            SELECT d.Id_Cliente, d.Id_Compra, cp.Valor_Compra, CURDATE()
            FROM Denuncia d
            JOIN Compras cp ON d.Id_Compra = cp.Id_Compra
            WHERE d.Id_Denuncia = ?;
        """;
        
         // Atualiza o status da denúncia para "Resolvida"
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
                
                // Define o mesmo ID de denúncia nas três operações
                ps1.setInt(1, idDenuncia);
                ps2.setInt(1, idDenuncia);
                ps3.setInt(1, idDenuncia);
                
                // Executa as operações
                ps1.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();
                
                con.commit(); // Confirma todas as operações
                JOptionPane.showMessageDialog(null, "Reembolso processado e saldo atualizado com sucesso!");
            } catch (Exception e) {
                con.rollback(); // Em caso de erro, desfaz as alterações
                JOptionPane.showMessageDialog(null, "Erro ao processar reembolso: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + e.getMessage());
        }
    }

    
    
}