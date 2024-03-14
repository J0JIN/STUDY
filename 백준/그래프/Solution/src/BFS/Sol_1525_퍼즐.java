package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sol_1525_퍼즐 {

    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    private static class Puzzle {
        String key;
        int level;
        int x;
        int y;

        public Puzzle(String key, int level, int x, int y) {
            this.key = key;
            this.level = level;
            this.x = x;
            this.y = y;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "Puzzle{" +
                    "key='" + key + '\'' +
                    ", level=" + level +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Puzzle start = null;
        // 초기 입력
        map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    start = new Puzzle("", 0, i, j);
                }
            }
        }

        start.setKey(stringify(map));

        System.out.println(bfs(start));
    }

    private static int bfs(Puzzle start) {
        ArrayDeque<Puzzle> q = new ArrayDeque<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        q.offer(start);
        visited.put(start.key, true);

        while (!q.isEmpty()) {
            Puzzle cur = q.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            int cur_level = cur.level;
            String cur_key = cur.key;
            int[][] cur_map = deStringify(cur_key);

            if (cur_key.equals("1 2 3 4 5 6 7 8 0 ")) {
                return cur_level;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur_x + dx[d];
                int ny = cur_y + dy[d];
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                    continue;
                }

                swap(cur_map, cur_x, cur_y, nx, ny);

                String n_key = stringify(cur_map);
                if (visited.get(n_key) == null) {
                    q.offer(new Puzzle(n_key, cur_level + 1, nx, ny));
                    visited.put(n_key, true);
                }
                swap(cur_map, nx, ny, cur_x, cur_y);
            }
        }

        return -1;
    }

    private static void swap(int[][] curMap, int curX, int curY, int nx, int ny) {
        int tmp = curMap[curX][curY];
        curMap[curX][curY] = curMap[nx][ny];
        curMap[nx][ny] = tmp;
    }

    private static String stringify(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(map[i][j]).append(" ");
            }
        }
        return sb.toString();
    }

    private static int[][] deStringify(String key) {
        StringTokenizer st = new StringTokenizer(key);
        int[][] ret = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return ret;
    }
}
