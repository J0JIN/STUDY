package date_0814;

import java.util.Scanner;

public class Sol_1699_제곱수의합 {

	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i; 

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
		System.out.println(dp[N]);

	}

}
