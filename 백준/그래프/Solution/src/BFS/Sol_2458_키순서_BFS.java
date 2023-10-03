package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_2458_키순서_BFS {
    static int[][] map, t_map;
    static int N, M;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        t_map = new int[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            map[start][end] = 1;
            t_map[end][start] = 1;
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            visit = new boolean[N];
            bfs(i);
            if(check()){
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static boolean check() {
        for(int i = 0; i < N; i++){
            if(!visit[i]){
                return false;
            }
        }
        return true;
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < N; i++) {
                if (map[cur][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }

        q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < N; i++) {
                if (t_map[cur][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

}
