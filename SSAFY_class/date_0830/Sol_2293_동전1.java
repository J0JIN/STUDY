package date_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2293_µ¿Àü1 {

	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N + 1];
		int[] dp = new int[K + 1];
		dp[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i < coins.length; i++) {
			for (int j = coins[i]; j <= K; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}

		System.out.println(dp[K]);

	}
}
