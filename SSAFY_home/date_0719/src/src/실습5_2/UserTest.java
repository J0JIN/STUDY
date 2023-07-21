package src.실습5_2;

import java.util.Arrays;

public class UserTest {

    public static void main(String[] args) {

        // 사용자 객체의 멤버 변수 이름을 통해 직접 접근하는 대신 setter 메소드를 사용하여 값 설정
        User user1 = new User();
        user1.setId("user1");
        user1.setPassword("user1");
        user1.setName("김싸피");
        user1.setEmail("ssafy1@ssafy.com");
        user1.setAge(27);

        User user2 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);

        UserManager um = new UserManager();

        um.add(user1);
        um.add(user2);

        for(User user : um.getList()){
            System.out.println(user);
        }

        System.out.println("회원조회 : 김싸피");
        System.out.println(um.searchByName("김싸피"));

        System.out.println("사용자 수 조회");
        System.out.println(um.getSize());

    }

}
