package date_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Sol_1941_소문난칠공주 {

	static int[][] map;
	static Point[] select = new Point[7];
	static boolean[] visit;
	static int count;
	static int ans = 0;
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[5][5];

		for (int j = 0; j < 5; j++) {
			String input = br.readLine();
			for (int i = 0; i < 5; i++) {
				if (input.charAt(i) == 'Y') {
					map[i][j] = 1;
				} else {
					map[i][j] = 2;
				}
			}
		}

		comb(0, 0, 0);
		
		System.out.println(ans);
		
	}

	private static void comb(int selectIdx, int idx, int total) {

		if (selectIdx == 7) {
			if (total >= 11) {
				visit = new boolean[7];
				count = 1;
				BFS();
				if(count == 7) {
					ans++;
				}
			}
			return;
		}

		if (idx == 25) {
			return;
		}

		int x = idx % 5;
		int y = idx / 5;

		select[selectIdx] = new Point(x, y);
		if (map[x][y] == 1) {
			comb(selectIdx + 1, idx + 1, total + 1);
		} else {
			comb(selectIdx + 1, idx + 1, total + 2);
		}

		select[selectIdx] = null;
		comb(selectIdx, idx + 1, total);

	}

	private static void BFS() {
		Point start = select[0];
		visit[0] = true;

		Queue<Point> q = new ArrayDeque<>();
		q.add(start);

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				for (int i = 0; i < 7; i++) {
					Point npoint = select[i];
					
					if(npoint.x == nx && npoint.y == ny && !visit[i]) {
						q.add(new Point(nx, ny));
						visit[i] = true;
						count++;
					}
				}
			}
		}

	}
}
