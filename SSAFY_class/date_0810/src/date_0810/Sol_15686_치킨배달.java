package date_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_15686_치킨배달 {

	static int N, M, total;
	static int[][] map;
	static boolean[][] visitMap;

	static int ans = Integer.MAX_VALUE;
	static boolean[] visit;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static class Point {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input01 = br.readLine().split(" ");

		N = Integer.parseInt(input01[0]);
		M = Integer.parseInt(input01[1]);
		total = 0;

		map = new int[N + 1][N + 1];

		for (int j = 1; j <= N; j++) {
			String[] input02 = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				map[i][j] = Integer.parseInt(input02[i - 1]);
				if (map[i][j] == 2) {
					total++;
				}
			}
		}

		visit = new boolean[total];

		comb(0, 0);
		System.out.println(ans);

	}

	public static void comb(int idx, int cnt) {
		if (cnt == M) {
			int ansIdx = 0;

			int[][] newMap = new int[N + 1][N + 1];
			for (int j = 1; j <= N; j++) {
				for (int i = 1; i <= N; i++) {
					newMap[i][j] = map[i][j];
				}
			}

			for (int j = 1; j <= N; j++) {
				for (int i = 1; i <= N; i++) {
					if (newMap[i][j] == 2) {
						if (visit[ansIdx] == false) {
							newMap[i][j] = 0;
						}
						ansIdx++;
					}
				}
			}

			int total = 0;
			for (int j = 1; j <= N; j++) {
				for (int i = 1; i <= N; i++) {
					if (newMap[i][j] == 1) {
						total += bfs(i, j, newMap);
					}
				}
			}

			ans = Math.min(ans, total);
			return;
		}

		if (idx == total) {
			return;
		}

		visit[idx] = true;
		comb(idx + 1, cnt + 1);
		visit[idx] = false;
		comb(idx + 1, cnt);
	}

	public static int bfs(int x, int y, int[][] newMap) {
		Queue<Point> q = new LinkedList<>();
		visitMap = new boolean[N + 1][N + 1];
		q.offer(new Point(x, y, 0));

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int cx = tmp.x;
			int cy = tmp.y;
			int cdist = tmp.dist;
			visitMap[cx][cy] = true;

			if (newMap[cx][cy] == 2) {
				return cdist;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				int ndist = cdist + 1;

				if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
					if (visitMap[nx][ny] == false) {
						q.offer(new Point(nx, ny, ndist));
						visitMap[nx][ny] = true;
					}
				}
			}

		}
		return 0;

	}
}
