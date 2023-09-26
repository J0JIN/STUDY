package date_0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307_LIS {

	static int[] C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N];
			C = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			C[0] = arr[0];

			int i = 1;
			int j = 0;

			while (i < N) {
				if (C[j] < arr[i]) {
					C[j + 1] = arr[i];
					j++;
				} else {
					int idx = binary(0, j, arr[i]);
					C[idx] = arr[i];
				}
				i++;
			}

			int cnt = 0;
			for (int a = 0; a < C.length; a++) {
				if (C[a] == 0) {
					break;
				}
				cnt++;
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}

	public static int binary(int L, int R, int target) {
		int mid = (L + R) / 2;

		while (L < R) {
			mid = (L + R) / 2;

			if (C[mid] < target) {
				L = mid + 1;
			} else {
				R = mid;
			}
		}

		return R;
	}
}
