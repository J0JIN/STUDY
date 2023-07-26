import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sol_6603_로또{
	
	public static int cnt;// �������ϴ� �� 

	public static void discard(HashMap set,int count) {
		for (int i = set.size(); i >= 1; i--) {
			set.remove(i);
			count++; // �����ϰ� ���� ����
			
			if(count == cnt) {
				System.out.println(set);
				break;
			}//���ϴ� ������ ������ ���߱�
			
			discard(set, count);
			// �ٽ� set���� count ����
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			int set_num = sc.nextInt();

			if (set_num == 0) {
				break;
			}

			HashMap set = new HashMap();

			for (int i = 1; i <= set_num; i++) {
				set.put(i, sc.nextInt());
			}
			
			System.out.println(set);
			
			discard(set, set_num - 6);

		}
	}

}
