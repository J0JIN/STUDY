package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Sol_13549_숨바꼭질 {
    final static int MAX = 100_001;
    private static class Subin {
        int time;
        int x;
        public Subin(int time, int x) {
            this.time = time;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Subin> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX];
        int[] time = new int[MAX];
        for(int i = 0; i < MAX; i++){
            time[i] = Integer.MAX_VALUE;
        }

        deque.offerFirst(new Subin(0, N));
        visited[N] = true;
        time[N] = 0;

        while (!deque.isEmpty()) {
            Subin cur = deque.poll();
            int cur_x = cur.x;
            int cur_time = cur.time;

            if (cur_x == K) {
                System.out.println(cur_time);
                break;
            }

            if (cur_x * 2 < MAX && !visited[cur_x * 2]) {
                deque.offerFirst(new Subin(cur_time, cur_x * 2));
                visited[cur_x * 2] = true;
                time[cur_x * 2] = cur_time;
            }

            int[] nextSteps = {cur_x - 1, cur_x + 1};
            for (int next : nextSteps) {
                if (next >= 0 && next < MAX && !visited[next] && time[next] > cur_time + 1) {
                    deque.offerLast(new Subin(cur_time + 1, next));
                    visited[next] = true;
                    time[next] = cur_time + 1;
                }
            }
        }
    }
}
