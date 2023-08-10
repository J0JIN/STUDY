import java.util.Scanner;

public class Sol_2579_계단오르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] step = new int[301];
        int[] dp = new int[301];

        for (int i = 1; i <= N; i++) {
            step[i] = sc.nextInt();
        }

        dp[1] = step[1];
        dp[2] = step[2] + step[1];
        dp[3] = Math.max(step[1], step[2]) + step[3];


        for(int i = 4; i <= N; i++){
            dp[i] = Math.max(dp[i-3] + step[i-1], dp[i-2]) + step[i];
        }

        System.out.println(dp[N]);
    }
}
