package date_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1932_정수삼각형 {
	
	static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		int ans = 0;
		
		int cnt = 0;
		for(int j = 0; j < N; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i <= cnt; i++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			cnt++;
		}
		
		if(N == 1) {
			System.out.println(map[0][0]);
			return;
		}
		
		dp[0][0] = map[0][0];
		for(int i = 1; i < N; i++) {
			dp[0][i] = map[0][i] + dp[0][i-1];
		}
		
		cnt = 0;
		for(int j = 0; j < N; j++) {
			for(int i = 1; i <= cnt; i++) {
				dp[i][j] = map[i][j] + Math.max(dp[i][j-1], dp[i-1][j-1]);
				ans = Math.max(ans, dp[i][j]);
			}
			cnt++;
		}
		
		System.out.println(ans);
		
//		cnt = 0;
//		for(int j = 0; j < N; j++) {
//			for(int i = 0; i <= cnt; i++) {
//				System.out.print(dp[i][j] + " ");;
//			}
//			cnt++;
//			System.out.println();
//		}
	}
}
