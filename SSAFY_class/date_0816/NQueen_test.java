package date_0816;

import java.util.Scanner;

public class NQueen_test {

	static int N, col[], ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		col = new int[N + 1];
		ans = 0;

		setQueen(1);
		System.out.println(ans);
	}

	private static void setQueen(int row) {

		// 가지치기
		if (!isValid(row - 1)) {
			return;
		}

		// 기저조건
		if (row > N) {
			ans++;
			return;
		}

		// 완전탐색
		for (int i = 1; i <= N; i++) {
			col[row] = i;
			setQueen(row + 1);
		}
	}

	private static boolean isValid(int row) {
		for (int i = 1; i < row; i++) {
			if (col[i] == col[row] || row - i == Math.abs(col[row] - col[i])) {
				return false;
			}
		}
		return true;
	}

}
