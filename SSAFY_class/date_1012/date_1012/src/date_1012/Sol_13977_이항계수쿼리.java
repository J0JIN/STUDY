package date_1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Sol_13977_이항계수쿼리 {

	final static long P = 1_000_000_007;
	static int fac[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		fac = new int[4_000_001];
		fac[0] = 1;
		fac[1] = 1;

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			long numer = factorial(N);

			long denom = factorial(K) * factorial(N - K) % P;

			sb.append(numer * pow(denom, P - 2) % P).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static long factorial(int N) {
		if (fac[N] != 0) {
			return fac[N];
		}else {
			fac[N] = (int) (N * factorial(N-1) % P);
			return fac[N];
		}
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