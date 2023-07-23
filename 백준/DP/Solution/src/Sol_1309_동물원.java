import java.util.Scanner;

public class Sol_1309_동물원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long [][] dp = new long[N + 1][3];

        dp[1][0] = 1l;
        dp[1][1] = 1l;
        dp[1][2] = 1l;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])%9901;
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][0])%9901;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][0])%9901;
        }
        long max = (dp[N][0] + dp[N][1] + dp[N][2])%9901;


        System.out.println(max);
    }
}