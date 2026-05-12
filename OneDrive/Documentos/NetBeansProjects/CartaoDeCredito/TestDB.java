import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaultbank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo", "root", "");
            String sql = "INSERT INTO Cliente (Nome, CPF, RG, Email, Telefone, Data_Nascimento, Nacionalidade, CEP, Estado, isAdmin, Senha, Saldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Teste");
            ps.setString(2, "111.111.111-11");
            ps.setString(3, "11.111.111-1");
            ps.setString(4, "t@t.com");
            ps.setString(5, "(11) 11111-1111");
            ps.setDate(6, java.sql.Date.valueOf(LocalDate.parse("1990-01-01")));
            ps.setString(7, "BR");
            ps.setString(8, "00000-000");
            ps.setString(9, "SP");
            ps.setBoolean(10, false);
            ps.setString(11, "senha");
            ps.setBigDecimal(12, new BigDecimal("0.0"));
            ps.execute();
            System.out.println("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
