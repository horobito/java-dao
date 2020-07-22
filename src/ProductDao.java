//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class ProductDao {
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver"); // 우리가 받은 것dml th .
//        // 마음대로 갈아끼우면 된다.
//
//        // db와 커넥션을 맺을 것 ctrl p
//        // mysql과 연결하는 것
//        return DriverManager.getConnection("jdbc:mysql://localhost/hellooo?serverTimezone=GMT", "root","1234");
//        // 문제가 있다
//
//        // 모든 dAO 에는 커넥션이 되야 샐행되니깐
//        // 코드를 수정하지 않게 하기 위해
//        // 또 추상화 , 또 seoul 등 하는 것!!!!!!!!!!!!!!!!
//        // 여러가지 갈아끼울 방법을 쓰려고 햇는데
//        // 유저든 상품이든 같은 것을 적어야 했다
//        // 중복 코드를 줄이기 위해 짬을 때려 해결보려 했는데
//        // 템플릿 메소드 페턴이 잘 안되버림
//        // 너무 슬퍼
//        // 자 그래서 어떻게 할까?
//        // 그걸 위해서 다시 원상태 UserDAO 즉, 요구사항 전 과거로 돌아가보자
//
//
//    public void get(){
//
//
//    }
//
//    public void insert(){
//
//    }
//} ctrl /
