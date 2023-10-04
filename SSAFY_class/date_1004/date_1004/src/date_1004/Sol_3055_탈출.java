package date_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_3055_탈출 {

	static int X, Y;
	static int ans = Integer.MAX_VALUE;

	static int[][] map;
	static boolean[][] visit;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Point {
		int x, y, day;

		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	static Queue<Point> waterQ;
	static Queue<Point> gosuemQ;

	public static void main(String[] args) throws IOException {
		String s=null;
		s.indexOf(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input01 = br.readLine().split(" ");

		Y = Integer.parseInt(input01[0]);
		X = Integer.parseInt(input01[1]);

		map = new int[X][Y];
		visit = new boolean[X][Y];
		
		waterQ = new ArrayDeque<>();
		gosuemQ = new ArrayDeque<>();

		for (int j = 0; j < Y; j++) {
			String input02 = br.readLine();
			for (int i = 0; i < X; i++) {
				map[i][j] = input02.charAt(i);

				if (map[i][j] == '*') {
					waterQ.add(new Point(i, j, 0));
					map[i][j] = 0;
				} else if (map[i][j] == 'S') {
					gosuemQ.add(new Point(i, j, 0));
					visit[i][j] = true;
					map[i][j] = -2;
				} else if (map[i][j] == 'D') {
					map[i][j] = -3;
				} else if (map[i][j] == 'X') {
					map[i][j] = -4;
				} else {
					map[i][j] = -1;
				}

			}
		}

		waterBFS();
		gosuemBFS();

		if (ans == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(ans);
		}

	}

	private static void gosuemBFS() {
		while (!gosuemQ.isEmpty()) {
			Point cur = gosuemQ.poll();

			int cx = cur.x;
			int cy = cur.y;
			int cday = cur.day;

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				int nday = cday + 1;

				if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
					if ((map[nx][ny] > nday || map[nx][ny] == -1 ) && !visit[nx][ny]) {
						visit[nx][ny] = true;
						gosuemQ.add(new Point(nx, ny, nday));
					}

					if (map[nx][ny] == -3) {
						ans = nday;
						gosuemQ.clear();
						return;
					}
				}
			}

		}
		
	}

	private static void waterBFS() {

		while (!waterQ.isEmpty()) {
			Point cur = waterQ.poll();

			int cx = cur.x;
			int cy = cur.y;
			int cday = cur.day;

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				int nday = cday + 1;

				if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
					if (map[nx][ny] == -1) {
						map[nx][ny] = nday;
						waterQ.add(new Point(nx, ny, nday));
					}
				}

			}

		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append("----------------");
		System.out.println(sb.toString());
	}
}
