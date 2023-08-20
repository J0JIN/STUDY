package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Sol_14502_연구소 {

    static int[][] map;
    static int[][] mapCopy;


    static int X, Y;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int ans = 0;

    static StringTokenizer st;

    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[X][Y];

        for (int j = 0; j < Y; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < X; i++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);

        System.out.println(ans);
    }

    private static void makeWall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int j = 0; j < Y; j++) {
            for (int i = 0; i < X; i++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    private static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        mapCopy = new int[X][Y];

        for (int j = 0; j < Y; j++) {
            for (int i = 0; i < X; i++) {
                if (map[i][j] == 2) {
                    q.offer(new Point(i, j));
                }
            }
        }

        for (int j = 0; j < Y; j++) {
            for (int i = 0; i < X; i++) {
                mapCopy[i][j] = map[i][j];
            }
        }

        while(!q.isEmpty()){
            Point tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(0<=nx && nx<X && 0<=ny && ny<Y) {
                    if(mapCopy[nx][ny] == 0) {
                        q.add(new Point(nx,ny));
                        mapCopy[nx][ny] = 2;
                    }
                }
            }

        }

        checkSafe();
    }

    private static void checkSafe() {
        int safe = 0;

        for (int j = 0; j < Y; j++) {
            for (int i = 0; i < X; i++) {
                if(mapCopy[i][j] == 0){
                    safe++;
                }
            }
        }

        ans = Math.max(ans, safe);
    }

}
