package date_0811;

import java.util.Scanner;

public class Sol_1463_1만들기 {
	static int[] data = new int[1_000_001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		data[1] = 0;
		data[2] = 1;
		data[3] = 1;

		for (int i = 4; i <= N; i++) {
			if (i % 6 == 0) {
				data[i] = Math.min(Math.min(data[i / 3], data[i / 2]), data[i - 1]) + 1;
			} else if (i % 3 == 0) {
				data[i] = Math.min(data[i / 3], data[i - 1]) + 1;
			} else if (i % 2 == 0) {
				data[i] = Math.min(data[i / 2], data[i - 1]) + 1;
			} else {
				data[i] = data[i - 1] + 1;
			}
		}
		
		System.out.println(data[N]);
	}
}
