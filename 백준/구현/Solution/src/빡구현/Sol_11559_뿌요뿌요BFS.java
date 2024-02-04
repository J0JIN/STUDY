package 빡구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sol_11559_뿌요뿌요BFS {

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static char[][] map;
    private static boolean isOver;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};
    private static int combo = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[6][12];
        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[j][i] = input.charAt(j);
            }
        }

        isOver = false;
        while (!isOver) {
            isOver = true;
            boolean[][] visited = new boolean[6][12];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[j][i] != '.' && !visited[j][i]) {
                        if (bfs(j, i, map[j][i], visited) >= 4) {
                            isOver = false;
                        }
                    }
                }
            }
            if (!isOver) {
                pushDown();
                combo++;
            }
        }

        System.out.println(combo);
    }

    private static int bfs(int x, int y, char color, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> toClear = new ArrayList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            toClear.add(p);

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < 6 && ny >= 0 && ny < 12 && !visited[nx][ny] && map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        if (toClear.size() >= 4) {
            for (Point p : toClear) {
                map[p.x][p.y] = '.';
            }
            return toClear.size();
        }

        return 0;
    }

    private static void pushDown() {
        for (int col = 0; col < 6; col++) {
            for (int row = 11; row >= 0; row--) {
                if (map[col][row] == '.') {
                    for (int k = row - 1; k >= 0; k--) {
                        if (map[col][k] != '.') {
                            map[col][row] = map[col][k];
                            map[col][k] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
