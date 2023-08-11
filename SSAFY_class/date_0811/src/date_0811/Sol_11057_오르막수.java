package date_0811;

import java.util.Scanner;

public class Sol_11057_오르막수 {

	static int[][] dp = new int[1001][10];
	static int div = 10_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				int tmp = j;
				do{
					dp[i][j] += dp[i-1][tmp] % div;
					tmp--;
				}while(tmp == 0);
			}
		}
		
		int total = 0;
		for (int i = 0; i <= 9; i++) {
			total += dp[N][i];
		}

		System.out.println(total % div);
	}
}
