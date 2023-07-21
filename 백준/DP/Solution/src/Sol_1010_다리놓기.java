import java.util.LinkedList;
import java.util.Scanner;

public class Sol_1010_다리놓기 {
    public static void main(String[] args) {
        int[][] dp = new int[30][30];

        for (int i = 0; i < 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int M = 2; M < 30; M++) {
            for (int N = 1; N < M; N++) {
                dp[M][N] = dp[M-1][N-1] + dp[M-1][N];
            }
        }

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for(int t = 0; t<tc; t++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(dp[M][N]);
        }

    }

}
