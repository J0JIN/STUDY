import java.util.Scanner;

public class Sol_2775_부녀회장될꺼 {
    //3층 1 5 15
    //2층 1 4 10 20 35
    //1층 1 3 6  10 15 21
    //0층 1 2 3  4  5 6

    //dp[0][i] = i
    //dp[i][0] = 1
    //dp[k][n] = dp[k-1][n] + dp[k][n-1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] dp = new int[k + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                dp[0][i] = i + 1;
            }// 여기서 되게 헤맴 => dp[0][i] = i; 이라고 작성함;;

            for (int i = 0; i <= k; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= k ; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            System.out.println(dp[k][n-1]);
        }
    }

}
