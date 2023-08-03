import java.util.Arrays;
import java.util.Scanner;

public class 달팽이 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            map = new int[N][N];

            System.out.println("#" + tc);
            snail(N);
        }

    }

    public static void snail(int N) {
        int cx = 0;
        int cy = 0;
        int count = 1;
        int dir = 0;
        int nx = 0;
        int ny = 0;

        while (true) {
            if (count == N * N + 1) {
                break;
            }

            map[cx][cy] = count;

            nx = cx + dx[dir];
            ny = cy + dy[dir];

            if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 0) {
                cx = nx;
                cy = ny;
            } else {
                dir = (dir + 1) % 4;
                cx = cx + dx[dir];
                cy = cy + dy[dir];
            }
            count++;
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
