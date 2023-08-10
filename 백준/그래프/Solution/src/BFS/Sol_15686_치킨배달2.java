import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_15686_치킨배달2 {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, total;
    static int[][] map;
    static boolean[] visit;

    static int min = Integer.MAX_VALUE;
    static ArrayList<Point> chick;
    static ArrayList<Point> house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input01 = br.readLine().split(" ");

        N = Integer.parseInt(input01[0]);
        M = Integer.parseInt(input01[1]);
        total = 0;

        map = new int[N + 1][N + 1];

        chick = new ArrayList<>();
        house = new ArrayList<>();

        for (int j = 1; j <= N; j++) {
            String[] input02 = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                map[i][j] = Integer.parseInt(input02[i - 1]);
                if (map[i][j] == 2) {
                    chick.add(new Point(i, j));
                }
                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                }
            }
        }

        visit = new boolean[chick.size()];
        comb(0, 0);
        System.out.println(min);
    }

    public static void comb(int idx, int cnt) {
        if (cnt == M) {
            int total = 0;
            for (int i = 0; i < house.size(); i++) {
                int minDist = Integer.MAX_VALUE;
                for (int j = 0; j < chick.size(); j++) {
                    if (visit[j] == true) {
                        int dist = Math.abs(house.get(i).x - chick.get(j).x) + Math.abs(house.get(i).y - chick.get(j).y);
                        minDist = Math.min(minDist, dist);
                    }
                }
                total += minDist;
            }
            min = Math.min(total, min);
            return;
        }

        for (int i = idx; i < chick.size(); i++) {
            if (visit[i] == false) {
                visit[i] = true;
                comb(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }
}