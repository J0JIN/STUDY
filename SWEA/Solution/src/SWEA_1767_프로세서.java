import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서 {

    static int N;
    static int cnt;
    static int[][] map, originalMap;
    static int[] select;

    static ArrayList<Node> nodes;
    static StringTokenizer st;
    static int ans;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            originalMap = new int[N][N];
            cnt = 0;
            nodes = new ArrayList<>();
            ans = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    map[i][j] = originalMap[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        cnt++;
                        nodes.add(new Node(i, j));
                    }
                }
            }

            select = new int[cnt];

            for(int i = cnt; i >= 0; i--){
                perm(0, i);
                if(ans != Integer.MAX_VALUE){
                    System.out.println("#" + tc + " " + ans);
                    i = -1;
                    break;
                }
            }

        }

    }

    private static void perm(int idx, int cnt) {
        if (idx >= cnt) {
            deepCopy(map, originalMap);
            int count = 0;
            for (int i = 0; i < select.length; i++) {
                int x = nodes.get(i).x;
                int y = nodes.get(i).y;
                int look = select[i];

                if (!link(x, y, look)) {
                    return;
                }
            }

            ans = Math.min(ans, check2());
            return;
        }

        for (int i = 0; i < 4; i++) {
            select[idx] = i;
            perm(idx + 1, cnt);
        }
    }

    private static boolean link(int x, int y, int look) {
        while (true) {
            int nx = x + dx[look];
            int ny = y + dy[look];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (map[nx][ny] == 2 || map[nx][ny] == 1) {
                    return false;
                } else {
                    map[nx][ny] = 2;
                    x = nx;
                    y = ny;
                }
            } else {
                break;
            }
        }
        return true;
    }

    private static int check2() {
        int total = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 2) {
                    total++;
                }
            }
        }
        return total;
    }

    private static void deepCopy(int[][] arr1, int[][] arr2) {
        for (int j = 0; j < arr1.length; j++) {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i][j] = arr2[i][j];
            }
        }
    }
}
