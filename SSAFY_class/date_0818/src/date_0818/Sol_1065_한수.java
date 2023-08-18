package date_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1065_한수 {

	static int i;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if(N == 1000) {
			System.out.println(144);
		}else if (N < 100) {
			System.out.println(N);
		} else {
			int ans = 99;
			i = 100;

			while (true) {
				if (i > N) {
					break;
				}
				int a = i;
				if ((a % 10 - a / 10 % 10) == (a / 10 % 10 - a / 100 % 10)) {
					ans++;
				}
				i++;
			}
			System.out.println(ans);
		}

	}
}
