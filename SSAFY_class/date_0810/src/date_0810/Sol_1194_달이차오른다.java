package date_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_1194_달이차오른다 {

	static int X, Y;
	static char[][] map;
	static boolean[][][] visit;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static Queue<Minsik> q;

	public static class Minsik {
		int x;
		int y;
		int dist;
		int key;

		public Minsik(int x, int y, int dist, int key) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.key = key;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input01 = br.readLine().split(" ");

		Y = Integer.parseInt(input01[0]); // 행 1
		X = Integer.parseInt(input01[1]); // 열 7

		map = new char[X + 1][Y + 1];
		q = new LinkedList<>();
		visit = new boolean[X + 1][Y + 1][1 << 6];

		for (int j = 1; j <= Y; j++) {
			char[] input02 = br.readLine().toCharArray();
			for (int i = 1; i <= X; i++) {
				map[i][j] = input02[i - 1];
				if (map[i][j] == '0') {
					map[i][j] = '.';
					q.offer(new Minsik(i, j, 0, 0));
					visit[i][j][0] = true;
				}
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {

		while (!q.isEmpty()) {
			Minsik tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int dist = tmp.dist;
			int key = tmp.key;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int ndist = dist + 1;

				if (1 <= nx && nx <= X && 1 <= ny && ny <= Y) {
					if (map[nx][ny] != '#' && visit[nx][ny][key] == false) {

						// '.' case
						if (map[nx][ny] == '.') {
							q.add(new Minsik(nx, ny, ndist, key));
							visit[nx][ny][key] = true;
						}

						// 'a~f' case
						else if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
							int nkey = key | (1 << map[nx][ny] - 'a'); // 얻은 key를 추가해줌
							q.add(new Minsik(nx, ny, ndist, nkey));
							visit[nx][ny][nkey] = true;
						}

						// 'A~F' case
						else if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
							int nkey = 1 << map[nx][ny] - 'A'; // 사용해야 되는 키의 bit
							if ((key & nkey) == nkey) { // 해당 키의 bit 비교
								q.add(new Minsik(nx, ny, ndist, key));
								visit[nx][ny][key] = true;
							}
						}

						// '1' case
						else if (map[nx][ny] == '1') {
							return ndist;
						}
					}
				}
			}

		}
		return -1;
	}

	public static void print() {
		for (int j = 1; j <= Y; j++) {
			System.out.println();
			for (int i = 1; i <= X; i++) {
				System.out.print(map[i][j] + " ");
			}
		}
		System.out.println("");
		System.out.println("---------------------------");
	}
}
