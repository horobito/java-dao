//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class Seoul extends UserDAO {
//    @Override
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // 우리가 받은 것dml th .
//        // 마음대로 갈아끼우면 된다.
//
//            // db와 커넥션을 맺을 것 ctrl p
//            // mysql과 연결하는 것
//            return DriverManager.getConnection("jdbc:mysql://localhost/hellooo?serverTimezone=GMT", "root","1234");
//       // 문제가 있다
//        // userDAO만 만들면 좋은데
//        // 상품 DAO를 만들자 해보자
//    }
//}
