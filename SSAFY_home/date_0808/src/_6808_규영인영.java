import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _6808_규영인영 {

    public static int[] A, B;
    public static int[] ans;
    public static boolean[] visit;
    static int win;
    static int lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            String[] input = br.readLine().split(" ");
            A = new int[9];
            B = new int[9];

            boolean[] total = new boolean[19];

            for (int i = 0; i < 9; i++) {
                int num =Integer.parseInt(input[i]);
                A[i] = num;
                total[num] = true;
            }

            int cnt = 0;
            for (int i = 1; i<=18; i++) {
                if(total[i] == false){
                    B[cnt] = i;
                    cnt++;
                }
            }

            win = 0;
            lose = 0;
            ans = new int[9];
            visit = new boolean[9];
            comb(0);

            System.out.println("#"+ t+" "+ win + " "+ lose);
        }
    }

    private static void comb(int idx) {
        if(idx == 9){
            if(win(ans, A)){
                lose++;
            }
            if(win(A, ans)){
                win++;
            }
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!visit[i]){
                visit[i] = true;
                ans[idx] = B[i];
                comb(idx+1);
                visit[i] = false;
            }
        }
    }

    public static boolean win(int[] A, int[] B){
        int totalA = 0;
        int totalB = 0;
        for(int i = 0; i< 9; i++){
            if(A[i] > B[i]){
                totalA += (A[i]+B[i]);
            }
            if(A[i] < B[i]){
                totalB += (A[i]+B[i]);
            }
        }
        if(totalA > totalB){
            return true;
        }else {
            return false;
        }
    }

}
