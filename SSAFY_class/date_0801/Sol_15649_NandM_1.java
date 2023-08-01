package date_0801;

import java.util.Scanner;

public class Sol_15649_NandM_1 {

	static int N, M;
	static int[] set;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		set = new int[M];
		visit = new boolean[N + 1];

		recur(0);

	}

	public static void recur(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(set[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visit[i] == true) {
				continue;
			}
			visit[i] = true;
			set[idx] = i;
			recur(idx + 1);
			visit[i] = false;

		}
	}
}
