package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_16926_배열돌리기 {

	static int map[][];
	static int X, Y, R;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input01 = br.readLine().split(" ");
		Y = Integer.parseInt(input01[0]);
		X = Integer.parseInt(input01[1]);
		R = Integer.parseInt(input01[2]);

		map = new int[X][Y];

		for (int j = 0; j < Y; j++) {
			String[] input02 = br.readLine().split(" ");
			for (int i = 0; i < X; i++) {
				map[i][j] = Integer.parseInt(input02[i]);
			}
		}

		for (int i = 0; i < R; i++) {
			dolim(0);
		}
		print();
	}

	public static void dolim(int start) {

		if (X - 2 * start <= 0 || Y - 2 * start <= 0) {
			return;
		}

		int[] arrUp = new int[X - 2 * start];
		int[] arrDown = new int[X - 2 * start];
		int[] arrRight = new int[Y - 2 * start];
		int[] arrLeft = new int[Y - 2 * start];

		for (int i = start; i < X - start; i++) {
			arrUp[i - start] = map[i][start];
			arrDown[i - start] = map[i][Y - 1 - start];
		}

		for (int i = start; i < Y - start; i++) {
			arrRight[i - start] = map[start][i];
			arrLeft[i - start] = map[X - 1 - start][i];
		}

		for (int i = start; i < X - start - 1; i++) {
			map[i][start] = arrUp[i + 1 - start];
		} // 위 댕기고

		for (int i = start; i < X - start - 1; i++) {
			map[X - 1 - i][Y - 1 - start] = arrDown[X - 2 - i - start];
		} // 아래 댕기고

		for (int i = start; i < Y - start - 1; i++) {
			map[X - 1 - start][i] = arrLeft[i + 1 - start];
		} // 오른쪽(입력기준) 댕기고

		for (int i = start; i < Y - start - 1; i++) {
			map[start][Y - 1 - i] = arrRight[Y - 2 - i - start];
		} // 왼쪽 댕기고

		dolim(start + 1);
	}

	public static void print() {
		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
