import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sol_4179_불 {
    // 지훈이동
    // 불 확산

    static Queue<int[]> queue;

    static char[][] map;
    static boolean[][] visitJ;
    static boolean[][] visitF;
    static int R, C;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        R = Integer.parseInt(str[0]); // Row = y
        C = Integer.parseInt(str[1]); // Col = x

        map = new char[C + 2][R + 2];
        visitJ = new boolean[C + 2][R + 2];
        visitF = new boolean[C + 2][R + 2];
        queue = new LinkedList<>();

        for (int j = 1; j <= R; j++) {
            String input = br.readLine();
            for (int i = 1; i <= C; i++) {
                map[i][j] = input.charAt(i - 1);
                if (map[i][j] == 'J') {
                    queue.add(new int[] { i, j, 0 ,0});
                    visitJ[i][j] = true;
                }
                if (map[i][j] == 'F') {
                    queue.add(new int[] { i, j, 1 ,0});
                    visitF[i][j] = true;
                }
            }
        }

        Frun();
    }

    public static void Jrun() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.peek();

            if (tmp[2] == 0) {
                tmp = queue.poll();
                int cx = tmp[0];
                int cy = tmp[1];
                boolean noway = true;

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (map[nx][ny] == '.') {
                        noway = false;
                    }

                    if (nx < 1 || nx > C || ny < 1 || ny > R) {
                        System.out.println(tmp[3]+1);
                        queue.clear();
                        return;
                    }

                    if (map[nx][ny] != 'F' && map[nx][ny] != '#' && visitJ[nx][ny] == false) {
                        map[nx][ny] = 'J';
                        if (map[cx][cy] != 'F') {
                            map[cx][cy] = '.';
                        }
                        visitJ[nx][ny] = true;
                        queue.offer(new int[] { nx, ny, 0 , tmp[3]+1});
                    }

                }

//                System.out.println("J");
                print();
            } else {
                Frun();
            }
        }
    }

    private static void Frun() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.peek();

            if (tmp[2] == 1) {
                tmp = queue.poll();

                int cx = tmp[0];
                int cy = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (1 <= nx && nx <= C && 1 <= ny && ny <= R && map[nx][ny] != '#' && visitF[nx][ny] == false) {
                        map[nx][ny] = 'F';
                        visitF[nx][ny] = true;
                        queue.offer(new int[] { nx, ny, 1 });
                    }

                }
//                System.out.println("F");
                print();
            } else {
                Jrun();
            }
        }
    }

    public static void print() {
        for (int j = 1; j <= R; j++) {
            for (int i = 1; i <= C; i++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("========================");
    }
}// 걍 Queue 두개로 나눠 풀래 조건 갱신이 동시에 안되가지고 곱창나네 진짜;;
//