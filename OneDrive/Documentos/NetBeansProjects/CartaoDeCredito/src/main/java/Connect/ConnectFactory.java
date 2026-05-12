
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLException;

public class ConnectFactory {
    public Connection getConnection() {
        try {
            // Lê as variáveis de ambiente (útil para Nuvem/Koyeb)
            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            // Se não encontrar as variáveis (rodando no PC local), usa os valores padrão do XAMPP
            if (url == null || url.isEmpty()) {
                url = "jdbc:mysql://localhost:3306/vaultbank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo";
                user = "root";
                password = "";
            }

            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Erro de conexão com o banco de dados: " + e.getMessage());
            return null;
        }
    }
    
}
