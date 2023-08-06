import java.util.Scanner;

public class Sol_9663_NQueen {

    static int N;
    static int[][] map;
    static int ans;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {-1, 1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N + 1][N + 1];

        NQueen(1);
        System.out.println(ans);
    }

    private static void NQueen(int row) {

        if(row == N +1){
            ans++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (map[i][row] == 0) {
               plus(i,row); //
               NQueen(row+1);
               minus(i,row);
            }
        }
    }

    static void plus(int i, int row){
        for (int y = 1; y <= N; y++) {
            map[i][y]++;
        }
        for (int x = 1; x <= N; x++) {
            map[x][row]++;
        }
        map[i][row]--;
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = row + dy[d];
            while (true) {
                if (1<= nx && nx<=N && 1<= ny && ny <= N){
                    map[nx][ny]++;
                    nx += dx[d];
                    ny += dy[d];
                }else{
                    break;
                }
            }
        }
    }
    static void minus(int i, int row){
        for (int y = 1; y <= N; y++) {
            map[i][y]--;
        }
        for (int x = 1; x <= N; x++) {
            map[x][row]--;
        }
        map[i][row]++;
        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = row + dy[d];
            while (true) {
                if (1<= nx && nx<=N && 1<= ny && ny <= N){
                    map[nx][ny]--;
                    nx += dx[d];
                    ny += dy[d];
                }else{
                    break;
                }
            }
        }
    }
}
