package 실습7_2;

import java.util.Arrays;

public class UserManagerImpl implements IUserManager {

	private final int MAX_SIZE = 100;
	
	private User[] userList = new User[MAX_SIZE];

	private int size = 0;

	private static UserManagerImpl um = new UserManagerImpl();

	private UserManagerImpl() {
	};

	public static UserManagerImpl getInstance() {
		return um;
	}

	public void add(User user) {
		if (size < MAX_SIZE) {
			userList[size++] = user;
		} else {
			System.out.println("유저의 수가 100을 넘었습니다. 등록 불가.");
		}
	}

	public User[] getList() {

		return Arrays.copyOfRange(userList, 0, size);
	}

	public User[] getUsers() {

		int cnt = 0;

		for (int i = 0; i < this.size; i++) {
			if (!(userList[i] instanceof VipUser)) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		User[] res = new User[cnt];

		for (int i = 0, index = 0; i < this.size; i++) {
			if (!(userList[i] instanceof VipUser)) {
				res[index++] = userList[i];
			}
		}

		return res;

	}

	public VipUser[] getVipUsers() {

		int cnt = 0;

		for (int i = 0; i < this.size; i++) {
			if (userList[i] instanceof VipUser) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		VipUser[] res = new VipUser[cnt];

		for (int i = 0, index = 0; i < this.size; i++) {
			if (userList[i] instanceof VipUser) {
				res[index++] = (VipUser) userList[i];
			}
		}

		return res;

	}

	public User[] searchByName(String name) {

		int cnt = 0;

		for (int i = 0; i < this.size; i++) {
			if (userList[i].getName().contains(name)) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		User[] res = new User[cnt];

		for (int i = 0, index = 0; i < this.size; i++) {
			if (userList[i].getName().contains(name)) {
				res[index++] = userList[i];
			}
		}

		return res;
	}

	public double getAgeAvg() {

		int sum = 0;

		for (int i = 0; i < this.size; i++) {
			sum += userList[i].getAge();
		}

		return sum / this.size;

	}

}
