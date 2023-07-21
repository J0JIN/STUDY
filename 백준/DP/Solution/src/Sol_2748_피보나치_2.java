import java.util.Scanner;

public class Sol_2748_피보나치_2 {

    public static Long[] dp = new Long[91];

    public static void update_dp(){
        dp[0] = 1L;
        dp[1] = 1L;
        for(int i = 2; i <= 90 ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        update_dp();
        int N = sc.nextInt();
        System.out.println(dp[N-1]);
    }
}
