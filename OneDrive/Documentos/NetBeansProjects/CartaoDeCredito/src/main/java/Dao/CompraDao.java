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

     // Construtor que obtém a conexão com o banco de dados
    public CompraDao() {
        this.con = new ConnectFactory().getConnection();
    }

    // Cadastra uma nova compra e atualiza o saldo do cliente
    public void cadastrarCompra(Compras cp) {
        
        // SQL para inserir nova compra
        String sqlCompra = "INSERT INTO Compras (Id_Cartao, Transacao, Valor_Compra, Estabelecimento, Descricao) VALUES (?, ?, ?, ?, ?)";

        
        // Atualiza saldo do cliente baseado no ID do cartão
        
        // SQL para atualizar o saldo do cliente vinculado ao cartão
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

                psCompra.executeUpdate(); // Executa a atualização
            }

            // Atualização do saldo do cliente
            try (PreparedStatement psSaldo = con.prepareStatement(sqlAtualizarSaldo)) {
                psSaldo.setDouble(1, cp.getValorCompra());
                psSaldo.setInt(2, cp.getIdCartao());

                psSaldo.executeUpdate(); // Executa a atualização
            }

            con.commit(); // Confirma todas as operações
            JOptionPane.showMessageDialog(null, "Compra registrada e saldo atualizado com sucesso!");
        } catch (SQLException e) {
            try {
                con.rollback(); // Em caso de erro, desfaz as alterações
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao desfazer transação." + e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Erro ao registrar compra: " + e.getMessage());
        } finally {
            try {
                con.setAutoCommit(true); // Retorna ao modo automático de commit
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao redefinir o modo de transação." + e.getMessage());
            }
        }
    }
}
