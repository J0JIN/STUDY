import java.util.Scanner;

public class Sol_2023_신기한소수 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        set(2,0);
        set(3,0);
        set(5,0);
        set(7,0);
    }

    private static void set(int nums, int count) {
        if (count == N -1) {
            System.out.println(nums);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int next = 0;
            next = 10 * nums + i;
            if (isSosu(next)) {
                set(next, count + 1);
            }
        }
    }

    public static boolean isSosu(int n) {
        double root = Math.sqrt(n);
        for (int i = 2; i <= root; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
