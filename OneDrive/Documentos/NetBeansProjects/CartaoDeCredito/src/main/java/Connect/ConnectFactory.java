
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectFactory {
    public Connection getConnection() {
        try {
            // Conectando ao banco de dados MySQL (XAMPP)
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vaultbank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo",
                "root", ""); // XAMPP: usuário root, senha vazia
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado: " + e.getMessage()); // Mensagem de erro pra caso não Conectar
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage()); // Mensagem de erro pra caso não Conectar
            return null;
        }
    }
    
}
