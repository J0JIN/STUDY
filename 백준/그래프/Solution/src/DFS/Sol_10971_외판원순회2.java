import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_10971_외판원순회2 {
    static int[][] map;
    static boolean[] visited;
    static int N, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int j = 0; j < N; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            dfs(i, 0, 1, i);
        }

        System.out.println(ans);
    }
    private static void dfs(int a, int total, int step, int start) {
        visited[a] = true;
        if(step == N){
            if(map[a][start]>0) {
                ans = Math.min(ans, total + map[a][start]);
            }
        }else {
            for (int i = 0; i < N; i++) {
                if (map[a][i] > 0 && !visited[i]) {
                    visited[i] = true;
                    dfs(i, total + map[a][i], step + 1, start);
                }
            }
        }
        visited[a] = false;
    }
}
