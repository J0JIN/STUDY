package date_0731;

import java.nio.Buffer;
import java.util.Scanner;

public class Test5 {

	public static int[][] map;

	public static int[][][] win = { { { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 0 }, { 5, 0 } },
			{ { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } },
			{ { 1, -1 }, { 2, -2 }, { 3, -3 }, { 4, -4 }, { 5, -5 } },
			{ { 0, -1 }, { 0, -2 }, { 0, -3 }, { 0, -4 }, { 0, -5 } } };

	public static void check() {

		for (int j = 1; j <= 19; j++) {
			for (int i = 1; i <= 19; i++) {

				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int[] nx = new int[5];
						int[] ny = new int[5];
						for (int l = 0; l < 5; l++) {
							nx[i] = i + win[k][l][0];
							ny[j] = j + win[k][l][1];
						}

						if (1 <= nx[3] && nx[3] <= 19 && 1 <= ny[3] && ny[3] <= 19) {
							if (map[nx[0]][ny[0]] == 1 && map[nx[1]][ny[1]] == 1 && map[nx[2]][ny[2]] == 1
									&& map[nx[3]][ny[3]] == 1) {
								if (1 <= nx[4] && nx[4] <= 20 && 1 <= ny[4] && ny[4] <= 20) {
									if (map[nx[4]][ny[4]] != 1) {
										System.out.println("1");
										System.out.println(j + " " + i);
										return;
									}
								}
							}
						}
					}
					
					if (map[i][j] == 2) {
						for (int k = 0; k < 4; k++) {
							int[] nx = new int[5];
							int[] ny = new int[5];
							for (int l = 0; l < 5; l++) {
								nx[i] = i + win[k][l][0];
								ny[j] = j + win[k][l][1];
							}

							if (1 <= nx[3] && nx[3] <= 19 && 1 <= ny[3] && ny[3] <= 19) {
								if (map[nx[0]][ny[0]] == 2 && map[nx[1]][ny[1]] == 2 && map[nx[2]][ny[2]] == 2
										&& map[nx[3]][ny[3]] == 2) {
									if (1 <= nx[4] && nx[4] <= 20 && 1 <= ny[4] && ny[4] <= 20) {
										if (map[nx[4]][ny[4]] != 2) {
											System.out.println("2");
											System.out.println(j + " " + i);
											return;
										}
									}
								}
							}
						}

				}

			}

		}
	}

	System.out.println("0");return;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new int[21][21];

		for (int j = 1; j <= 19; j++) {
			for (int i = 1; i <= 19; i++) {
				map[i][j] = sc.nextInt();
			}
		}
		check();
	}
}
