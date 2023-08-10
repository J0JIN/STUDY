import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sol_1149_RGB거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] col = new int[1001][3];
        int[][] dp = new int[1001][3];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                col[i][j] = Integer.parseInt(input[j]);
                if (i == 1) {
                    dp[1][j] = Integer.parseInt(input[j]);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            int R = dp[i-1][0];
            int G = dp[i-1][1];
            int B = dp[i-1][2];

            dp[i][0] = Math.min(G, B) + col[i][0];
            dp[i][1] = Math.min(R, B) + col[i][1];
            dp[i][2] = Math.min(R, G) + col[i][2];
        }

        int ans = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);

        System.out.println(ans);

    }
}
