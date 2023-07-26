package date_0725;

import java.util.Scanner;

public class Sol_2851_½´ÆÛ¸¶¸®¿À {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		int under = 0;
		int over = 0;
		int ans_under = Integer.MAX_VALUE;
		int ans_over = Integer.MAX_VALUE;
		int ans = Integer.MAX_VALUE;
		boolean over100 = false;

		for (int i = 0; i < 10; i++) {
			sum += arr[i];
			if (sum < 100) {
				ans = sum;
			} else {
				over = sum;
				under = sum - arr[i];

				if (100 - under < ans_under) {
					ans_under = under;
				}

				if (over - 100 < ans_under) {
					ans_over = over;
				}
				over100 = true;
				break;
			}
		}

		if (over100 == true) {
			if (100 - ans_under < ans_over - 100) {
				ans = ans_under;
			} else {
				ans = ans_over;
			}
		}
		System.out.println(ans);
	}
}
