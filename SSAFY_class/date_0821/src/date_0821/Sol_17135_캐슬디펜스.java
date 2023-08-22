package date_0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_17135_캐슬디펜스 {

	static int[][] map;
	static int[][] originmap;

	static boolean[][] visit;

	static int X, Y, D;
	static int count = 0;

	// 좌->상->우 , 하
	// bfs 탐색 시 좌상우 순으로 넣으면 가장 왼쪽에 있는 것 부터 탐색
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static class Point {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		Y = Integer.parseInt(input[0]);
		X = Integer.parseInt(input[1]);
		D = Integer.parseInt(input[2]);

		map = new int[X][Y + 1];
		originmap = new int[X][Y + 1];
		visit = new boolean[X][Y + 1];

		for (int j = 0; j < Y; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < X; i++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				originmap[i][j] = num;
			}
		}

		archerPlace(0, 0);

		System.out.println(count);
	}

	private static void archerPlace(int cnt, int idx) {
		// 아처 3명 다 놨을때
		if (cnt == 3) {
			// 게임 시작
			count = Math.max(count, play());
			// 맵 초기화
			init();
			return;
		}

		if (idx >= X) {
			return;
		}

		if (map[idx][Y] == 0) {
			map[idx][Y] = 2;
			archerPlace(cnt + 1, idx + 1);
			map[idx][Y] = 0;
			archerPlace(cnt, idx + 1);
		}

	}

	private static void init() {
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				map[i][j] = originmap[i][j];
			}
		}
	}

	private static int play() {
		int total = 0;

		while (!checkEnd()) {
			// 1. 궁수공격, 공격당한 적은 3으로 마킹
			for (int i = 0; i < X; i++) {
				if (map[i][Y] == 2) {
					bfsAttack(i, Y);
				}
			}

			// 2. 3으로 마킹된 적 제외
			total += killEnemy();

			// 3. 적 움직임
			moveEnemy();

		}
		return total;
	}

	// 적 움직임. 배열 복사하여 아래로 떙기기
	private static void moveEnemy() {
		int[][] newMap = new int[X][Y - 1];
		for (int j = 0; j < Y - 1; j++) {
			for (int i = 0; i < X; i++) {
				newMap[i][j] = map[i][j];
			}
		}

		for (int j = 1; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				map[i][j] = newMap[i][j - 1];
			}
		}

		for (int i = 0; i < X; i++) {
			map[i][0] = 0;
		}
	}

	// 적 죽임. 3으로 마킹된 적 죽임
	private static int killEnemy() {
		int total = 0;
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				if (map[i][j] == 3) {
					map[i][j] = 0;
					total++;
				}
			}
		}
		return total;
	}

	// 표적을 3으로 마킹
	private static void bfsAttack(int i, int j) {
		Queue<Point> q = new ArrayDeque<>();
		visit = new boolean[X][Y + 1];
		q.offer(new Point(i, j, 1));

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;

			if (tmp.dist > D) {
				return;
			}

			for (int d = 0; d < 3; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (0 <= nx && nx < X && 0 <= ny && ny < Y + 1) {
					if (!visit[nx][ny] && map[nx][ny] == 0) {
						q.offer(new Point(nx, ny, tmp.dist + 1));
						visit[nx][ny] = true;
					}

					if (map[nx][ny] == 1 || map[nx][ny] == 3) {
						map[nx][ny] = 3;
						return;
					}
				}
			}
		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < Y + 1; j++) {
			for (int i = 0; i < X; i++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println("------------------");
	}

	private static boolean checkEnd() {
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
