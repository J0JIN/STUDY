package date_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_15683_감시_발 {
	
	static int X, Y;
	static int map[][];
	static int originMap[][];
	static int ans = Integer.MAX_VALUE;

	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new int[X][Y];
		originMap = new int[X][Y];

		for (int j = 0; j < Y; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < X; i++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				originMap[i][j] = num;
			}
		}

		check(0, 0);
		System.out.println(ans);

	}

	static int tmp=0;
	private static void check(int a, int b) {
		tmp++;
		if(tmp>10) return;
		for (int j = b; j < Y; j++) {
			for (int i = a; i < X; i++) {

				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						deleteDir(i, j, d);
						check(i + 1, j);
					}
				}

				if (map[i][j] == 2) {
					for (int d = 0; d < 2; d++) {
						deleteDir(i, j, d);
						deleteDir(i, j, d + 2);
						check(i + 1, j);
					}
				}

				if (map[i][j] == 3) {
					for (int d = 0; d < 4; d++) {
						deleteDir(i, j, (d % 4));
						deleteDir(i, j, (d + 1) % 4);
						check(i + 1, j);
					}
				}

				if (map[i][j] == 4) {
					for (int d = 0; d < 4; d++) {
						deleteDir(i, j, (d % 4));
						deleteDir(i, j, (d + 1) % 4);
						deleteDir(i, j, (d + 2) % 4);
						check(i + 1, j);
					}
				}

				if (map[i][j] == 5) {
					deleteDir(i, j, 0);
					deleteDir(i, j, 1);
					deleteDir(i, j, 2);
					deleteDir(i, j, 3);
					check(i + 1, j);
				}


			} // end for

		}// end for

		ans = Math.min(ans, checkZero());
		print();
		init();
	}

	private static void init() {
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				map[i][j] = originMap[i][j];
			}
		}
	}

	private static void deleteDir(int x, int y, int d) {
		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (inMap(nx, ny)) {
				if (map[nx][ny] == 0) {
					map[nx][ny] = -1;
				}
				if (map[nx][ny] == 6) {
					return;
				}
			} else {
				return;
			}
			x = nx;
			y = ny;
		}
	}

	private static boolean inMap(int x, int y) {
		if (0 <= x && x < X && 0 <= y && y < Y) {
			return true;
		}
		return false;
	}

	private static int checkZero() {
		int ret = 0;
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				if (map[i][j] == 0) {
					ret++;
				}
			}
		}
		return ret;
	}

	private static void print() {
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("=================");
	}

}
