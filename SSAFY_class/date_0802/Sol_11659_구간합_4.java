package date_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_11659_구간합_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str = br.readLine().split(" ");
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);

		int[] nums = new int[M + 1];

		String[] num = br.readLine().split(" ");
		int total = 0;

		nums[0] = 0;
		for (int i = 0; i < M; i++) {
			total += Integer.parseInt(num[i]);
			nums[i+1] = total;
		}

		for (int t = 1; t <= N; t++) {
			String[] SE = br.readLine().split(" ");
			int start = Integer.parseInt(SE[0]);
			int end = Integer.parseInt(SE[1]);
			int ans = nums[end] - nums[start-1];

			sb.append(ans).append('\n');
		}

		System.out.println(sb);
	}
}
