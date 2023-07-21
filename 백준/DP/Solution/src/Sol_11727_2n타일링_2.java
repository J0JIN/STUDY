import java.util.Scanner;

public class Sol_11727_2n타일링_2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] dp = new int[1000];

		dp[0] = 1;
		dp[1] = 3;

		for (int i = 2; i < 1000; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}

		System.out.println(dp[n - 1]);

	}
}
