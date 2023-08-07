package date_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_1406_에디터 {

	static Stack<Character> left = new Stack<Character>();
	static Stack<Character> right = new Stack<Character>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		for (int i = 0; i < input.length; i++) {
			left.add(input[i]);
		}

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			char[] cmd = br.readLine().toCharArray();

			switch (cmd[0]) {
			case 'L':
				L();
				break;
			case 'D':
				D();
				break;
			case 'B':
				B();
				break;
			case 'P':
				P(cmd[2]);
				break;
			}
		}
		
		end();

	}

	static void L() {
		if (!left.isEmpty()) {
			right.add(left.pop());
		}
	}

	static void D() {
		if (!right.isEmpty()) {
			left.add(right.pop());
		}
	}

	static void B() {
		if (!left.isEmpty()) {
			left.pop();
		}
	}

	static void P(char input) {
		left.add(input);
	}

	static void end() {
		StringBuilder sb = new StringBuilder();
		while (!left.isEmpty()) {
			right.add(left.pop());
		}
		while (!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.println(sb);
	}

}
