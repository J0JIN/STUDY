import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Sol_1793_타일링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }

            int N = Integer.parseInt(input);
            BigInteger[] dp = new BigInteger[N];

            if (N == 0) {
                System.out.println(1); // 아무것도 안하는 것도 1개의 경우의 수라네? 개억까
            } else if (N == 1) {
                System.out.println(1);
            } else {
                dp[0] = new BigInteger("1");
                dp[1] = new BigInteger("3");

                for (int i = 2; i < N; i++) {
                    dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
                }

                System.out.println(dp[N - 1]);

            }
        }
    }
}
