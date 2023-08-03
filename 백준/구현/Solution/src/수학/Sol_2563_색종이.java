package 수학;

import java.util.Scanner;

public class Sol_2563_색종이 {
//	2차원 100X100을 0을 채워서 만들고
//	종이를 붙이면 1로 갱신
//	사실상 칸 1 = 넓이 1임 -> 전체 탐색으로 1 갯수 세기

	public static void main(String[] args) {
		int N = 100;
		int[][] dohwaji = new int[N + 1][N + 1];
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
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
