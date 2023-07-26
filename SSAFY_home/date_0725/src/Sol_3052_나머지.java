import java.util.Scanner;

public class Sol_3052_나머지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        int N = 42;
        int[] countN = new int[N];
        int count = 0;

        for (int t = 0; t < tc; t++) {
            countN[sc.nextInt() % 42]++;
        }

        for (int i = 0; i < N; i++) {
            if (countN[i] != 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
