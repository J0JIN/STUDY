package date_1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Sol_9343_·£´ý°È±â {

	static long N, K;
	static final long P = 1_000_000_007;
	static long[] fac;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		fac = new long[2_000_001];
		fac[0] = 1L;
		fac[1] = 1L;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Long.parseLong(st.nextToken());

			long ans = nCr(2 * N, N);

			System.out.println(ans);
		}
	}

	private static long nCr(long n, long k) {
		long numer = factorial(n);
		long denom = factorial(k) * factorial(k + 1) % P;
		long ans = numer * pow(denom, P - 2) % P;

		return ans;
	}

	public static long factorial(long n) {
		int N = (int) n;

		if (fac[N] >= 1) {
			return fac[N];
		}

		int cnt = 1;
		while (cnt <= N) {
			fac[cnt] = (long) cnt * fac[cnt - 1] % P;
			cnt++;
		}

		return fac[N];
	}

	public static long pow(long base, long expo) {
		long result = 1;

		while (expo > 0) {

			if (expo % 2 == 1) {
				result *= base;
				result %= P;
			}
			base = (base * base) % P;
			expo /= 2;
		}
		return result;
	}

}