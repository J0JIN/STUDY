package 수학;

import java.util.Scanner;

public class Sol_2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		int ans = 0;

		for (int i = 0; i < N - 2; i++) {// 첫번째 카드
			for (int j = i + 1; j < N - 1; j++) {// 두번째 카드
				for (int k = j + 1; k < N; k++) {// 세번째 카드
					sum = arr[i] +arr[j] + arr[k];
					if(sum <= M) {
						if(M - sum < M - ans) {
							ans = sum;
						}
					}
				}
			}
		}
		
		System.out.println(ans);

	}
}
