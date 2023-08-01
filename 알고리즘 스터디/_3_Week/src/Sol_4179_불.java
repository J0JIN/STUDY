import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_4179_불 {
    // 지훈이동
    // 불 확산

    static char[][] map;
    static boolean[][] visitJ;
    static boolean[][] visitF;
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        R = Integer.parseInt(str[0]); //Row = y
        C = Integer.parseInt(str[1]); //Col = x

        map = new char[C + 2][R + 2];
        visitJ = new boolean[C + 2][R + 2];
        visitF = new boolean[C + 2][R + 2];

        int Jstart_x = 0;
        int Jstart_y = 0;
        int Fstart_x = 0;
        int Fstart_y = 0;

        for (int j = 1; j <= R; j++) {
            String input = br.readLine();
            for (int i = 1; i <= C; i++) {
                map[i][j] = input.charAt(i - 1);
                if (map[i][j] == 'J') {
                    Jstart_x = i;
                    Jstart_y = j;
                }
                if (map[i][j] == 'F') {
                    Fstart_x = i;
                    Fstart_y = j;
                }
            }
        }

        Jrun(Jstart_x, Jstart_y);

    }

    public static void Jrun(int x, int y) {
        Queue<int[]> jq = new LinkedList<>();
        jq.offer(new int[]{x, y});
        visitJ[x][y] = true;

        int count = 0;

        while (!jq.isEmpty()) {
            count++;
            int[] tmp = jq.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            Frun();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 1 || nx > C || ny < 1 || ny > R) {
                    System.out.println(count-1);
                    return;
                }

                if (map[ny][nx] != '#' && visitJ[ny][nx] == false) {
                    visitJ[ny][nx] = true;
                    jq.offer(new int[]{nx, ny});
                }
            }

        }

    }

    private static void Frun() {
        // 확산이 맛탱이가 가버렸네 바로 리턴하자니 맨 처음칸만 확산하고 말고
        // 안하자니 전부 불타버리고
        // BFS 느낌으로 리스트에 저장하고 바꿔야될듯
        // 애초에 BFS였음 ㅎ
        Queue<int[]> fq = new LinkedList<>();

        for (int j = 1; j <= R; j++) {
            for (int i = 1; i <= C; i++) {
                if (map[i][j] == 'F') {
                    fq.offer(new int[]{i, j});
                }
            }
        }

        while (!fq.isEmpty()) {
            int[] tmp = fq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];

                if (1 <= nx && nx <= C && 1 <= ny && ny <= R && map[nx][ny] != '#') {
                    map[nx][ny] = 'F';
                    fq.offer(new int[]{nx, ny});
                }
            }
        }
        return;
    }

    public static void print() {
        for (int j = 1; j <= R; j++) {
            for (int i = 1; i <= C; i++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
