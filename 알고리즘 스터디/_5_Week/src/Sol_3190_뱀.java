import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_3190_뱀 {

    static Deque<Point> snake = new LinkedList<>();
    static Queue<Command> cmd = new LinkedList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, K, L;

    static int curX = 1;
    static int curY = 1;
    static int look = 0;
    static int cnt = 0;


    static int[][] map;
    static int[][] apple;


    static StringTokenizer st;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Command {
        int commandTime;
        char command;

        public Command(int commandTime, char command) {
            this.commandTime = commandTime;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        play();
        System.out.println(cnt + 1);
    }

    private static void play() {
        while (true) {
            checkCommand();
            if (gameOver()) {
                break;
            }
            move();
            print();
            cnt++;
        }
    }

    private static void checkCommand() {
        if (!cmd.isEmpty() && cnt == cmd.peek().commandTime) {
            Command tmpCommand = cmd.poll();
            if (tmpCommand.command == 'D') {
                look = (look + 1) % 4;
            }
            if (tmpCommand.command == 'L') {
                look = (look - 1 + 4) % 4;
            }
        }
    }

    private static boolean gameOver() {
        int nx = curX + dx[look];
        int ny = curY + dy[look];

        // 만약 머리가 맵 밖을 벗어난다면
        if (N < nx || nx < 1 || N < ny || ny < 1) {
            return true;
        }

        // 만약 몸통에 머리가 포함된다면
        for (Point p : snake) {
            if (p.x == nx && p.y == ny) {
                return true;
            }
        }
        return false;
    }

    private static void move() {
        int nx = curX + dx[look];
        int ny = curY + dy[look];

        // 만약 머리가 맵 밖을 벗어난다면
        if (N < nx || nx < 1 || N < ny || ny < 1) {
            return;
        }

        // 만약 몸통에 머리가 포함된다면
        for (Point p : snake) {
            if (p.x == nx && p.y == ny) {
                return;
            }
        }

        snake.offer(new Point(nx, ny));
        // ?? 여기에 map[nx][ny] 있는거랑 무슨 차이지.. 왜 갱신이 안되는거지?

        if (map[nx][ny] != 2) {
            Point tail = snake.poll();
            map[tail.x][tail.y] = 0;
        }

        map[nx][ny] = 1;

        curX = nx;
        curY = ny;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        apple = new int[K][2];
        map[1][1] = 1;
        snake.offer(new Point(1, 1));

        // 사과 초기위치를 2으로
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            apple[i][0] = Integer.parseInt(st.nextToken());
            apple[i][1] = Integer.parseInt(st.nextToken());

            map[apple[i][1]][apple[i][0]] = 2;
        }

        // 명령어 초기화
        // cmd Queue에다가 순서대로 입력
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            cmd.offer(new Command(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        System.out.println("- " + cnt + " -");
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                sb.append(map[i][j] == 1 ? "X" : map[i][j]).append(" "); // 뱀의 위치 표시 수정
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println("-------------------");
    }

}