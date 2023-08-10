import java.util.Scanner;

public class Sol_10844_쉬운계단수 {

    static long[][] dp;
    static long div = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp = new long[10][101];

        dp[0][1] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[i][1] = 1l;
        }

        int N = sc.nextInt();

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[j][i] = dp[j + 1][i - 1] % div;
                } else if (j == 9) {
                    dp[j][i] = dp[j - 1][i - 1] % div;
                } else {
                    dp[j][i] = dp[j + 1][i - 1] % div + dp[j - 1][i - 1] % div;
                }

            }
        }

        long total = 0;
        for (int j = 0; j <= 9; j++) {
            total += dp[j][N] % div;
        }
        System.out.println(total % div);
    }


}
