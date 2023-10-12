package date_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_11729_하노이탑순서 {

	static StringBuilder sb = new StringBuilder();
	static int height;
	static int ans = 0;;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		height = Integer.parseInt(br.readLine());

		hanoi(1, 2, 3, height);

		System.out.println(ans);
		System.out.println(sb.toString());
	}

	private static void hanoi(int start, int mid, int end, int cnt) {
		if (cnt == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			ans++;
			return;
		}

		hanoi(start, end, mid, cnt - 1);
		hanoi(start, mid, end, 1);
		hanoi(mid, start, end, cnt - 1);

	}
}
