import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {

    static class point {
        public point() {
        }
        public point(int x, int y) {
            this.cur_x = x;
            this.cur_y = y;
        }
        int cur_x;
        int cur_y;
    }

    static boolean visit[][];
    static int map[][];
    static int N, M;
    static point start;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int bfs(point p) {
        Queue<point> queue = new LinkedList<>();
        queue.offer(p);
        visit[p.cur_x][p.cur_y] = true;

        int count = 1;// �떎�닔1 : 珥덇린�솕�뒗 �쟾�뿭 蹂��닔媛� �븘�땲�씪 �뿬湲곗꽌 �씠猷⑥뼱�졇�빞�맖..!

        while (!queue.isEmpty()) {
            point tmp_p = queue.poll();
            int x = tmp_p.cur_x;
            int y = tmp_p.cur_y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
                    if (map[nx][ny] == 1 && visit[nx][ny] == false) {
                        point np = new point(nx, ny);
                        queue.offer(np);
                        visit[nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        // 寃쎈줈�쓽 湲몄씠 update..! �씠 遺�遺꾩쓣 �뼱�뼸寃� �벐�뒗吏��뿉 ���빐�꽌 怨좊�� �븷 �븘�슂�꽦�씠 �엳寃좉뎄癒�
                        // bfs 臾몄젣�뒗 �씠履쎌쓣 �뼱�뼸寃� �젙�븯�뒗吏�媛� �빑�떖�씤�벏
                    }
                }
            }
        }
        return map[N][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        visit = new boolean[N + 1][M + 1];
        map = new int[N + 1][M + 1];

        for (int j = 1; j <= N; j++) {
            String input = br.readLine();
            for (int i = 1; i <= M; i++) {
                map[j][i] = input.charAt(i - 1) - '0';// �떎�닔 2: -'0' �빐以섏빞吏� �닽�옄媛� �맖
            }
        }// �떎�닔 3: N�씠�옉 M 怨꾩냽 �뿷媛덈━�꽕

        start = new point(1, 1);

        System.out.println(bfs(start));

    }
}
