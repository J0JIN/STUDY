package date_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_16988_¹ÙµÏ2 {

	static int[][] map;
	static int[] select;
	static boolean visit[][];
	static int X, Y;
	static int ans = 0;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new int[X][Y];
		select = new int[2];

		for (int j = 0; j < Y; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < X; i++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(ans);
		
	}

	private static void comb(int idx, int cnt) {
		int x = idx % X;
		int y = idx / X;

		if (cnt == 2) {
			for (int i = 0; i < 2; i++) {
				map[select[i] % X][select[i] / X] = 1;
			}

			int total = 0;
			visit = new boolean[X][Y];

			for (int j = 0; j < Y; j++) {
				for (int i = 0; i < X; i++) {
					if (map[i][j] == 2 && !visit[i][j]) {
						total += bfs(i, j);
					}
				}
			}
			
			ans = Math.max(ans, total);

			for (int i = 0; i < 2; i++) {
				map[select[i] % X][select[i] / X] = 0;
			}
			return;
		}

		if (idx >= X * Y) {
			return;
		}

		if (map[x][y] > 0) {
			comb(idx + 1, cnt);
		} else {
			select[cnt] = idx;
			comb(idx + 1, cnt + 1);
			select[cnt] = 0;
			comb(idx + 1, cnt);
		}
	}

	private static int bfs(int i, int j) {
		Point start = new Point(i, j);
		visit[i][j] = true;

		Queue<Point> q = new ArrayDeque<>();
		q.offer(start);

		boolean zeroFind = false;
		int ret = 1;
		
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int cx = tmp.x;
			int cy = tmp.y;

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (isIn(nx, ny)) {
					if(map[nx][ny] == 2 && !visit[nx][ny]) {
						ret++;
						q.offer(new Point(nx, ny));
						visit[nx][ny] = true;
					}
					if(map[nx][ny] == 0) {
						zeroFind = true;
					}
				}
			}
		}
		
		if(zeroFind) {
			return 0;
		}else {
			return ret;
		}
	}

	private static boolean isIn(int nx, int ny) {
		if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
			return true;
		}
		return false;
	}
}
