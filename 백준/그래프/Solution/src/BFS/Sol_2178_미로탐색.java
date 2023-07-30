package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_2178_미로탐색 {

    static class point {
        public point() {
        }
        public point(int x, int y) {
            this.cur_x = x;
            this.cur_y = y;
        }
        int cur_x;
        int cur_y;
    }

    static boolean visit[][];
    static int map[][];
    static int N, M;
    static point start;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int bfs(point p) {
        Queue<point> queue = new LinkedList<>();
        queue.offer(p);
        visit[p.cur_x][p.cur_y] = true;

        int count = 1;// 실수1 : 초기화는 전역 변수가 아니라 여기서 이루어져야됨..!

        while (!queue.isEmpty()) {
            point tmp_p = queue.poll();
            int x = tmp_p.cur_x;
            int y = tmp_p.cur_y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
                    if (map[nx][ny] == 1 && visit[nx][ny] == false) {
                        point np = new point(nx, ny);
                        queue.offer(np);
                        visit[nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        // 경로의 길이 update..! 이 부분을 어떻게 쓰는지에 대해서 고민 할 필요성이 있겠구먼
                        // bfs 문제는 이쪽을 어떻게 정하는지가 핵심인듯
                    }
                }
            }
        }
        return map[N][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        visit = new boolean[N + 1][M + 1];
        map = new int[N + 1][M + 1];

        for (int j = 1; j <= N; j++) {
            String input = br.readLine();
            for (int i = 1; i <= M; i++) {
                map[j][i] = input.charAt(i - 1) - '0';// 실수 2: -'0' 해줘야지 숫자가 됨
            }
        }// 실수 3: N이랑 M 계속 헷갈리네

        start = new point(1, 1);

        System.out.println(bfs(start));

    }
}
