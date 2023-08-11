package date_0811;

import java.util.Scanner;

public class Sol_9461_파도반수열 {

	static long dp[] = new long[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		dp[0] = 1l;
		dp[1] = 1l;
		dp[2] = 1l;
		dp[3] = 2l;
		dp[4] = 2l;
		dp[5] = 3l;

		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}

		for(int t = 1; t <= tc; t++){
			int N = sc.nextInt();

			System.out.println(dp[N - 1]);
		}
	}

}
