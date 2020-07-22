import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyTest {


    @Test
    public void getUser() throws SQLException, ClassNotFoundException {
        Integer id =1;
        String name ="hi";
        String password ="jihwan";
        DataSorce jejuDataSource = new JejuDataSorce();
        UserDAO userDao = new UserDAO(jejuDataSource); // 유저를 가져올 것
        User user = userDao.get(id);// 유져dao는 유저를 반환, 1번째 아이디를 가져온다.

        // 1번째 자리를 가져왓을 때 - 아이디가 1


        assertThat(user.getId(), is(id)); // 받아온 아이디가 같은지
        assertThat(user.getName(), is(name)); // d왼쪽 : DB로 갖고 온 것
        assertThat(user.getPassword(), is(password));
        // 이것을 토대로 모르는 것은 4개
        // 왜??? 빨간 것이 4개 있으니깐
        // user에는
    }
// 만들었으니 이제는 써야 할 시간
    @Test //
    public void createUser() throws SQLException, ClassNotFoundException {
        String name = "hihihihihi";
        String password = "helllo";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        DataSorce jejuDataSorce = new JejuDataSorce();
        UserDAO userDao = new UserDAO(jejuDataSorce);
        // 왜 빨간줄? 데이터 소스 고르면 됨
        // 원하는 데이터 소스 받아서 넣기만 하면 된다.
        // 그러면 알아서 작동
        // 왜? 어짜피 사용자를 가져오는 로직 자체가 달라지지 않다.
        // 컴퓨터 부품 갈아끼우듯이 갈아끼우는 것
        // 제주 데이터 소스는 삼성에서 만든 램
        // 서울 데이터 소스는 하이닉스에서 만든 램
        // 이때 DDR4 규격이  인터페이스
        // 이런 내용들 서버 계발할 때 그대로 써먹음
        // 모래는 수정과 삭제
        // 써버에서 흔히 말하는 CRUD
        // 소고기 먹기 전까지
        // 너무너무 많이 봐서 외울 정도로 외워보자
        Integer id = userDao.insert(user);

        //

        User newUser = userDao.get(id);

        assertThat(newUser.getName(), is(name));
        assertThat(newUser.getPassword(), is(password)); // 확인하는 작업
        //

        //
    }
}

// 우리는 지금 유저를 가져오는 테스트를 할 거야.
// 관심사 : 유저를 가져오는 일 : TDD를 하게 되면!!!
// 이렇게 한 가지 일에 집중한다.
// 계발하다보면
// 유저를 가져오는 일 말고 확장, 만들기, 등등
// 잡생각으로부터 철저하게 배제를 할 수 잇ㄷ.
// 단순하게 유저를 가져오는 일만 할 것이다.
// 이런 tdd를 통해 관심사의 분리를 얻을 수 잇다.
// 마치 알고리즘의 테스트 케이스 같이
// 테스트 케이스 하나가 하나의 메소드
// ex. AFN 에서 테스트 케이스가 4개 있는 것 생각
// 예를 들어 서비스 만들 때
// 사용자 정보 가져오는 일을 먼저 해야 하는데
// 사실 지금 우리는 아무것도 모른다.
// 예를 들어 회의를 거치다 보니 사용자 정보를 가져오자!!1 라는 결과가 나옴
//
// 나중에 계발할때도 굉장히 중요함
// 그러면 맨 처음 이렇게 개발해야지!!
// 이후 테스트 코드를 먼저 짜는 습관을 들여야 한다.
// 반드시 이래야 한다는 것은 아니지만. 대부부은 이렇게 하는게 당연
// 모든 경우의 수를 테스트코드가 다 할수는 없지만
// 적어도 이러한 케이스에 대해서 동작을 확실하게 보장은 가능
// 중간에 코드 수정이 일어나도 이 동작이 여전히 잘 되는지 확인도 가능
// 이렇게 수정시 무서워 할 필요가 없다.

// 아무것도 모른느 상테에서 사용자 정보를 가져와보자!! 부터 시작
// 한 행을 튜플이라고 한다.
// 우리는 dAO를 만들 것 왜? 우리는 db로부터 데이터를 가져와야 하니깐
/*
DB로부터 접근하는 객체를
DAO라고 함, DATA Access Object
우리는 user에 접근하는 DAO를 만들 것
 cf select * from user
=  user 테이블에 접근하는 객체
  그게 user dao 이다.

  known to unkwon ;: 알고잇는것을 통해 모르는것으로 찾아나가는 것
  마치
  우리는 계발자 구하기 만들 것
  그러나 아직 모르는 것은 엄청나게 많음
  다양한 기능들을 아무것도 모름
  우리는 아는것을 통해서 모르는 것을 계속 찾아나가야 함
  이것은 정말 기획자나 계발ㅈ 모두 찾아나가는 과정
  노운 투 언노운
  이걸 위해 TDD가 굉장히 필요
  테스트를 통해 유저디에이오를 알아간다
  원래는 모름 왜 ? 빨간색 떳으니,

  TDD 하는 중요한 이유
  -

  캔테백?? 이사람이 했다네??

 */

/*
tdd에 대해 배울 것

TDD : 테스트 주도 계발
계발을 테스트로 주도해서 계빨
왜????????? 등장했는가?
지금까지는 요구사항이 주어진대로 코드를 대충 짬
일단 뭔가 됨. 잘 됨,
근데 이제 요구사항이 바뀔때가 됬어
아 이거 이렇게 바꿔주세요 같이 코드를 바꿈
그러면
그 바뀐 코드는 정상대로 작동된다는 것을 보장하기 힘들다
애초에 처음짠 코드조차
보장하려면 직접 테스트를 해봐야했다.
이런 방법에 신물이 났음
전통적인 방법은 선계발, 후테스트

이 방법이 너무 신물이 남
그래서 우리는 이러한 계발 방법에서 벗어나
선 테스트코드 작정, 후 여기에 맞는 계발

마치 아고리즘을 풀때,
입력이 주어지고 출력이 나오지?
우리는 그동안 알고리즘 풀었던 것을 되세겨보면

입력과 출력이 테스트 코드

그 알고리즘을 구현해왔음

이번에는 우리가 직접 테스트 코드를 짠다.


DB로부터 무엇인가를 가져오는 작업 할 것

그러면 어떻게 될까??
그러면 지금 우리가 테이블 보면
나오는 것을
우리가 가져오는 작업

마침내 TDD를 통해 사용자의 정보를 만듬
이제는 가져와야 함


 이제 열심히 만들었는데 특별한 요구사항이 생겨버림
 - 아 저희 이거 시현할거라 다른 db에서도 되어야되거든요? -

 F2

 */