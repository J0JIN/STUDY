import java.util.ArrayList;
import java.util.Scanner;

public class Sol_1011_센타우리 {
	// 최대를 기준으로
	// 1 ->1번 1
	// 2 ->2번 
	// 4 ->3번
	// 6 ->4번
	// 9 ->5번
	// 일반 식으로는 A(n) = A(n-1) + [(n-1)/2 + 1]

	public static void main(String[] args) {
		int MAX = 300;
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {

			int x = sc.nextInt();
			int y = sc.nextInt();

			int dist = (y - x); // 거리 구하기

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
