import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1520_내리막길_오답 {

    static int[][] map, dp;
    static StringTokenizer st;
    static int X, Y;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[X][Y];
        dp = new int[X][Y];

        for (int j = 0; j < Y; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < X; i++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int j = 0; j < Y; j++) {
//            for (int i = 0; i < X; i++) {
//                dp[i][j] = -1;
//            }
//        }

        dp[0][0] = 1;

        for (int j = 0; j < Y; j++) {
            for (int i = 0; i < X; i++) {
                checkPoint(i, j);
            }
        }

        System.out.println(dp[X - 1][Y - 1]);

    }

    private static void checkPoint(int cx, int cy) {
        for (int d = 0; d < 4; d++) {
            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
                if (map[cx][cy] < map[nx][ny]) {
                    dp[cx][cy] += dp[nx][ny];
                }
            }
        }
    }

}