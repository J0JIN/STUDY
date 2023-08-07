package date_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<>();	
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());

			char[] input = br.readLine().toCharArray();

			for (int i = 0; i < input.length; i++) {
				if(input[i] == '(' || input[i] == '{' ||input[i] == '[' ) {
					st.add(input[i]);
				}else {
					st.pop();
				}
			}
		}

	}
}
