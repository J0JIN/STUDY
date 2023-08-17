package date_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_17069_파이프옮기기2 {

	static StringTokenizer st;

	static int[][] map;
	static int[][] dp;

	static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N];

		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			if (map[i][0] == 1) {
				break;
			}
			dp[i][0] = 1;
		}

		for (int i = 0; i < N; i++) {
			if (map[0][i] == 1) {
				break;
			}
			dp[0][i] = 1;
		}

		for (int j = 1; j < N; j++) {
			for (int i = 1; i < N; i++) {
				if (map[i][j - 1] == 1 && map[i - 1][j] == 0) {
					dp[i][j] = dp[i - 1][j];
				}

				if (map[i][j - 1] == 0 && map[i - 1][j] == 1) {
					dp[i][j] = dp[i - 1][j - 1];
				}

				if (map[i][j - 1] == 0 && map[i - 1][j] == 0 && map[i - 1][j - 1] == 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
				
				if (map[i][j - 1] == 0 && map[i - 1][j] == 0 && map[i - 1][j - 1] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] + dp[i][j - 1];
				}

			}
		}

		System.out.println(dp[N-1][N-1]);

	}

}
