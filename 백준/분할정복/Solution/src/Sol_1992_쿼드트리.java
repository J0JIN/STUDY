import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1992_쿼드트리 {
    static int[][] paper;
    static int[] count = new int[2];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                paper[i][j] = input[j] - '0';
            }
        }

        sb = new StringBuilder();
        dividePaper(0, 0, N);

        System.out.println(sb.toString());
    }

    static boolean check(int x, int y, int size){
        int color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dividePaper(int x, int y, int size) {
        if (check(x, y, size)) {
            sb.append(paper[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append("(");

        dividePaper(x, y, newSize);
        dividePaper(x, y + newSize, newSize);
        dividePaper(x + newSize, y, newSize);
        dividePaper(x + newSize, y + newSize, newSize);

        sb.append(")");
    }
}
