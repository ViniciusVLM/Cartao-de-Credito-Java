package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InstaladorNuvem {
    public static void main(String[] args) {
        // =========================================================================
        // COLOQUE AQUI AS INFORMAÇÕES QUE ESTÃO NA TELA DO AIVEN
        // =========================================================================
        
        // 1. Substitua pelo seu Hospedar (Host) e Porta. Exemplo: jdbc:mysql://mysql-xyz.aivencloud.com:12345/defaultdb?sslMode=REQUIRED
        String url = "jdbc:mysql://mysql-26e4b110-vini172006v-804f.f.aivencloud.com:13291/defaultdb?sslMode=REQUIRED";
        
        // 2. Substitua pelo Usuário (Geralmente avnadmin)
        String user = "avnadmin";
        
        // 3. Substitua pela sua Senha (Clique no olho ou copie a senha na tela do Aiven)
        String password = "SUA_SENHA_AQUI"; 

        try {
            System.out.println("Conectando ao banco de dados na nuvem...");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso! Criando tabelas...");

            Statement stmt = con.createStatement();

            // Tabela Cliente
            stmt.execute("CREATE TABLE IF NOT EXISTS Cliente (" +
                    "Id_Cliente INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Nome VARCHAR(100), " +
                    "CPF VARCHAR(14) UNIQUE, " +
                    "RG VARCHAR(20), " +
                    "Email VARCHAR(100), " +
                    "Telefone VARCHAR(20), " +
                    "Data_Nascimento DATE, " +
                    "Nacionalidade VARCHAR(50), " +
                    "CEP VARCHAR(10), " +
                    "Estado VARCHAR(50), " +
                    "isAdmin BOOLEAN DEFAULT FALSE, " +
                    "Senha VARCHAR(100), " +
                    "Saldo DECIMAL(10,2) DEFAULT 0.00)");

            // Tabela Cartao
            stmt.execute("CREATE TABLE IF NOT EXISTS Cartao (" +
                    "Id_Cartao INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Id_Cliente INT, " +
                    "Numeros_Cartao VARCHAR(20), " +
                    "Validade DATE, " +
                    "FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente))");

            // Tabela Compras
            stmt.execute("CREATE TABLE IF NOT EXISTS Compras (" +
                    "Id_Compra INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Id_Cartao INT, " +
                    "Transacao DATE, " +
                    "Valor_Compra DECIMAL(10,2), " +
                    "Estabelecimento VARCHAR(100), " +
                    "Descricao VARCHAR(255), " +
                    "FOREIGN KEY (Id_Cartao) REFERENCES Cartao(Id_Cartao))");

            // Tabela Denuncia
            stmt.execute("CREATE TABLE IF NOT EXISTS Denuncia (" +
                    "Id_Denuncia INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Id_Compra INT, " +
                    "Id_Cliente INT, " +
                    "Motivo VARCHAR(255), " +
                    "Status VARCHAR(20) DEFAULT 'Pendente', " +
                    "Data_Denuncia DATE, " +
                    "FOREIGN KEY (Id_Compra) REFERENCES Compras(Id_Compra), " +
                    "FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente))");

            // Tabela Historico_Reembolso
            stmt.execute("CREATE TABLE IF NOT EXISTS Historico_Reembolso (" +
                    "Id_Reembolso INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Id_Denuncia INT, " +
                    "Id_Cliente INT, " +
                    "Valor_Reembolsado DECIMAL(10,2), " +
                    "Data_Reembolso DATE, " +
                    "FOREIGN KEY (Id_Denuncia) REFERENCES Denuncia(Id_Denuncia), " +
                    "FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente))");

            // Tabela Solicitacao_Limite
            stmt.execute("CREATE TABLE IF NOT EXISTS Solicitacao_Limite (" +
                    "Id_Solicitacao INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Id_Cliente INT, " +
                    "Valor_Solicitado DECIMAL(10,2), " +
                    "Status VARCHAR(20) DEFAULT 'Pendente', " +
                    "Data_Solicitacao DATE, " +
                    "FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente))");

            System.out.println("Todas as tabelas foram criadas com sucesso na nuvem!");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ou criar tabelas: " + e.getMessage());
        }
    }
}
