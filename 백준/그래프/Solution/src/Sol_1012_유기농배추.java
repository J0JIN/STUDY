import java.util.Scanner;

public class Sol_1012_유기농배추 {

    static int[][] plant;
    static boolean[][] check;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    // 북 동 서 남
    static int N, M;

    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            count = 0;

            M = sc.nextInt();
            N = sc.nextInt();

            plant = new int[M][N];
            check = new boolean[M][N];

            int K = sc.nextInt();

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                plant[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(check[i][j]==false && plant[i][j] == 1){
                        checkPoint(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void checkPoint(int x, int y) {
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < M && 0 <= ny && ny < N) { // 안벗어나면
                if (check[nx][ny] == false && plant[nx][ny] == 1) {
                    checkPoint(nx, ny);
                }
            }
        }
    }

}
