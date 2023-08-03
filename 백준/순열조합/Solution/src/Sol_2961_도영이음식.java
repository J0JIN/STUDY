import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_2961_도영이음식 {

    static boolean[] select;
    static int[][] food;
    static int N;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        food = new int[N][2];
        select = new boolean[N];

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            food[i - 1][0] = Integer.parseInt(input[0]);
            food[i - 1][1] = Integer.parseInt(input[1]);
        }

        comb(0);

        System.out.println(ans);

    }

    private static void comb(int idx) {
        if (idx == N) {
            int S = 1;
            int B = 0;
            int cnt = 0;
            for (int i = 0; i < select.length; i++) {
                if (select[i] == true) {
                    cnt++;
                    S *= food[i][0];
                    B += food[i][1];
                }
            }
            if (cnt == 0) {
                return;
            }
            ans = Math.min(ans, Math.abs(S - B));
            return;
        }

        select[idx] = true;
        comb(idx + 1);
        select[idx] = false;
        comb(idx + 1);

    }
}
