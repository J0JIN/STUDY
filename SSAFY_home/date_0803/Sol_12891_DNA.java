import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Sol_12891_DNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int P = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]); // 첫째줄 입력

        char[] input = br.readLine().toCharArray(); // 둘째줄 입력

        String[] str1 = br.readLine().split(" "); // 셋째줄 입력
        int[] ansIdx = new int[4];
        for (int i = 0; i < 4; i++) {
            ansIdx[i] = Integer.parseInt(str1[i]);
        }

        int cur_start = 0;
        int cur_end = S - 1;
        int[] idx = new int[4];
        int answer = 0;

        for (int i = 0; i < S; i++) {
            updateIndex(input[i], 1, idx);
        }

        if (checkPassword(ansIdx, idx)) {
            answer++;
        }

        for (int i = cur_end + 1; i < P; i++) {
            updateIndex(input[cur_start], -1, idx);
            cur_start++;
            updateIndex(input[i], 1, idx);
            cur_end++;

            if (checkPassword(ansIdx, idx)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void updateIndex(char ch, int dx, int[] idx) {
        int mask = getMask(ch);
        idx[mask] += dx;
    }

    private static boolean checkPassword(int[] ansIdx, int[] idx) {
        for (int i = 0; i < 4; i++) {
            if (idx[i] < ansIdx[i]) {
                return false;
            }
        }
        return true;
    }
    private static int getMask(char ch) {
        if (ch == 'A') return 0;
        if (ch == 'C') return 1;
        if (ch == 'G') return 2;
        if (ch == 'T') return 3;
        return -1;
    }
}
