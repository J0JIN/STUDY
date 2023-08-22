package date_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_15683_감시 {

	static int X, Y;
	static int map[][];

	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new int[X][Y];

		for (int j = 0; j < Y; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < X; i++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}

		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				if (map[i][j] == 1) {
					int[] look = { checkDir(i, j, 0), checkDir(i, j, 1), checkDir(i, j, 2), checkDir(i, j, 3) };

					int a = look[0];
					int b = look[1];
					int c = look[2];
					int d = look[3];

					int max = Math.max(Math.max(Math.max(a, b), c), d);

					if (max == a) {
						deleteDir(i, j, 0);
					} else if (max == b) {
						deleteDir(i, j, 1);
					} else if (max == c) {
						deleteDir(i, j, 2);
					} else {
						deleteDir(i, j, 3);
					}
				}

				if (map[i][j] == 2) {
					int[] look = { checkDir(i, j, 0), checkDir(i, j, 1), checkDir(i, j, 2), checkDir(i, j, 3) };

					int a = look[0] + look[2];
					int b = look[1] + look[3];

					if (a >= b) {
						deleteDir(i, j, 0);
						deleteDir(i, j, 2);
					} else {
						deleteDir(i, j, 1);
						deleteDir(i, j, 3);
					}
				}

				if (map[i][j] == 3) {
					int[] look = { checkDir(i, j, 0), checkDir(i, j, 1), checkDir(i, j, 2), checkDir(i, j, 3) };

					int a = look[0] + look[1];
					int b = look[1] + look[2];
					int c = look[2] + look[3];
					int d = look[3] + look[0];

					int max = Math.max(Math.max(Math.max(a, b), c), d);

					if (max == a) {
						deleteDir(i, j, 0);
						deleteDir(i, j, 1);
					} else if (max == b) {
						deleteDir(i, j, 1);
						deleteDir(i, j, 2);
					} else if (max == c) {
						deleteDir(i, j, 2);
						deleteDir(i, j, 3);
					} else {
						deleteDir(i, j, 3);
						deleteDir(i, j, 1);
					}
				}

				if (map[i][j] == 4) {
					int[] look = { checkDir(i, j, 0), checkDir(i, j, 1), checkDir(i, j, 2), checkDir(i, j, 3) };

					int a = look[0] + look[1] + look[2];
					int b = look[1] + look[2] + look[3];
					int c = look[2] + look[3] + look[0];
					int d = look[3] + look[0] + look[1];

					int max = Math.max(Math.max(Math.max(a, b), c), d);

					if (max == a) {
						deleteDir(i, j, 0);
						deleteDir(i, j, 1);
						deleteDir(i, j, 2);
					} else if (max == b) {
						deleteDir(i, j, 1);
						deleteDir(i, j, 2);
						deleteDir(i, j, 3);
					} else if (max == c) {
						deleteDir(i, j, 2);
						deleteDir(i, j, 3);
						deleteDir(i, j, 0);
					} else {
						deleteDir(i, j, 3);
						deleteDir(i, j, 1);
						deleteDir(i, j, 2);
					}
				}
				if (map[i][j] == 5) {
					deleteDir(i, j, 0);
					deleteDir(i, j, 1);
					deleteDir(i, j, 2);
					deleteDir(i, j, 3);
				}

			}
		}

		System.out.println(checkZero());

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

	private static int checkDir(int x, int y, int d) {
		int ret = 0;

		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (inMap(nx, ny)) {
				if (map[nx][ny] == 0) {
					ret++;
				}
				if (map[nx][ny] == 6) {
					return ret;
				}
			} else {
				return ret;
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
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
