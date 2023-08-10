package date_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_16935_배열돌리기3 {
	static int map[][];
	static int X, Y, R;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input01 = br.readLine().split(" ");
		Y = Integer.parseInt(input01[0]);
		X = Integer.parseInt(input01[1]);
		R = Integer.parseInt(input01[2]);

		map = new int[X][Y];

		for (int j = 0; j < Y; j++) {
			String[] input02 = br.readLine().split(" ");
			for (int i = 0; i < X; i++) {
				map[i][j] = Integer.parseInt(input02[i]);
			}
		}

		String[] input03 = br.readLine().split(" ");
		for (int t = 0; t < R; t++) {
			int cmd = Integer.parseInt(input03[t]);

			switch (cmd) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				func3();
				break;
			case 4:
				func4();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				break;
			}

		}

		print();
	}

	public static void func1() { // 상하반전
		int[][] newMap = new int[X][Y];

		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				newMap[i][Y - 1 - j] = map[i][j];
			}
		}

		map = newMap;
	}

	public static void func2() {// 좌우반전
		int[][] newMap = new int[X][Y];

		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				newMap[X - 1 - i][j] = map[i][j];
			}
		}

		map = newMap;
	}

	public static void func3() {// 오른쪽 90도 회전
		int[][] newMap = new int[Y][X];

		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				newMap[Y - 1 - j][i] = map[i][j];
			}
		}
		map = new int[Y][X];

		int tmp = 0;
		tmp = Y;
		Y = X;
		X = tmp;
		map = newMap;
	}

	public static void func4() {// 왼쪽 90도 회전
		int[][] newMap = new int[Y][X];

		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				newMap[j][X - 1 - i] = map[i][j];
			}
		}
		map = new int[Y][X];

		int tmp = 0;
		tmp = Y;
		Y = X;
		X = tmp;

		map = newMap;
	}

	public static void func5() {// 1234 오른쪽으로
		int[][] Map1 = new int[X / 2][Y / 2];
		int[][] Map2 = new int[X / 2][Y / 2];
		int[][] Map3 = new int[X / 2][Y / 2];
		int[][] Map4 = new int[X / 2][Y / 2];

		for (int j = 0; j < Y / 2; j++) {// 1복사
			for (int i = 0; i < X / 2; i++) {
				Map1[i][j] = map[i][j];
			}
		}
		for (int j = 0; j < Y / 2; j++) {// 2복사
			for (int i = X / 2; i < X; i++) {
				Map2[i - X / 2][j] = map[i][j];
			}
		}
		for (int j = Y / 2; j < Y; j++) {// 3복사
			for (int i = X / 2; i < X; i++) {
				Map3[i - X / 2][j - Y / 2] = map[i][j];
			}
		}
		for (int j = Y / 2; j < Y; j++) {// 4복사
			for (int i = 0; i < X / 2; i++) {
				Map4[i][j - Y / 2] = map[i][j];
			}
		}

//-----------------------------------------------------

		for (int j = 0; j < Y / 2; j++) {// 1에 4복사
			for (int i = 0; i < X / 2; i++) {
				map[i][j] = Map4[i][j];
			}
		}
		for (int j = 0; j < Y / 2; j++) {// 2에 1복사
			for (int i = X / 2; i < X; i++) {
				map[i][j] = Map1[i - X / 2][j];
			}
		}
		for (int j = Y / 2; j < Y; j++) {// 3에 2복사
			for (int i = X / 2; i < X; i++) {
				map[i][j] = Map2[i - X / 2][j - Y / 2];
			}
		}
		for (int j = Y / 2; j < Y; j++) {// 4에 3복사
			for (int i = 0; i < X / 2; i++) {
				map[i][j] = Map3[i][j - Y / 2];
			}
		}

	}

	public static void func6() {// 1234 왼쪽으로
		int[][] Map1 = new int[X / 2][Y / 2];
		int[][] Map2 = new int[X / 2][Y / 2];
		int[][] Map3 = new int[X / 2][Y / 2];
		int[][] Map4 = new int[X / 2][Y / 2];

		for (int j = 0; j < Y / 2; j++) {// 1복사
			for (int i = 0; i < X / 2; i++) {
				Map1[i][j] = map[i][j];
			}
		}
		for (int j = 0; j < Y / 2; j++) {// 2복사
			for (int i = X / 2; i < X; i++) {
				Map2[i - X / 2][j] = map[i][j];
			}
		}
		for (int j = Y / 2; j < Y; j++) {// 3복사
			for (int i = X / 2; i < X; i++) {
				Map3[i - X / 2][j - Y / 2] = map[i][j];
			}
		}
		for (int j = Y / 2; j < Y; j++) {// 4복사
			for (int i = 0; i < X / 2; i++) {
				Map4[i][j - Y / 2] = map[i][j];
			}
		}

//-----------------------------------------------------

		for (int j = 0; j < Y / 2; j++) {// 1에 2복사
			for (int i = 0; i < X / 2; i++) {
				map[i][j] = Map2[i][j];
			}
		}
		for (int j = 0; j < Y / 2; j++) {// 2에 3복사
			for (int i = X / 2; i < X; i++) {
				map[i][j] = Map3[i - X / 2][j];
			}
		}
		for (int j = Y / 2; j < Y; j++) {// 3에 4복사
			for (int i = X / 2; i < X; i++) {
				map[i][j] = Map4[i - X / 2][j - Y / 2];
			}
		}
		for (int j = Y / 2; j < Y; j++) {// 4에 1복사
			for (int i = 0; i < X / 2; i++) {
				map[i][j] = Map1[i][j - Y / 2];
			}
		}

	}

	public static void print() {
		for (int j = 0; j < map[0].length; j++) {
			for (int i = 0; i < map.length; i++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}