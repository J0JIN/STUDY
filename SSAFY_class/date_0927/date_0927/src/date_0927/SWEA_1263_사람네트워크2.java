package date_0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {
	
	final static int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];

			for (int i = 0; i < N * N; i++) {
				int y = i % N;
				int x = i / N;

				int input = Integer.parseInt(st.nextToken());
				
				if(input != 0) {
					map[x][y] = input;
				}else {
					map[x][y] = INF;
				}
				
				if(x == y) {
					map[x][y]= 0;
				}

			}

//			int[][] dist = new int[N][N];
//
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					dist[i][j] = Integer.MAX_VALUE/2;
//				}
//			}

			// 경유지
			for (int k = 0; k < N; k++) {
				// 시작
				for (int i = 0; i < N; i++) {
					// 종료
					for (int j = 0; j < N; j++) {
						map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
					}
				}
			}

			int[] ans = new int[N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] < INF) {
						ans[i] += map[i][j];
					}
				}
			}
			
			Arrays.sort(ans);
			
			
			System.out.println("#" + tc + " " + ans[0]);

		}
	}
}
