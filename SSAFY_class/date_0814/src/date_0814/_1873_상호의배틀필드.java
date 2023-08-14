package date_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1873_상호의배틀필드 {

	static int[] dx = { 0, 0, -1, 1 }; // Up, Down, Left, Right
	static int[] dy = { -1, 1, 0, 0 };

	static char[][] map;
	static int X, Y;

	static Tank tank;

	public static class Tank {
		int x, y;
		int look;

		public Tank(int x, int y, int look) {
			this.x = x;
			this.y = y;
			this.look = look;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			String[] XYinput = br.readLine().split(" ");
			Y = Integer.parseInt(XYinput[0]);
			X = Integer.parseInt(XYinput[1]);

			map = new char[X][Y];

			for (int j = 0; j < Y; j++) {
				char[] mapInput = br.readLine().toCharArray();

				for (int i = 0; i < X; i++) {
					map[i][j] = mapInput[i];

					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						int look = changeLookInt(mapInput[i]);
						tank = new Tank(i, j, look);
						map[i][j] = '.';
					}
				}
			}

			int cmdSize = Integer.parseInt(br.readLine());
			char[] cmdInput = br.readLine().toCharArray();

			for (int i = 0; i < cmdSize; i++) {
				switch (cmdInput[i]) {
				case 'U':
					funcU();
					break;

				case 'D':
					funcD();
					break;

				case 'L':
					funcL();
					break;

				case 'R':
					funcR();
					break;

				case 'S':
					funcS();
					break;
				}
			}

			System.out.print("#" + t + " ");
			print();
		}

	}

	private static void funcS() {
		int x = tank.x;
		int y = tank.y;

		while (true) {
			int nx = x + dx[tank.look];
			int ny = y + dy[tank.look];

			if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
				if (map[nx][ny] == '*') {
					map[nx][ny] = '.';
					break;
				}

				else if (map[nx][ny] == '#') {
					break;
				}

				else {
					x = nx;
					y = ny;
				}

			} else {
				break;
			}
		}
	}

	private static void funcR() {
		tank.look = 3;
		int nx = tank.x + dx[tank.look];
		int ny = tank.y + dy[tank.look];
		move(nx, ny);
	}

	private static void funcL() {
		tank.look = 2;
		int nx = tank.x + dx[tank.look];
		int ny = tank.y + dy[tank.look];
		move(nx, ny);
	}

	private static void funcD() {
		tank.look = 1;
		int nx = tank.x + dx[tank.look];
		int ny = tank.y + dy[tank.look];
		move(nx, ny);
	}

	private static void funcU() {
		tank.look = 0;
		int nx = tank.x + dx[tank.look];
		int ny = tank.y + dy[tank.look];
		move(nx, ny);
	}

	private static void move(int nx, int ny) {
		if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
			if (map[nx][ny] == '.') {
				tank.x = nx;
				tank.y = ny;
			}
		}
	}

	private static int changeLookInt(char c) {
		if (c == '^') {
			return 0;
		} else if (c == 'v') {
			return 1;
		} else if (c == '<') {
			return 2;
		} else if (c == '>') {
			return 3;
		} else {
			return -1;
		}
	}

	private static char changeLookChar(int i) {
		if (i == 0) {
			return '^';
		} else if (i == 1) {
			return 'v';
		} else if (i == 2) {
			return '<';
		} else if (i == 3) {
			return '>';
		} else {
			return 'X';
		}
	}

	private static void print() {
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				if(tank.x == i && tank.y == j) {
					System.out.print(changeLookChar(tank.look));
				}else {
					System.out.print(map[i][j]);
				}
			}
			System.out.println("");
		}
	}

}
