package date_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sol_2531_회전초밥 {

	static int N, d, k, c;
	static int[] sushi, sushiEat;
	static int ans = 0;

	static class Eat {
		int quantity, num;

		public Eat(int quantity, int num) {
			super();
			this.quantity = quantity;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N + 3001];
		sushiEat = new int[3001];

		for (int i = 0; i < N; i++) {
			int sushiNum = Integer.parseInt(br.readLine());
			sushi[i] = sushiNum;
		}
		for (int i = N; i < N + k; i++) {
			sushi[i] = sushi[i - N];
		}

		sushiEat[c]++;
		int total = 1;

		for (int i = 0; i < k; i++) {
			if (sushiEat[sushi[i]] == 0) {
				total++;
			}
			sushiEat[sushi[i]]++;
		}

		for (int i = k; i < N + k; i++) {
			if (sushiEat[sushi[i]] == 0) {
				total++;
			}
			sushiEat[sushi[i]]++;

			sushiEat[sushi[i - k]]--;
			if (sushiEat[sushi[i - k]] == 0) {
				total--;
			}

			ans = Math.max(ans, total);
		}

		System.out.println(ans);
	}
}