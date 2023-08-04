import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_1600_말숭이 {

    public static int map[][];
    public static boolean visit[][][];

    public static int N, M, K;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static int[] dxHorse = {1, 1, 2, 2, -1, -1, -2, -2};
    public static int[] dyHorse = {2, -2, 1, -1, 2, -2, 1, -1};

    public static class Point {
        int x;
        int y;
        int distance;
        int jump;

        public Point(int x, int y, int distance, int jump) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.jump = jump;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);

        map = new int[M + 1][N + 1];

        for (int j = 1; j <= N; j++) {
            String[] input = br.readLine().split(" ");
            for (int i = 1; i <= M; i++) {
                map[i][j] = Integer.parseInt(input[i - 1]);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        visit = new boolean[M + 1][N + 1][K + 1];
        Point start = new Point(1, 1, 0, K);
        q.offer(start);
        visit[1][1][K] = true;

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            int dist = tmp.distance;
            int jump = tmp.jump;

            if (x == M && y == N) {// M!! N!! 좀 씨바
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (1 <= nx && nx <= M && 1 <= ny && ny <= N) {
                    if (map[nx][ny] == 0 && !visit[nx][ny][jump]) {
                        q.offer(new Point(nx, ny, dist + 1, jump));
                        visit[nx][ny][jump] = true;
                    }
                }
            }

            if (jump > 0) {
                for (int h = 0; h < 8; h++) {
                    int hx = x + dxHorse[h];
                    int hy = y + dyHorse[h];

                    if (1 <= hx && hx <= M && 1 <= hy && hy <= N) {
                        if (map[hx][hy] == 0 && !visit[hx][hy][jump - 1]) {
                            q.offer(new Point(hx, hy, dist + 1, jump - 1));
                            visit[hx][hy][jump - 1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}


