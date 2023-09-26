import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2636_치즈 {

    static int X, Y;
    static int[][] cheese;
    static int[][] cheese_ex;

    static boolean[][] isMelt;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        cheese = new int[X + 2][Y + 2];
        cheese_ex = new int[X + 2][Y + 2];

        for (int j = 1; j <= Y; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= X; i++) {
                int input = Integer.parseInt(st.nextToken());
                cheese[i][j] = input;
                cheese_ex[i][j] = input;
            }
        }

        int time = 0;
        while (true) {
            time++;

            melt();

            if (isOver()) {
                System.out.println(time);
                System.out.println(getAns());
                break;
            } else {
                deepCopy();
            }
        }


    }

    public static void melt() {
        isMelt = new boolean[X + 2][Y + 2];

        for (int j = 1; j <= Y; j++) {
            for (int i = 1; i <= X; i++) {
                if (cheese[i][j] == 1) {
                    dfs(i, j, i, j, new boolean[X + 2][Y + 2]);
                }
            }
        }

        for (int j = 1; j <= Y; j++) {
            for (int i = 1; i <= X; i++) {
                if (isMelt[i][j]) {
                    cheese[i][j] = 0;
                }
            }
        }

    }

    public static boolean isOver() {
        for (int j = 1; j <= Y; j++) {
            for (int i = 1; i <= X; i++) {
                if (cheese[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void deepCopy() {
        for (int j = 1; j <= Y; j++) {
            for (int i = 1; i <= X; i++) {
                cheese_ex[i][j] = cheese[i][j];
            }
        }
    }

    public static int getAns() {
        int ans = 0;
        for (int j = 1; j <= Y; j++) {
            for (int i = 1; i <= X; i++) {
                if (cheese_ex[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(int target_x, int target_y, int x, int y, boolean visited[][]) {

        if (x == 0 || y == 0 || x == X + 1 || y == Y + 1) {
            isMelt[target_x][target_y] = true;
            return;
        }

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (cheese[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(target_x, target_y, nx, ny, visited);
            }
        }
    }
}
