package date_0811;

import java.util.Scanner;

public class Sol_9095_123더하기 {
	static int dp[] = new int[12];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= 11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for(int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			System.out.println(dp[N]);		
		}
	}
}
