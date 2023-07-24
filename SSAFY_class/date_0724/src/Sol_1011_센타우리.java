import java.util.ArrayList;
import java.util.Scanner;

public class Sol_1011_��Ÿ�츮 {
	// �ִ븦 ��������
	// 1 ->1�� 1
	// 2 ->2�� 
	// 4 ->3��
	// 6 ->4��
	// 9 ->5��
	// �Ϲ� �����δ� A(n) = A(n-1) + [(n-1)/2 + 1]

	public static void main(String[] args) {
		int MAX = 300;
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {

			int x = sc.nextInt();
			int y = sc.nextInt();

			int dist = (y - x); // �Ÿ� ���ϱ�

			ArrayList<Integer> arr = new ArrayList<>();

			arr.add(1);
			arr.add(1);

			int i = 1;
			while (dist > arr.get(i)) {
				arr.add(arr.get(i) + ((arr.get(i) + 1) / 2) + 1);
				i++;
			}

			System.out.println(arr.size()-1);
		}
	}
}
