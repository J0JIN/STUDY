import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Sol_1987_알파벳 {

	static int X, Y;
	static int max = Integer.MIN_VALUE;

	static char[][] map;
	static boolean[][] visit;
	static boolean[] alpabet;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

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
		Y = Integer.parseInt(input01[0]);
		X = Integer.parseInt(input01[1]);

		map = new char[X + 1][Y + 1];
		alpabet = new boolean[30];
		visit = new boolean[X + 1][Y + 1];

		for (int j = 1; j <= Y; j++) {
			String input02 = br.readLine();
			for (int i = 1; i <= X; i++) {
				map[i][j] = input02.charAt(i - 1);
			}
		}

		dfs(new Point(1, 1, 1));

		System.out.println(max);
	}

	private static void dfs(Point tmp) {
		max = Math.max(tmp.dist, max);
		visit[tmp.x][tmp.y] = true;
		alpabet[map[tmp.x][tmp.y] - 'A'] = true;

		for (int d = 0; d < 4; d++) {
			int nx = tmp.x + dx[d];
			int ny = tmp.y + dy[d];
			int ndist = tmp.dist + 1;

			if (0 < nx && nx <= X && 0 < ny && ny <= Y) {
				if (!visit[nx][ny] && !alpabet[map[nx][ny] - 'A']) {
					visit[nx][ny] = true;
					alpabet[map[nx][ny] - 'A'] = true;

					dfs(new Point(nx, ny, ndist));

					visit[nx][ny] = false;
					alpabet[map[nx][ny] - 'A'] = false;
				}
			}
		}

	}
// --------bfs는 백트래킹이 힘들구만 --------//
	
//	private static void bfs(int i, int j) {
//		visit = new boolean[X + 1][Y + 1];
//		Queue<Point> q = new ArrayDeque<>();
//		q.offer(new Point(i, j, 1));
//		
//		visit[i][j] = true;
//		alpabet[map[i][j] - 'A'] = true;
//
//		while (!q.isEmpty()) {
//			Point tmp = q.poll();
//
//			max = Math.max(tmp.dist, max);
//
//			for (int d = 0; d < 4; d++) {
//				int nx = tmp.x + dx[d];
//				int ny = tmp.y + dy[d];
//				int ndist = tmp.dist + 1;
//
//				if (0 < nx && nx <= X && 0 < ny && ny <= Y) {
//					if (!visit[nx][ny] && !alpabet[map[nx][ny] - 'A']) {
//						visit[nx][ny] = true;
//						alpabet[map[nx][ny] - 'A'] = true;
//						q.offer(new Point(nx, ny, ndist));
//					}
//				}
//			}
//
//		}
//	}
}
