import java.util.Scanner;

public class Sol_13300_방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		double[][] room = new double[2][7];

		for (int i = 0; i < N; i++) {
			room[sc.nextInt()][sc.nextInt()]++;
		}

//		for (int i = 0; i < 2; i++) {
//			for (int j = 1; j <= 6; j++) {
//				System.out.println(room[i][j]);
//			}
//		}

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				room[i][j] = Math.ceil((double) room[i][j] / (double) K);
			}
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				System.out.println(room[i][j]);
			}
		}

	}
}
