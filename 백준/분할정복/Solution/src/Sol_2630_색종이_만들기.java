import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2630_색종이_만들기 {

    static int[][] paper;
    static int[] count = new int[2];

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dividePaper(0, 0, N);

        System.out.println(count[0]);
        System.out.println(count[1]);
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
            count[paper[x][y]]++;
            return;
        }

        int newSize = size / 2;
        dividePaper(x, y, newSize);
        dividePaper(x, y + newSize, newSize);
        dividePaper(x + newSize, y, newSize);
        dividePaper(x + newSize, y + newSize, newSize);

    }

}
