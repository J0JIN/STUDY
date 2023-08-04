import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_2206_벽부수고이동 {
    // 어차피 벽을 부수는게 빨라짐
    // 주변 벽이 4개/ 3개인 경우는 부서봤자 의미 없음
    // 주변 벽이 2개/ 1개인 경우 부신 경우에 대해서
    // bfs로 최단 경로 탐색

    public static int map[][];
    public static int N, M;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static class Point {
        int x;
        int y;
        int distance;
        boolean canBreak;

        public Point(int x, int y, int distance, boolean canBreak) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.canBreak = canBreak;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);

        map = new int[N + 1][M + 1];
        boolean[][] visit = new boolean[N + 1][M + 1];

        for (int j = 1; j <= M; j++) {
            String num = br.readLine();
            for (int i = 1; i <= N; i++) {
                map[i][j] = num.charAt(i - 1) - '0';
            }
        }

//        int max = -1;
//
//        for (int j = 1; j <= M; j++) { // 이곳 2중 for문을 간단하게 만들어야됨
//            for (int i = 1; i <= N; i++) {
//
//                if (map[i][j] == 1) {
//                    int count = 0;
//
//                    for (int k = 0; k < 4; k++) {  // N 최고가 1000, M 최고가 1000 -> 100만번
//                        int nx = i + dx[k];
//                        int ny = j + dy[k];
//                        if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
//                            if (map[i + dx[k]][j + dy[k]] == 1) {
//                                count++;
//                            }
//                        }
//                    }
//
//                    if (count <= 2) {
//                        int[][] nmap = map.clone();
//                        nmap[i][j] = 0;
//
//                        max = Math.max(max, bfs(nmap)); // bfs도.. 100만번 시간초과 날만 하네
//                    }
//
//                }
//
//            }
//        }

        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[N + 1][M + 1][2];
        queue.offer(new Point(1, 1, 1, true));
        // 2차원 배열로 해놓으면 처음 상황에 벽을 부숨.. 따라서 해당 상황에서 벽을 부술지 말지에 대한 것 도 저장해야됨
        visit[1][1][0] = true;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;
            int dist = tmp.distance;
            boolean canBreak = tmp.canBreak;

            if (x == N && y == M) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
                    if (canBreak) {
                        if (map[nx][ny] == 0 && !visit[nx][ny][0]) {
                            queue.offer(new Point(nx, ny, dist + 1, true));
                            visit[nx][ny][0] = true;
                        } else if (map[nx][ny] == 1 && !visit[nx][ny][1]) {
                            queue.offer(new Point(nx, ny, dist + 1, false));
                            visit[nx][ny][1] = true;
                        }
                    } else {
                        if (map[nx][ny] == 0 && !visit[nx][ny][1]) {
                            queue.offer(new Point(nx, ny, dist + 1, false));
                            visit[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
