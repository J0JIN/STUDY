package �ǽ�9_2;
import java.util.Arrays;

public class UserTest {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("�����");
		user1.setEmail("ssafy1@ssafy.com");
		user1.setAge(27);

		User user2 = new User("user2", "user2", "�ڽ���", "ssafy2@ssafy.com", 28);
		VipUser vuser = new VipUser("vip1", "vip1", "�����", "ssafy3@ssafy.com", 29, "Gold", 300);

		IUserManager um = UserManagerImpl.getInstance();
		IUserManager um2 = UserManagerImpl.getInstance();

		um.add(user1);
		um.add(user2);
		um.add(vuser);
		
		// ���ܰ� �߻��Ҽ� �ִ� �޼ҵ��� searchByName�� ó���� �ʿ�.
		try {
			System.out.println(Arrays.toString(um.searchByName("Ȳ")));
		} catch (NameNotFoundException exception) {
//			exception.printStackTrace();
			exception.getMessage();
		}
		
		System.out.println(Arrays.toString(um.getUsers()));
		System.out.println(um.getAgeAvg());

		System.out.println(um.equals(um2));

	}

}
