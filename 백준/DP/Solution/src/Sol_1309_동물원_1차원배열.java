import java.util.Scanner;

public class Sol_1309_동물원_1차원배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] dp = new long[N + 2];

        dp[1] = 3L;
        dp[2] = 7L;

        for (int i = 3; i <= N; i++) {
            dp[i] = 2 * (dp[i - 1] % 9901) + (dp[i - 2] % 9901);
        }

        System.out.println(dp[N] % 9901);
    }
}