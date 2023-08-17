package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_4963_섬의개수DFS {

    static int[][] map;
    static boolean[][] visit;
    static int X, Y;

    static StringTokenizer st;

    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, -1, 0, 1, -1, 1, 1, -1};

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());

            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            if (X == 0 && Y == 0) {
                break;
            }

            map = new int[X][Y];

            for (int j = 0; j < Y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < X; i++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visit = new boolean[X][Y];
            int ans = 0;
            for (int j = 0; j < Y; j++) {
                for (int i = 0; i < X; i++) {
                    if (map[i][j] == 1 && visit[i][j] == false) {
//                        bfs(i, j);
                        dfs(i, j);
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            int cx = tmp.x;
            int cy = tmp.y;

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
                    if (visit[nx][ny] == false && map[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 <= nx && nx < X && 0 <= ny && ny < Y) {
                if (visit[nx][ny] == false && map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    dfs(nx, ny);
                }
            }

        }
    }
}
