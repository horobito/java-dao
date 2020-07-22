import java.sql.*;

public  class UserDAO {
    private final DataSorce dataSorce;

    public UserDAO(DataSorce dataSorce){
        this.dataSorce = dataSorce;
    }
    // 필드(=멤버변수) 에다가 데이터소ㅅ가 붙어버렸구ㅜ먼
    // 이런 방식으로 refactoring을 할 수 있다.~!!!!!!
    // 빨간줄이 남아있음
    // 데이터소스는 어느곳에 따라 달라질수 있다.
    // ㄱ러면 어떻게??
    // new datasorce에 강ㅎ게 의존하고 있다.
    // 그러면 의존성을 짬때린다
    /*
        private final DataSorce dataSorce = new DataSorce();
     */
    // 짬을 때렸으면 짬은 그 위층에 가겠지?
    // user dao 에 잇다.
    public User get(Integer id) throws ClassNotFoundException, SQLException {
        // 이제부터  모든 것이 시작
        // 깔았던 것을 받을 것
        // mysql 드라이버를 로딩하는 것

        Connection connection = dataSorce.getConnection();

        // 연결을 했으면 쿼리를 때려야지? 즉 명령어를 때려야지?
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT id, name, password From user Where id = ?");
        preparedStatement.setInt(1,id);
        // 쿼리를 만들었으면 쿼리를 샐행해야해
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next(); // 커서를 내려준다. 마치 엔터치듯이
        // 자바 입장에서 쿼리를 처음 실행시킬때는
        // id name password 쪽에 잇다.
        // 그래서 이걸 볼려면 한번 내려줘야 한다.
        // 어떻게 보면 쿼리 자체가
        // 결과갑
        // result 셋이 처음 바라보는 부분은 어정쩡한 곳
        // 우리가 알고싶은 것은 그 아랫부분
        // 그러면 엔터 치듯이 커서를 내려줘야 한다.
        // 그 커서를 내려주는 작업이 resultSet.next();

        User user = new User();
        user.setId(resultSet.getInt("id"));
        // 위 id 는 결과값의 아이디
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        // 연 순서대로 닫아라
        // 똥을 잘 쌌으면 물을 잘 내려야 함
        // 연결을 끊는것
        // 물을 잘 안내리면 메모리 릭이 발생
        // 즉 메모리나 누출됨
        // 메모리를 잡아먹는 애들이 계속 남는것
        // 마치 대변기에 찌꺼기가 남는 것
        resultSet.close(); //닫아야 한다.
        preparedStatement.close();
        connection.close();
        // 요새는 자동대로 해주지만, 명시적으로 적어주는 것이 좋다. // 콘솔창을 띄이이이이이이어
        // 알아서 잘 도와준다 하더락도, 그것을 신뢰하는 것은 다른 문제

        // 물을 잘 내렷으니 만들어준 유저를 반납해야겠죠?
        return user;

    }

    /*
        public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
     */


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
            private Connection getConnection() throws ClassNotFoundException, SQLException {

            // db와 커넥션을 맺을 것 ctrl p
        // mysql과 연결하는 것
            return dataSorce.getConnection();
        }
        // 이 코드를 지우고
     */

    // 필드 : 멤버변수
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
// 어디서부터 시작해야 할까???? 두근두근 파라다이스
    // 답은  위의 애를 짬을 때려서 커넥션을 위임해주는 것을 쓴다.
    //


    // 시현 문제의 경우 위 53-58만 갈아끼우면 된다.
    // 변하는 게 있고, 변하지 않는 것이 있다.
    // 변하는 것을 추상화

    public Integer insert(User user) throws SQLException, ClassNotFoundException {

        Connection connection = dataSorce.getConnection();
        // 연결을 했으면 쿼리를 때려야지? 즉 명령어를 때려야지?
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO user(name, password) VALUES (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());// 첫번째 물음표

        // 자,
        // 이번에는 따로 결과가 없다.
        preparedStatement.executeUpdate();
        // 그냥 업데이트 하면 된다.

        // 그리고, 아이디를 받아온느 것은
        preparedStatement = connection.prepareStatement("SELECT last_insert_id()");
        // 마지막을 담은 것을 받아온다.

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Integer id = resultSet.getInt(1);
        // 제일 마지막에 insert 한 아이디임
        // 그리고 다 받아왓으면 닫아야 한다.

        resultSet.close();;
        preparedStatement.close();
        connection.close();


        return id;
        // insert도 db를 연결하는 것을 해야 하잔아?
        // 그러면 또 같은 짓을 계속 해야 해??!?!
        // 계발자는 게을러야 한다.
        // 그러면 어떠허게 해야할까?
        // 끄집어 오면 된다. 어떻게
        // 시현회에 와서 데이터 소스를 갈아끼우고 싶어요
        // 데이터 소스를 박아
    }
}
// 중복되는 코드를 줄이기 위해 이 짓거리들을 해왔다.
// 게으른 개발자가 되어라 - 왜 게으른가?
// 복붙하지 말고, 잇는 코드 쓰는 것이 목표이다.
// 전에 스프링이란 것을 공부했잖아?
// ㅇㅇㅇ 코드를 줄이고 싶은 것!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 끝내준다. - 게으른 개발자가 되어자 - 그게 ㅁ