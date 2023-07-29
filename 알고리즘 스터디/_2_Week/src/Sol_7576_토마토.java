import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_7576_토마토 {

    // 풀다보니 스타트 포인트가 여러개네
    // 배열로 스택에 시작점을 동시에 넣어줘야되나..

    static int M, N;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};

    static int map[][];
    static boolean visit[][];

    static Queue<tomato> queue;

    public static class tomato {
        int cur_x;
        int cur_y;

        public tomato() {
        }

        public tomato(int cur_x, int cur_y) {
            this.cur_x = cur_x;
            this.cur_y = cur_y;
        }
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            tomato tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.cur_x + dx[i];
                int ny = tmp.cur_y + dy[i];

                if (0 < nx && nx <= M && 0 < ny && ny <= N && visit[nx][ny] == false && map[nx][ny] == 0) {
                    // 헤맴 point 2. 벽 조건을 넣지 않았었음.. 디버깅해서 찾았네
                    // + map[nx][ny] 조건을 map[nx][ny] != -1 로 하면 틀렸다고 나오는데 이거의 이유는.. 철수님께
                    queue.offer(new tomato(nx, ny));
                    visit[nx][ny] = true;
                    map[nx][ny] = map[tmp.cur_x][tmp.cur_y] + 1;// 헤맴 point 3. 맵에다가 익은 날짜 표기 방법 어떻게 할지
                }
            }
        }

        int day = 0;

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                if (map[i][j] >= day) {
                    day = map[i][j];
                }
            }
        }
        return day - 1;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M + 1][N + 1];
        visit = new boolean[M + 1][N + 1];

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    queue.add(new tomato(i, j)); // 헤맴 point 1. 여기서 이렇게 주는 방법이 있구만.
                }
            }
        }
        System.out.println(bfs());
    }
}
