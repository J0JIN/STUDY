package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_18405_경쟁적_전염 {

    private static class Virus implements Comparable<Virus> {
        int time;
        int power;
        int x;
        int y;

        @Override
        public int compareTo(Virus o) {
            if (this.time == o.time) {
                return this.power - o.power;
            } else {
                return this.time - o.time;
            }
        }

        public Virus(int time, int power, int x, int y) {
            this.time = time;
            this.power = power;
            this.x = x;
            this.y = y;
        }
    }

    static int N, K, S, X, Y;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Virus> pq = new PriorityQueue<>();
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int power = Integer.parseInt(st.nextToken());
                map[i][j] = power;

                if (power > 0) {
                    pq.add(new Virus(0, power, i, j));
                    visit[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        while (!pq.isEmpty()) {
            Virus curVirus = pq.poll();
            if (curVirus.time == S) {
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curVirus.x + dx[d];
                int ny = curVirus.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    map[nx][ny] = curVirus.power;
                    pq.add(new Virus(curVirus.time + 1, curVirus.power, nx, ny));
                }
            }
        }

        System.out.println(map[X-1][Y-1]);

    }
}
