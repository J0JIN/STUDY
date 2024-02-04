package 빡구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sol_11559_뿌요뿌요 {

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
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[j][i] != '.') {
                        List<Point> connected = new ArrayList<>();
                        if (dfs(j, i, map[j][i], connected, new boolean[6][12]) >= 4) {
                            for (Point p : connected) {
                                map[p.x][p.y] = '.';
                            }
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

    private static int dfs(int x, int y, char color, List<Point> connected, boolean[][] visited) {
        int count = 1;
        visited[x][y] = true;
        connected.add(new Point(x, y));
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 6 && ny >= 0 && ny < 12 && !visited[nx][ny] && map[nx][ny] == color) {
                count += dfs(nx, ny, color, connected, visited);
            }
        }
        return count;
    }

    private static void pushDown() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i > 0; i--) {
                if (map[j][i] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[j][k] != '.') {
                            map[j][i] = map[j][k];
                            map[j][k] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
