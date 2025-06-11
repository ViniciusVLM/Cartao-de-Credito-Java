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

    // Registrando uma nova Compra e atualizando o saldo
    public void cadastrarCompra(Compras cp) {
        String sqlCompra = "INSERT INTO Compras (Id_Cartao, Transacao, Valor_Compra, Estabelecimento, Descricao) VALUES (?, ?, ?, ?, ?)";

        // Atualiza saldo do cliente baseado no ID do cartão
        String sqlAtualizarSaldo = """
            UPDATE Cliente c
            JOIN Cartao ca ON c.Id_Cliente = ca.Id_Cliente
            SET c.Saldo = c.Saldo - ?
            WHERE ca.Id_Cartao = ?;
        """;

        try {
            con.setAutoCommit(false); // Começa transação

            // Inserir a compra
            try (PreparedStatement psCompra = con.prepareStatement(sqlCompra)) {
                psCompra.setInt(1, cp.getIdCartao());
                LocalDate data = cp.getTransacao();
                psCompra.setDate(2, java.sql.Date.valueOf(data));
                psCompra.setDouble(3, cp.getValorCompra());
                psCompra.setString(4, cp.getEstabelecimento());
                psCompra.setString(5, cp.getDescricao());

                psCompra.executeUpdate();
            }

            // Atualizar saldo do cliente
            try (PreparedStatement psSaldo = con.prepareStatement(sqlAtualizarSaldo)) {
                psSaldo.setDouble(1, cp.getValorCompra());
                psSaldo.setInt(2, cp.getIdCartao());

                psSaldo.executeUpdate();
            }

            con.commit(); // Tudo ok, confirma as mudanças
            JOptionPane.showMessageDialog(null, "Compra registrada e saldo atualizado com sucesso!");
        } catch (SQLException e) {
            try {
                con.rollback(); // Erro, desfaz alterações
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao desfazer transação." + e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Erro ao registrar compra: " + e.getMessage());
        } finally {
            try {
                con.setAutoCommit(true); // Volta modo normal
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao redefinir o modo de transação." + e.getMessage());
            }
        }
    }
}
