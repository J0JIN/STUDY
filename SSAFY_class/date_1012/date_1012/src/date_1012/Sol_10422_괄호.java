package date_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_10422_��ȣ {
	final static long P = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		long[] dp = new long[5001];

		dp[0] = 1;
		dp[2] = 1;

		for (int i = 2; i < 2501; i++) {
			for (int j = 0; j < i; j++) {
				dp[i * 2] += (dp[j * 2] * dp[(i - 1 - j) * 2]);
				dp[i * 2] %= P;
			}
		}

		for (int i = 0; i < t; i++) {
			int a = Integer.parseInt(br.readLine());
			System.out.println(dp[a]);
		}
	}
}
