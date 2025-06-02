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

    //Cadastrar uma nova Denúncia
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

    //Atualizar o status da Denúncia
    
}

