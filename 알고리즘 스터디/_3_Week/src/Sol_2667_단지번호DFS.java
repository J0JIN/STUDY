import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_2667_단지번호DFS {

    static int map[][];
    static boolean visit[][];
    static int count = 0;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];

        ArrayList<Integer> ans = new ArrayList<>();

        for (int j = 1; j <= N; j++) {
            String input = br.readLine();
            ;
            for (int i = 1; i <= N; i++) {
                map[i][j] = input.charAt(i - 1) - '0';
            }
        }
        int root = 0;
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                if (map[i][j] == 1 && visit[i][j] == false) {
                    dfs(i, j);
                    ans.add(count);
                    count = 0;
                    root++;
                }
            }
        }

        System.out.println(root);

        Collections.sort(ans);

        while(!ans.isEmpty()) {
            System.out.println(ans.remove(0));
        }

    }

    private static void dfs(int i, int j) {
        visit[i][j] = true;
        count++;

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
                if (visit[nx][ny] == false && map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}
