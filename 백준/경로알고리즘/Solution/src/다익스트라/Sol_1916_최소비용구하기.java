package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1916_최소비용구하기 {
    static int[][] map;
    static int N, M;
    static final int INF = Integer.MAX_VALUE; // 더 큰 값으로 INF를 설정

    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i != j) { // 연결되지 않은 노드의 경우 처리하지 않음
                    map[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from][to] = Math.min(map[from][to], weight); // 최소 가중치만 저장
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        dijkstra(from);
        System.out.println(dist[to]);
    }

    private static void dijkstra(int start) {
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        dist[start] = 0;

        for (int a = 1; a <= N; a++) {
            int min = INF;
            int minIdx = -1;

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    minIdx = i;
                }
            }

            if (minIdx == -1) {
                break; // 방문하지 않은 노드가 없는 경우 종료
            }

            visited[minIdx] = true;

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && map[minIdx][i] != INF) {
                    dist[i] = Math.min(dist[i], dist[minIdx] + map[minIdx][i]);
                }
            }
        }
    }
}
