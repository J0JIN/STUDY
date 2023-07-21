import java.util.Scanner;

public class Sol_1003_피보나치 {


    public static int[] dp = new int[44];

    public static void update_dp(){
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= 43 ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        update_dp();

        for(int t = 0; t < tc; t++){
            int N = sc.nextInt();

            if(N == 0){
                System.out.println("1 0");
            }
            else if(N == 1){
                System.out.println("0 1");
            }
            else{
                System.out.println(dp[N-2] + " " +dp[N-1]);
            }
        }
    }
}
