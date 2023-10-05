package date_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5658_보물상자비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			List<Integer> arr = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			String str = br.readLine();
			str = str + str;

			for (int i = N - 1; i >= 0; i--) {
				String hex = str.substring(i, i + N / 4);

				int deci = hexToDecimal(hex);
				if (!arr.contains(deci)) {
					arr.add(deci);
				}
			}

			Collections.sort(arr);
			System.out.println("#" + tc + " " + arr.get(arr.size() - K));
		}

	}

	private static int hexToDecimal(String hex) {
		int total = 0;
		int cnt = 0;

		for (int i = hex.length() - 1; i >= 0; i--) {
			int deci = 0;

			if (Math.abs(hex.charAt(i) - '0') < 10) {
				deci = hex.charAt(i) - '0';
			} else {
				deci = 10 + (hex.charAt(i) - 'A');
			}

			total += deci * Math.pow(16, cnt);
			cnt++;
		}

		return total;
	}
}
