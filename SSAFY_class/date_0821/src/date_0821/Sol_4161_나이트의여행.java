package date_0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_4161_나이트의여행 {
	static long X, Y;
	final static double div = Math.sqrt(5.0);

	static int ansMap[][] = { 
			{ 0, 3, 2, 3, 2 }, 
			{ 3, 4, 1, 2, 3 }, 
			{ 2, 1, 4, 3, 2 }, { 3, 2, 3, 2, 3 },
			{ 2, 3, 2, 3, 4 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] input = br.readLine().split(" ");

			if (input[0].equals("END")) {
				break;
			} else {
				X = (long) Math.abs(Integer.parseInt(input[0]));
				Y = (long) Math.abs(Integer.parseInt(input[1]));
			}

			double Xpow1 = Math.pow(X / div, 2);
			double Ypow1 = Math.pow(Y / div, 2);

			double Xpow2 = Math.pow(X - 1 / div, 2);
			double Ypow2 = Math.pow(Y / div, 2);

			double Xpow3 = Math.pow(X / div, 2);
			double Ypow3 = Math.pow(Y - 1 / div, 2);

			double Xpow4 = Math.pow(X - 2 / div, 2);
			double Ypow4 = Math.pow(Y / div, 2);

			double Xpow5 = Math.pow(X - 1 / div, 2);
			double Ypow5 = Math.pow(Y - 1 / div, 2);

			double Xpow6 = Math.pow(X / div, 2);
			double Ypow6 = Math.pow(Y - 2 / div, 2);

			double dist1 = Math.sqrt(Xpow1 + Ypow1);
			double dist2 = Math.sqrt(Xpow2 + Ypow2);
			double dist3 = Math.sqrt(Xpow3 + Ypow3);
			double dist4 = Math.sqrt(Xpow4 + Ypow4);
			double dist6 = Math.sqrt(Xpow6 + Ypow6);

			long ans = 0;
			if ((dist1 / div) % 1 == 0) {
				ans = (long)(dist1 / div);
			}
			if ((dist2 / div) % 1 == 0) {
				 ans = (long)(dist2 / div) + 3;
			}
			if ((dist3 / div) % 1 == 0) {
				 ans = (long)(dist3 / div) + 3;
			}
			if ((dist4 / div) % 1 == 0) {
				 ans = (long)(dist4 / div) + 2;
			}
			if ((dist5 / div) % 1 == 0) {
				 ans = (long)(dist5 / div) + 4;
			}
			if ((dist6 / div) % 1 == 0) {
				 ans = (long)(dist6 / div) + 2;
			}
			
			System.out.println(ans);
		}
	}
}