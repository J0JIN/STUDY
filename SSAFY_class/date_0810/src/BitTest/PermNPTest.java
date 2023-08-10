package BitTest;

import java.util.Arrays;
import java.util.Scanner;

public class PermNPTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
		}while(np(input));
		
	}

	public static boolean np(int[] arr) {
		// 1. 맨 뒤에서 부터 꼭대기 찾기
		int N = arr.length;
		int i = N - 1;

		while (i > 0 && arr[i - 1] >= arr[i]) {
			--i;
		}

		if (i == 0) { // 기저조건. 다음 순열은 없음
			return false;
		}

		// 2. 꼭대기 이전(i-1)위치에 교환할 한 단계 큰 수 뒤쪽부터 찾기

		int j = N - 1;
		while (arr[j - 1] >= arr[j]) {
			--j;
		}

		// 3. 꼭대기 직전 위치의 수와 한단계 큰 수를 교환하기
		swap(arr, i - 1, j);

		// 4. 꼭대기 자리부터 맨 뒤까지의 수를 오름차순의 형태로 바꿈
		int k = N - 1;
		while (i < k) {
			swap(arr, i++, k--);
		}

		return true;
	}

	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
}
