package 플로이드와셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1389_케빈베이컨6단계 {

    static int[][] fluid;
    static int M, N;

    static final int INF = 88888888;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fluid = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                fluid[i][j] = INF;

                if (i == j) {
                    fluid[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            fluid[x][y] = 1;
            fluid[y][x] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (fluid[i][j] > fluid[i][k] + fluid[k][j]) {
                        fluid[i][j] = fluid[i][k] + fluid[k][j];
                    }
                }
            }
        }

        int res = INF;
        int idx = -1;

        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += fluid[i][j];
            }

            if (res > total) {
                res = total;
                idx = i;
            }

        }

        System.out.println(idx);
    }
}