//Inserir/consultar uma denúncia
// DAO - Objeto de Acesso a Dados
package Dao;

import Connect.ConnectFactory;
import Model.Denuncia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DenunciaDao {
    private Connection con;

    public DenunciaDao() {
        this.con = new ConnectFactory().getConnection();
    }

    //Cadastrar uma nova denúncia
    public void cadastrarDenuncia(Denuncia d) {
        String sql = "INSERT INTO Denuncia (Id_Compra, Id_Cliente, Data_Denuncia, Motivo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getIdCompra());
            ps.setInt(2, d.getIdCliente());
            ps.setDate(3, java.sql.Date.valueOf(d.getDataDenuncia()));
            ps.setString(4, d.getMotivo());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Denúncia registrada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar denúncia: " + e.getMessage());
        }
    }

    //Atualizar o status da denúncia
public void atualizarStatus(int idDenuncia, String novoStatus) {
    String sql = "UPDATE Denuncia SET Status = ? WHERE Id_Denuncia = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, novoStatus);
        ps.setInt(2, idDenuncia);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Status da denúncia atualizado com sucesso!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar status: " + e.getMessage());
    }
}
}

