import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JejuDataSorce implements DataSorce {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 우리가 받은 것dml th .

            // db와 커넥션을 맺을 것 ctrl p
            // mysql과 연결하는 것
            return DriverManager.getConnection("jdbc:mysql://localhost/hellooo?serverTimezone=GMT", "root", "1234");


    }
}
