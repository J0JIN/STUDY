package date_0810;

import java.util.Scanner;

public class Sol_2567_색종이2 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		int N = 100;
		int[][] dohwaji = new int[N + 2][N + 2];
		int count = 0;

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (x <= j && j < x + 10 && y <= i && i < y + 10) {
						if (dohwaji[i][j] == 0) {
							dohwaji[i][j] = 1;
						}
//						System.out.println(j + " " + i);
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (dohwaji[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (dohwaji[i][j] != dohwaji[nx][ny]) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}