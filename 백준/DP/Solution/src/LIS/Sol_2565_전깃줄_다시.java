package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2565_전깃줄_다시 {

    static int[] line = new int[501];
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < lineNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            line[start] = end;
        }

        dp = new int[lineNum];
        dp[0] = 1000;

        int cnt = 0;
        for (int i = 1; i <= 500; i++) {
            if(line[i] != 0) {
                if (dp[cnt] < line[i]) {
                    dp[cnt + 1] = line[i];
                    cnt++;
                } else {
                    int idx = binary(0, cnt, line[i]);
                    dp[idx] = line[i];
                }
            }
        }

        int len = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] == 0){
                break;
            }
            len++;
        }

        System.out.println(lineNum-len);

    }

    private static int binary(int L, int R, int num) {
        int mid;

        while(L < R){
            mid = (L+R)/2;
            if(dp[mid]<num){
                L = mid+1;
            }else{
                R = mid;
            }
        }

        return R;
    }
}
