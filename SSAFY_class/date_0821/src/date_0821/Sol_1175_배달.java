package date_0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Sol_1175_배달 {

	static Queue<Minsik> q = new ArrayDeque<>();
	static char map[][];
	static boolean visit[][][][];
	// 1,2차원은 map을 의미
	// 3차원은 민식이가 전에 보던 방향
	// 4차원은 민식이가 선물 배달을 완료한 상황

	static int X, Y;

	// 상 -> 우 -> 하 -> 좌
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static class Minsik {
		int x, y, look, getC, dist;

		public Minsik(int x, int y, int look, int getC, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.look = look;
			this.getC = getC;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input01 = br.readLine().split(" ");

		Y = Integer.parseInt(input01[0]);
		X = Integer.parseInt(input01[1]);

		map = new char[X][Y];
		visit = new boolean[X][Y][4][3];

		for (int j = 0; j < Y; j++) {
			char[] input02 = br.readLine().toCharArray();
			for (int i = 0; i < X; i++) {
				map[i][j] = input02[i];
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					q.offer(new Minsik(i, j, -1, 0, 0));
				}
			}
		}

		bfs();
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			print();
			
			Minsik tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int look = tmp.look;

			if (tmp.getC == 2) {
				System.out.println(tmp.dist);
				return;
			}

			for (int d = 0; d < 4; d++) {
				if (d == look) {
					continue;
				}

				int nx = x + dx[d];
				int ny = y + dy[d];

				if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
					if (map[nx][ny] != '#' && !visit[nx][ny][d][tmp.getC]) {
						if (map[nx][ny] == '.') {
							q.offer(new Minsik(nx, ny, d, tmp.getC, tmp.dist + 1));
							visit[nx][ny][d][tmp.getC] = true;
						}

						if (map[nx][ny] == 'C') {
							q.offer(new Minsik(nx, ny, d, tmp.getC + 1, tmp.dist + 1));
							visit[nx][ny][d][tmp.getC + 1] = true;
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println("------------------");
	}
}
