import java.util.Scanner;

public class Sol_1074_Z {

	static int N, r, c;
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		funcZ(0, 0, (int) Math.pow(2, N));
	}

	public static void funcZ(int x, int y, int size) {
		if (size == 1) {
			System.out.println(result);
			return;
		}

		int mid = size / 2;

		if (r < x + mid && c < y + mid) {
			funcZ(x, y, mid);
		} else if (r < x + mid && c >= y + mid) {
			result += mid * mid;
			funcZ(x, y + mid, mid);
		} else if (r >= x + mid && c < y + mid) {
			result += 2 * mid * mid;
			funcZ(x + mid, y, mid);
		} else {
			result += 3 * mid * mid;
			funcZ(x + mid, y + mid, mid);
		}
	}
}
