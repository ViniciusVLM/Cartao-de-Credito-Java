package Connect;

import java.sql.Connection;
import java.sql.Statement;

public class DBCreationHelper {
    public static void main(String[] args) {
        ConnectFactory factory = new ConnectFactory();
        Connection con = factory.getConnection();
        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS Solicitacao_Limite (" +
                             "Id_Solicitacao INT PRIMARY KEY AUTO_INCREMENT, " +
                             "Id_Cliente INT, " +
                             "Valor_Solicitado DECIMAL(10,2), " +
                             "Status VARCHAR(20) DEFAULT 'Pendente', " +
                             "Data_Solicitacao DATE, " +
                             "FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente))";
                stmt.execute(sql);
                System.out.println("Tabela Solicitacao_Limite criada com sucesso!");
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro ao conectar no banco de dados.");
        }
    }
}
