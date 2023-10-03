package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_17142_연구소3 {

    private static class Virus {
        int x, y, time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Virus{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }

    static int N, M;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int EmptySpace = 0;
    static List<Virus> viruses = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    static Virus[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        select = new Virus[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    EmptySpace++;
                } else if (map[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0));
                }
            }
        }

        if(EmptySpace == 0){
            System.out.println(0);
        }else {
            selectV(0, 0);
            if(ans == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(ans);
            }
        }
    }

    private static void selectV(int start, int idx) {
        if(idx == M){
            bfs(EmptySpace);
            return;
        }

        if(start == viruses.size()){
            return;
        }

        select[idx] = viruses.get(start);
        selectV(start + 1, idx + 1);
        select[idx] = null;
        selectV(start + 1, idx);
    }

    private static void bfs(int emptySpace) {
        Queue<Virus> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Virus virus = select[i];
            visited[virus.x][virus.y] = true;
            q.add(virus);
        }

        while (!q.isEmpty()) {
            Virus cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                if (map[nx][ny] == 0) {
                    emptySpace--;
                }

                if (emptySpace == 0) {
                    ans = Math.min(ans, cur.time + 1);
                    return;
                }

                visited[nx][ny] = true;
                q.add(new Virus(nx, ny, cur.time + 1));
            }
        }
    }
}
