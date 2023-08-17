package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Sol_10026_적록색약 {

    static char[][] map;
    static boolean[][] visit;
    static int N;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point{
        int x,y;
        char color;
        public Point(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int j = 0; j < N; j++) {
            String input = br.readLine();
            for (int i = 0; i < N; i++) {
                map[i][j] = input.charAt(i);
            }
        }

        int ans = 0;
        visit = new boolean[N][N];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if(!visit[i][j]) {
                    bfsNormal(i, j, map[i][j]);
                    ans++;
                }
            }
        }

        System.out.print(ans + " ");

        ans = 0;
        visit = new boolean[N][N];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if(!visit[i][j]) {
                    bfsUnnormal(i, j, map[i][j]);
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }

    private static void bfsUnnormal(int i, int j, char color) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i,j,color));
        visit[i][j] = true;

        while(!q.isEmpty()){
            Point tmp = q.poll();

            for(int d = 0; d< 4; d++){
                int nx = tmp.x + dx[d];
                int ny = tmp.y + dy[d];
                char tmpColor = tmp.color;

                if(0 <= nx && nx < N && 0<= ny && ny <N){
                    if(tmpColor == 'R' || tmpColor == 'G' ) {
                        if (!visit[nx][ny] && (map[nx][ny] == 'R' ||map[nx][ny] == 'G' )) {
                            q.offer(new Point(nx, ny, tmp.color));
                            visit[nx][ny] = true;
                        }
                    }else{
                        if(!visit[nx][ny] && map[nx][ny] == tmp.color){
                            q.offer(new Point(nx,ny,tmp.color));
                            visit[nx][ny] = true;
                        }
                    }
                }
            }

        }
    }

    private static void bfsNormal(int i, int j, char color) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i,j,color));
        visit[i][j] = true;

        while(!q.isEmpty()){
            Point tmp = q.poll();

            for(int d = 0; d< 4; d++){
                int nx = tmp.x + dx[d];
                int ny = tmp.y + dy[d];

                if(0 <= nx && nx < N && 0<= ny && ny <N){
                    if(!visit[nx][ny] && map[nx][ny] == tmp.color){
                        q.offer(new Point(nx,ny,tmp.color));
                        visit[nx][ny] = true;
                    }
                }
            }

        }

    }

}
