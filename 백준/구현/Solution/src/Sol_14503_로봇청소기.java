import java.util.Scanner;

public class Sol_14503_로봇청소기 {
    public static int[][] room;
    public static int count = 0;
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {-1, 0, 1, 0}; // dy , dx 반대로 씨발

    public static class Robot {
        public int cur_x;
        public int cur_y;
        public int look;

        public void clean() {
            if (room[cur_x][cur_y] == 0) {
                room[cur_x][cur_y] = 2;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Robot robot = new Robot();

        int M = sc.nextInt();
        int N = sc.nextInt();

        room = new int[M][N];

        robot.cur_x = sc.nextInt();
        robot.cur_y = sc.nextInt();
        robot.look = sc.nextInt();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                room[i][j] = sc.nextInt();
            }
        }
        while (true) {
            robot.clean();
            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            if (!checkEmpty(robot.cur_x, robot.cur_y)) {
                // 2.1) 바라보는 방향을 유치한채로 한칸 후진할 수 있다면
                int back = (robot.look + 2) % 4;
                if (room[robot.cur_x + dx[back]][robot.cur_y + dy[back]] != 1) {
                    robot.cur_x += dx[back];
                    robot.cur_y += dy[back];
                } else {
                    break; // 2.2) 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                }
            } else { // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                // 3.1) 반시계 방향으로 90도 회전한다.
                robot.look = (robot.look + 3) % 4;
                // 3.2) 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우
                if (room[robot.cur_x + dx[robot.look]][robot.cur_y + dy[robot.look]] == 0) {
                    robot.cur_x += dx[robot.look];
                    robot.cur_y += dy[robot.look];
                }
            }
        }
        System.out.println(count);
    }

    //  현재 칸 주변 4칸 탐색
    public static boolean checkEmpty(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (room[x + dx[i]][y + dy[i]] == 0) {
                return true;
            }
        }
        return false;
    }
}