import java.util.Arrays;
import java.util.Scanner;

public class Sol_3040_백설공주일곱난쟁 {

    static int[] num;
    static int[] ans;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        num = new int[9];
        visit = new boolean[9];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        comb(0, 0, 0);
    }

    public static void comb(int idx, int cnt, int sum) {
        if (idx == 9) {
            return;
        }
        if (cnt == 7) {
            System.out.println(sum);
            return;
        }


        visit[idx] = true;
        comb(idx + 1, cnt + 1, sum + num[idx]);
        visit[idx] = false;
        comb(idx + 1, cnt, sum);

    }
}
