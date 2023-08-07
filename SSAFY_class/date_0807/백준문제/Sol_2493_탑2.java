package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_2493_탑2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] stack01 = new int[N];
		int idx01 = N - 1;

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			stack01[i] = Integer.parseInt(input[i]);
		}

		while (idx01 > 0) {
			int top = stack01[idx01];
			boolean isfind = false;

			for (int i = idx01 - 1; i >= 0; i--) {
				if (stack01[i] > top) {
					sb.append((i + 1) + " ");
					isfind = true;
					break;
				}
			}

			if (!isfind) {
				sb.append(0 + " ");
			}
			idx01--;
		}

		sb.append(0);
		System.out.println(sb.reverse().toString());
	}
}
