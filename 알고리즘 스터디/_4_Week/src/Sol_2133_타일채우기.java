import java.util.Scanner;

public class Sol_2133_타일채우기 {

    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        data = new int[N + 1];
        if (N % 2 == 1) {
            System.out.println(0);
        } else {
            System.out.println(dp(N / 2));
        }
    }

    public static int dp(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 3;
        }

        if (n == 2) {
            return 11;
        }

        if (data[n] != 0) {
            return data[n];
        } else {
            data[n] = 4 * dp(n - 1) - dp(n - 2);
            return data[n];
        }
    }

}
