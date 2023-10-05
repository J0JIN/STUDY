import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_4485_≥Ïªˆø ¿‘¿∫¡©¥Ÿ {

	static int N;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int[][] map;
	static int[][] dist;
	static final int INF = Integer.MAX_VALUE / 2;

	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return map[this.x][this.y] - map[o.x][o.y];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 0;

		while (true) {
			tc++;
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}

			map = new int[N][N];
			dist = new int[N][N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < N; i++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
				}
			}

			dijkstra(0, 0);
			System.out.println("Problem " + tc + ": " + dist[N - 1][N - 1]);
		}

	}

	private static void dijkstra(int i, int j) {
		dist[i][j] = map[i][j];

		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(i, j));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			int cx = cur.x;
			int cy = cur.y;

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (!isIn(nx, ny))
					continue;

				if (dist[nx][ny] > dist[cx][cy] + map[nx][ny]) {
					dist[nx][ny] = dist[cx][cy] + map[nx][ny];
					pq.offer(new Point(nx, ny));
				}

			}
		}
	}

	private static boolean isIn(int nx, int ny) {
		if (0 <= nx && nx < N && 0 <= ny && ny < N) {
			return true;
		}
		return false;
	}
}