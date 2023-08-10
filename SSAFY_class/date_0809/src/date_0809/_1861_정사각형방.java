package date_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1861_정사각형방 {

	static int[][] map;
	static boolean[][] visit;
	static int N;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int x, y;
		int depth;

		public Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N + 1][N + 1];

			for (int j = 1; j <= N; j++) {
				String[] input = br.readLine().split(" ");
				for (int i = 1; i <= N; i++) {
					map[i][j] = Integer.parseInt(input[i - 1]);
				}
			}

			int max = 0;
			int ans = 0;

			for (int j = 1; j <= N; j++) {
				for (int i = 1; i <= N; i++) {
					Point start = new Point(i, j, 1);
					int a = bfs(start);
					if (a == max) {
						if(ans > map[i][j]) {
							ans = map[i][j];
						}
					}
					if (a > max) {
						max = a;
						ans = map[i][j];

					}

				}
			}
			System.out.println("#" + t + " " + ans + " " + max);
		}

	}

	public static int bfs(Point p) {
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		visit = new boolean[N + 1][N + 1];
		visit[p.x][p.y] = true;
		int max = 0;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int depth = tmp.depth;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
					if (!visit[nx][ny] && (map[x][y] + 1 == map[nx][ny])) {
						q.add(new Point(nx, ny, depth + 1));
						visit[nx][ny] = true;
						max = Math.max(depth + 1, max);
					}
				}
			}
		}

		return max;
	}

}
