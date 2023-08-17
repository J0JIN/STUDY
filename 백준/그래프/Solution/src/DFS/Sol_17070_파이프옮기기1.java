package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_17070_파이프옮기기1 {

	static StringTokenizer st;

	static int[][] map;

	static int N, ans;

	static int[] dx = { 1, 1, 0 };
	static int[] dy = { 0, 1, 1 };

	static class Pipe {
		int x, y, state;

		public Pipe(int x, int y, int state) {
			super();
			this.x = x;
			this.y = y;
			this.state = state;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		dfs(new Pipe(1, 0, 0));
		System.out.println(ans);

	}

	private static void dfs(Pipe pipe) {
		int x = pipe.x;
		int y = pipe.y;

		if (x == N - 1 && y == N - 1) {
			ans++;
			return;
		}

		if (pipe.state == 0) {// 현재 상태 "-"
			for (int d = 0; d <= 1; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (check(nx, ny)) {
					if (d == 0) {// 다음 상태 "-"
						if (map[nx][ny] == 0) {
							dfs(new Pipe(nx, ny, 0));
						}
					}

					if (d == 1) {// 다음 상태 "\"
						if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
							dfs(new Pipe(nx, ny, 1));
						}
					}
				}
			}
		}

		if (pipe.state == 1) {// 현재 상태 "\"
			for (int d = 0; d <= 2; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (check(nx, ny)) {
					if (d == 0) {// 다음 상태 "-"
						if (map[nx][ny] == 0) {
							dfs(new Pipe(nx, ny, 0));
						}
					}

					if (d == 1) {// 다음 상태 "\"
						if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
							dfs(new Pipe(nx, ny, 1));
						}
					}

					if (d == 2) {// 다음 상태 "|"
						if (map[nx][ny] == 0) {
							dfs(new Pipe(nx, ny, 2));
						}
					}
				}
			}
		}

		if (pipe.state == 2) {// 현재 상태 "|"
			for (int d = 1; d <= 2; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (check(nx, ny)) {
					if (d == 1) {// 다음 상태 "\"
						if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
							dfs(new Pipe(nx, ny, 1));
						}
					}

					if (d == 2) {// 다음 상태 "|"
						if (map[nx][ny] == 0) {
							dfs(new Pipe(nx, ny, 2));
						}
					}
				}
			}
		}
	}

	private static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}
