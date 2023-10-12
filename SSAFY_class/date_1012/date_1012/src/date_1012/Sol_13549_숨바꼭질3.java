package date_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_13549_¼û¹Ù²ÀÁú3 {
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[100_001];
		for (int i = 0; i < 100_001; i++) {
			map[i] = -1;
		}

		fillMap(N);
		getMap(K);
		
	}

	private static void fillMap(int n) {
		int N = n;
		while (N <= 100_000) {
			map[N] = 0;
			N *= 2;
		}
		
		N = n - 1;
		int cnt = 1;
		
		while (N >= 0) {
			map[N] = cnt;
			cnt++;
			N--;
		}
	}

	private static int getMap(int K) {
		if (map[K] == -1) {
			if (K - 1 >= 0 && K + 1 <= 100000) {
				map[K] = Math.min(getMap(K - 1), getMap(K + 1)) + 1;
			}
		}

		return map[K];
	}
}
