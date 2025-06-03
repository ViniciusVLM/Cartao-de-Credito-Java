
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectFactory {
    public Connection getConnection() {
        try {
            System.out.println("Chupa Palmeiras");
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cloud", "Admin", "Admin008890"); // Conectando o Banco de dados
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado: " + e.getMessage()); // Mensagem de erro pra caso não Conectar
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage()); // Mensagem de erro pra caso não Conectar
            return null;
        }
    }
    
}
