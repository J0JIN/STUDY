package date_0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _1210_Ladder {

	static int[] dx = { -1, 1, 0 };
	static int[] dy = { 0, 0, -1 };
	static int[][] map;
	static int cur_x, cur_y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();

			map = new int[101][101];

			for (int j = 1; j <= 100; j++) {
				for (int i = 1; i <= 100; i++) {
					map[i][j] = sc.nextInt();
				}
			}

			int start_x = 0;
			for (int i = 1; i <= 100; i++) {
				if (map[i][100] == 2) {
					start_x = i;
					break;
				}
			}

			cur_x = start_x;
			cur_y = 100;

			while (true) {

				if (cur_y <= 1) {
					System.out.println("#" + tc + " " + (cur_x - 1));
					break;
				} // 종료조건

				if (checkLR(cur_x, cur_y) == 0) {// 왼쪽 발견
					while (true) {// 계속 가다가
						cur_x = cur_x + dx[0];
						cur_y = cur_y + dy[0];
						if (checkUp(cur_x, cur_y) == 1) {//위가 보이면
							cur_x = cur_x + dx[2];
							cur_y = cur_y + dy[2];//바로 위로 1번
							break;
						}
					}
				}

				if (checkLR(cur_x, cur_y) == 1) {// 오른쪽 발견
					while (true) {// 계속 가다가
						cur_x = cur_x + dx[1];
						cur_y = cur_y + dy[1];
						if (checkUp(cur_x, cur_y) == 1) {// 위가 보이면
							cur_x = cur_x + dx[2];
							cur_y = cur_y + dy[2];// 바로 위로 1번
							break;
						}
					}
				}

				if (checkLR(cur_x, cur_y) != 0 && checkLR(cur_x, cur_y) != 1) {// 양옆에 뭐 없으면 위로
					cur_x = cur_x + dx[2];
					cur_y = cur_y + dy[2];
				}

			}

		}

	}

	public static int checkLR(int x, int y) {

		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (1 <= nx && nx <= 100 && 1 <= ny && ny <= 100) {
				if (map[nx][ny] == 1) {
					return i; // 왼쪽이면 0, 오른쪽이면 1 return
				}
			}
		}
		return -1;// 없으면 -1 return
	}

	public static int checkUp(int x, int y) {

		int nx = x + dx[2];
		int ny = y + dy[2];
		if (1 <= nx && nx <= 100 && 1 <= ny && ny <= 100) {
			if (map[nx][ny] == 1) {
				return 1; // 위면 1 return
			}

		}
		return -1;// 없으면 -1 return
	}

}
