import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_14728_벼락치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] dp = new int[W+1];
        int[][] item = new int[2][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            // 시간
            item[0][i] = Integer.parseInt(st.nextToken());
            // 가치
            item[1][i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = W; j-item[0][i] >= 0; j--){
                dp[j] = Math.max(item[1][i] + dp[j-item[0][i]], dp[j]);
            }
        }

        System.out.println(dp[W]);
    }
}
