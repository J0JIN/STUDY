import java.util.Scanner;

public class Sol_2851_슈퍼마리오 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] mushrooms = new int[10];
		for (int i = 0; i < 10; i++) {
			mushrooms[i] = sc.nextInt();
		}

		int sum = 0;
		int ans = 0;

		for (int i = 0; i < 10; i++) {
			sum += mushrooms[i];

			// 합이 100 이상이면 가장 가까운 합을 선택
			if (sum >= 100) {
				if (sum - 100 <= 100 - ans) {
					ans = sum;
				} else {
					ans = sum - mushrooms[i];
				}
				break;
			} else {
				ans = sum; // 합이 100 미만인 경우, 현재 합을 정답으로 갱신
			}
		}

		System.out.println(ans);
	}
}
