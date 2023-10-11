package date_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1806_ºÎºÐÇÕ {

	static int N, S;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		seq = new int[N + 1];
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int total = 0;
		int ans = Integer.MAX_VALUE;

		while (start <= N && end <= N) {
			if (total >= S && ans > end - start) {
				ans = end - start;
			}

			if (total < S) {
				total += seq[end++];
			} else {
				total -= seq[start++];
			}
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println("0");
		} else {
			System.out.println(ans);
		}

	}
}
