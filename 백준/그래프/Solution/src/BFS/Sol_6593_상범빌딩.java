package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_6593_상범빌딩 {

    static int x, y, z;
    static char[][][] map;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    private static class Node{
        int x, y, z;
        int dist;
        public Node(int x, int y, int z, int dist) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            z = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0 && z == 0) {
                System.out.println(sb.toString());
                return;
            }

            int start_x = 0;
            int start_y = 0;
            int start_z = 0;

            map = new char[z][y][x];
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < y; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < x; k++) {
                        map[i][j][k] = input.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start_x = k;
                            start_y = j;
                            start_z = i;
                            map[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();
            }
            bfs(start_x, start_y, start_z);
        }
    }

    static void bfs(int start_x, int start_y, int start_z) {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] check = new boolean[z][y][x];
        q.add(new Node(start_x, start_y, start_z, 0));
        check[start_z][start_y][start_x] = true;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            int cx = tmp.x;
            int cy = tmp.y;
            int cz = tmp.z;
            int cd = tmp.dist;

            if (map[cz][cy][cx] == 'E') {
                sb.append("Escaped in " + cd + " minute(s).\n");
                return;
            }

            for (int d = 0; d < 6; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nz = cz + dz[d];

                if (nx < 0 || ny < 0 || nz < 0 || nx > x - 1 || ny > y - 1 || nz > z - 1) continue;

                if (check[nz][ny][nx]) continue;

                if (map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E') {
                    check[nz][ny][nx] = true;
                    q.add(new Node(nx, ny, nz, cd + 1));
                }

            }
        }
        sb.append("Trapped!\n");
    }

}
