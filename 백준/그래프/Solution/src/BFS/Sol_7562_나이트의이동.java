package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;

public class Sol_7562_나이트의이동 {
	private static final int ArrayDeque = 0;
	static int[][] map;
	static boolean[][] visit;

	static int ans;
	static int N;

	static int startX, startY, endX, endY;

	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };

	static class Kinght {
		int x, y, dist;

		public Kinght(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			N = Integer.parseInt(br.readLine());

			String[] start = br.readLine().split(" ");
			String[] end = br.readLine().split(" ");

			startX = Integer.parseInt(start[0]);
			startY = Integer.parseInt(start[1]);
			endX = Integer.parseInt(end[0]);
			endY = Integer.parseInt(end[1]);

			map = new int[N][N];
			visit = new boolean[N][N];

			bfs(new Kinght(startX, startY, 0));
			System.out.println(ans);
			ans = 0;
		}

	}

	private static void bfs(Kinght start) {
		Queue<Kinght> q = new ArrayDeque<>();
		q.offer(start);
		visit[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Kinght tmp = q.poll();
			
			if(tmp.x == endX && tmp.y == endY) {
				ans = tmp.dist;
				return;
			}

			for (int d = 0; d < 8; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				int ndist = tmp.dist + 1;

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(visit[nx][ny] == false) {
						visit[nx][ny] = true;
						q.offer(new Kinght(nx, ny, ndist));
					}
				}
			}
		}

	}

}
