package date_1011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Sol_11402_이항계수4 {

	static long P, N, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());

		System.out.println(nCr(N, K, P));
	}

	private static long nCr(long n, long k, long p) {
		if (n < p) {
			long numer = factorial(n);
			long denom = factorial(k) * factorial(n - k) % p;
			long ans = numer * pow(denom, p - 2) % p;

			return ans;
		} else {
			long ans = 1L;

			while (n > 0 || k > 0) {
				long a = n % p;
				long b = k % p;

				if (a < b) {
					ans = 0;
					break;
				}

				long numer = factorial(a);
				long denom = factorial(b) * factorial(a - b) % p;

				ans *= (numer * pow(denom, p - 2) % p);

				n /= p;
				k /= p;
			}

			return ans % p;
		}
	}

	public static long factorial(long N) {
		long fac = 1L;

		while (N > 1) {
			fac = (fac * N) % P;
			N--;
		}
		return fac;
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