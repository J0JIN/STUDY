package �ǽ�9_2;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements IUserManager {

	private List<User> userList = new ArrayList<>();

	private final int MAX_SIZE = 100;

	private static UserManagerImpl um = new UserManagerImpl();

	private UserManagerImpl() {
	};

	public static UserManagerImpl getInstance() {
		return um;
	}

	public void add(User user) {
		if (userList.size() < MAX_SIZE) {
			userList.add(user);
		} else {
			System.out.println("������ ���� 100�� �Ѿ����ϴ�. ��� �Ұ�.");
		}
	}

	public User[] getList() {

		User[] res = new User[userList.size()];

		return this.userList.toArray(res);
	}

	public User[] getUsers() {

		List<User> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				list.add(userList.get(i));
			}
		}

		User[] res = new User[list.size()];

		return list.toArray(res);

	}

	public VipUser[] getVipUsers() {

		List<VipUser> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (!(userList.get(i) instanceof VipUser)) {
				list.add((VipUser) userList.get(i));
			}
		}
		
		VipUser[] res = new VipUser[list.size()];

		return list.toArray(res);

	}
	
	// ���ܸ� �����ٰ� ����
	public User[] searchByName(String name) throws NameNotFoundException {

		List<User> list = new ArrayList<>();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().contains(name)) {
				list.add(userList.get(i));
			}
		}
		
		// �־��� �ܾ �����ϴ� ����ڰ� ������ ���ܸ� ������.
		if(list.size() == 0)
			throw new NameNotFoundException(name);
		
		User[] res = new User[list.size()];

		return list.toArray(res);
	}

	public double getAgeAvg() {

		int sum = 0;

		for (int i = 0; i < userList.size(); i++) {
			sum += userList.get(i).getAge();
		}

		return sum / userList.size();

	}

}
