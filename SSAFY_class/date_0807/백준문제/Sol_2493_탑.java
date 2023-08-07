package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack01 = new Stack<>();
		Stack<Integer> stack02 = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			stack01.push(Integer.parseInt(input[i]));
		}

		while (!stack01.isEmpty()) {
			int top = stack01.pop();

			while (!stack01.isEmpty()) {
				int ans = stack01.pop();
				stack02.push(ans);

				if (top < ans) {
					sb.append((stack01.size() + 1) + " ");
					break;
				}
				if (stack01.isEmpty()) {
					sb.append(0 + " ");
					break;
				}
			}

			while (!stack02.isEmpty()) {
				stack01.push(stack02.pop());
			}

			if (stack01.isEmpty()) {
				sb.append(0);
				break;
			}
		}

		System.out.println(sb.reverse().toString());
	}
}
