package date_0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _2805_농작물 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			check = new boolean[N][N];

			for (int j = 0; j < N; j++) {
				String[] str = br.readLine().split("");
				for (int i = 0; i < N; i++) {
					map[i][j] = Integer.parseInt(str[i]);
				}
			}

			recur(N / 2, N / 2, N / 2);

			int total = 0;
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (check[i][j] == true) {
						total += map[i][j];
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (check[i][j] == true) {
						total += map[i][j];
					}
				}
			}

			System.out.println("#" + t + " " + total);
		}

	}

	public static void recur(int x, int y, int count) {
		check[x][y] = true;

		if (count == 0) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!check[nx][ny])
				recur(nx, ny, count - 1);
		}
	}
}
