import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_4179_불2트 {

    static class Point {
        int x, y, dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static Queue<Point> queueJ;
    static Queue<Point> queueF;
    static char[][] map;
    static int[][] distF;
    static int[][] distJ;
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        R = Integer.parseInt(str[0]); // Row = y
        C = Integer.parseInt(str[1]); // Col = x

        map = new char[C + 2][R + 2];
        distF = new int[C + 2][R + 2];
        distJ = new int[C + 2][R + 2];
        queueJ = new LinkedList<>();
        queueF = new LinkedList<>();

        for (int j = 1; j <= R; j++) {
            String input = br.readLine();
            for (int i = 1; i <= C; i++) {
                map[i][j] = input.charAt(i - 1);
                distJ[i][j] = -1;
                distF[i][j] = -1;

                if (map[i][j] == 'J') {
                    queueJ.add(new Point(i, j, 0));
                    distJ[i][j] = 0;
                }
                if (map[i][j] == 'F') {
                    queueF.add(new Point(i, j, 0));
                    distF[i][j] = 0;
                }
            }
        }

        Frun();
        Jrun();
    }

    static void Frun() {
        while (!queueF.isEmpty()) {
            Point tmp = queueF.poll();

            for (int d = 0; d < 4; d++) {
                int nx = tmp.x + dx[d];
                int ny = tmp.y + dy[d];
                int ndist = tmp.dist + 1;

                if (1 <= nx && nx <= C && 1 <= ny && ny <= R
                        && map[nx][ny] != '#' && distF[nx][ny] == -1) {
                    distF[nx][ny] = ndist;
                    queueF.offer(new Point(nx, ny, ndist));
                }
            }
        }
    }

    static void Jrun() {
        while (!queueJ.isEmpty()) {
            Point tmp = queueJ.poll();

            for (int d = 0; d < 4; d++) {
                int nx = tmp.x + dx[d];
                int ny = tmp.y + dy[d];
                int ndist = tmp.dist + 1;

                if (nx < 1 || nx > C || ny < 1 || ny > R) {
                    System.out.println(ndist);
                    return;
                }

                if (map[nx][ny] != '#' && distJ[nx][ny] == -1) {
                    if (distF[nx][ny] > ndist || distF[nx][ny] == -1) {
                        distJ[nx][ny] = ndist;
                        queueJ.offer(new Point(nx, ny, ndist));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
