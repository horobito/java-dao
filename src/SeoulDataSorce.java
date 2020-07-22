import java.sql.Connection;
import java.sql.SQLException;

public class SeoulDataSorce implements DataSorce {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
// ctrl shift a
// get connection 하나만 뺄 것
// 이름 데이터 소스라고 바꿈
// 이후 지워도 됨
// 위 입장에서는 유저 DAo 입장에서는
// new 데이터 소스 안에서 요롷게 커넥션을 만들어서 받아오는 것
// 이렇게 연결하는 과정을 누군가에게 위임을 했다.
// 과거로 넘어옴
// 이제는 미래로
// 다양한 요구?
// 데이터 소스 가서
