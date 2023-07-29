import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_2573_빙산 {

    // 빙산 덩어리 2개 판정은 BFS
    // 나머지 줄어드는것은 구현으로

    // 빙산 MAP의 숫자를 주변에 0인 갯수만큼 줄임 (녹임)
    // BFS로 나눠진걸 판정
    // day++

    static int M, N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Ice> queue;

    static class Ice {
        int cur_x;
        int cur_y;

        public Ice(int cur_x, int cur_y) {
            this.cur_x = cur_x;
            this.cur_y = cur_y;
        }
    }

    public static void bfs(Ice ice) { // 트리 갯수를 세면 되므로 따로 반환 X
        queue.add(ice);
        int x = ice.cur_x;
        int y = ice.cur_y;
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Ice tmp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tmp.cur_x + dx[i];
                int ny = tmp.cur_y + dy[i];
                if (1 <= nx && nx <= M && 1 <= ny && ny <= N) {
                    if (visit[nx][ny] == false && map[nx][ny] != 0) {// map 조건 계속 깜빡하는데 넣자 제발;
                        queue.add(new Ice(nx,ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }

    }

    public static boolean separate(){
        int root = 0;

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                visit[i][j] = false;
            }
        }// 실수 1. visit가 전역변수이니까 bfs 실행 전에 초기화 시켜줘야됨

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                if (visit[i][j] == false && map[i][j] != 0) {
                    bfs(new Ice(i, j));
                    root++;
                }
            }
        }

        if(root>=2){
            return true;
        }else {
            return false;
        }
    }

    public static void melt() { // 실수2. 실시간으로 녹여버리니까 다 녹아버리네..;;

        int[][] newMap = new int[M + 1][N + 1]; //즉시 반영이 아니라 여기서 종합하고 반영

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    if(map[i][j] != 0) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (1 <= nx && nx <= M && 1 <= ny && ny <= N) {
                            if (map[nx][ny] == 0) {
                                count++;
                            }
                        }
                    }
                }

                newMap[i][j] = Math.max(map[i][j] - count, 0);
            }
        }

        // 갱신 값 저장
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                map[i][j] = newMap[i][j];
            }
        }
    }

    public static boolean checkZero(){
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                if(map[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[M + 1][N + 1];
        visit = new boolean[M + 1][N + 1];

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                map[i][j] = sc.nextInt();
            }
        }

        int day = 1;
        boolean check = false;
        while (true){
            melt();
            if(separate()){
                break;
            }// 나눠지면 멈추고
            if(checkZero()){
                day = 0;
                break;
            }// 다 녹으면 0을 출력하고 멈추고
            day++;
        }// 실수 3. 0인 경우때문에 시간 초과가 뜨는 것 같은데..

        System.out.println(day);

    }
}
