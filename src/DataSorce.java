import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DataSorce {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}

// 이걸 추상화 시킬 것
// 분리를 시킴


// 알트 엔터
// 오ㅙ 빨간줄 추상 클래스가 나이라

// 변하는 것들만 추상화 해서 만들어 주면 됨
// 변하지 않는것을 추상화 시켜 하위 클래스를 한다.
// 어떤 디자인 패턴?
// 추상메소드를 만든다음에 하위클래서어 구현하게 하는 것을 "템플릿 메소드"
/*
        private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 우리가 받은 것dml th .

        // db와 커넥션을 맺을 것 ctrl p
        // mysql과 연결하는 것
        return DriverManager.getConnection("jdbc:mysql://localhost/hellooo?serverTimezone=GMT", "root","1234");
    }
 */
/*

 */// 시현회에서 사용하기 위해 getconnection을 추상화하면 되겠지?
// 그려면 이 애들을 추상화 시키면 되겠지?
        /*
                Class.forName("com.mysql.cj.jdbc.Driver"); // 우리가 받은 것dml th .

        // db와 커넥션을 맺을 것 ctrl p
        // mysql과 연결하는 것
        return DriverManager.getConnection("jdbc:mysql://localhost/hellooo?serverTimezone=GMT", "root", "1234");

         */

// 데이터 소스가 대신 받았다
//