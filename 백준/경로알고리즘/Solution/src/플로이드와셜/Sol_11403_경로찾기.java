package 플로이드와셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_11403_경로찾기 {

    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int j = 0; j < N; j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        print();
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < N; j++) {
            for(int i = 0; i < N; i++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
