package date_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_11660_구간합_5 {

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int T = Integer.parseInt(str[1]);

		map = new int[N + 1][N + 1];

		for (int j = 1; j <= N; j++) {
			String[] input = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(input[i - 1]);
				map[i][j] = map[i][j - 1] + map[i - 1][j] - map[i - 1][j - 1] + num;
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			String[] xy = br.readLine().split(" ");

			int x1 = Integer.parseInt(xy[0]) - 1;
			int y1 = Integer.parseInt(xy[1]) - 1;
			int x2 = Integer.parseInt(xy[2]);
			int y2 = Integer.parseInt(xy[3]);

			int ans = map[y2][x2] - map[y1][x2] - map[y2][x1] + map[y1][x1];

			System.out.println(ans);
		}
	}
}
