import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1520_내리막길 {

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
                dp[i][j] = -1;
            }
        }
        System.out.println(checkPoint(0, 0));

    }

    private static int checkPoint(int cx, int cy) {
        if (cx == X - 1 && cy == Y - 1) {
            return 1;
        }

        if (dp[cx][cy] != -1) {
            return dp[cx][cy];
        }

        dp[cx][cy] = 0;

        for (int d = 0; d < 4; d++) {
            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
                if (map[cx][cy] > map[nx][ny]) {
                    dp[cx][cy] += checkPoint(nx,ny);
                }

            }
        }
        return dp[cx][cy];
    }
}