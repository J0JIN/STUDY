package date_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_10830_행렬제곱 {

	static int[][] map;
	static int N;
	static long B;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		map = new int[N][N];

		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
			}
		}

		int[][] ans = new int[N][N];
		ans = matrixPow(map, B);

		print(ans);
	}

	private static int[][] matrixPow(int[][] a, long n) {
		int[][] retMatrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			retMatrix[i][i] = 1;
		}

		while (n > 0) {
			if (n % 2 == 1) {
				retMatrix = matrixMultiply(retMatrix, a);
				n--;
				retMatrix = matrixPercent(retMatrix, 1000);
			}
			a = matrixMultiply(a, a);
			a = matrixPercent(a, 1000);
			n /= 2;
			
		}

		return retMatrix;
	}

	private static int[][] matrixMultiply(int[][] mapInput1, int[][] mapInput2) {
		int[][] ansMatrix = new int[N][N];

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					ansMatrix[i][j] += mapInput1[k][j] * mapInput2[i][k];
				}
			}
		}
		return ansMatrix;
	}

	private static int[][] matrixPercent(int[][] mapInput1, int a) {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				mapInput1[i][j] %= a;
			}
		}
		return mapInput1;
	}

	private static void print(int[][] arr) {
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
