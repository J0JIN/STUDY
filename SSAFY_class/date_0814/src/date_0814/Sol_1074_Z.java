package date_0814;

import java.util.Scanner;

public class Sol_1074_Z {

	static int N, r, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		funcZ(r, c, N, 0);
	}

	public static void funcZ(int r, int c, int size, int val) {
		int mid = (int) Math.pow(2, size - 1);

		if (size == 1) {
			System.out.println(val);
			return;
		}

		if (r / mid == 0 && c / mid == 0) {
			funcZ(r, c, size - 1, (int) Math.pow(2, size) / 4 - 1);
		} else if (r / mid == 1 && c / mid == 0) {
			funcZ(r - mid, c, size - 1, (int) Math.pow(2, size) / 2 - 1);
		} else if (r / mid == 0 && c / mid == 1) {
			funcZ(r, c - mid, size - 1, 3 * (int) Math.pow(2, size) / 4 - 1);
		} else if (r / mid == 1 && c / mid == 1) {
			funcZ(r - mid, c - mid, size - 1, (int) Math.pow(2, size) - 1);
		}

	}
}
