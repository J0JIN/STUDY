import java.util.Scanner;

public class Sol_1358_하키 {

    static int W, H, X, Y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        W = sc.nextInt();
        H = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        int N = sc.nextInt();

        int[][] P = new int[N][2];
        int count = 0;

        for (int i = 0; i < N; i++) {
            P[i][0] = sc.nextInt();
            P[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int p_x = P[i][0];
            int p_y = P[i][1];
            if (inCircle(p_x, p_y) == true || inSquare(p_x, p_y) == true){
                count++;
            }
        }

        System.out.println(count);

    }

    public static boolean inCircle(int x, int y) {
        if (x >= X && y >= Y && x <= (X + W) && y <= (Y + H)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inSquare(int x, int y) {
        int R = H / 2;
        if (Math.pow(R, 2) >= Math.pow((X - x), 2) + Math.pow((Y + R - y), 2)) {
            return true;
        } else if (Math.pow(R, 2) >= Math.pow((X + W - x), 2) + Math.pow((Y + R - y), 2)) {
            return true;
        } else {
            return false;
        }
    }
}
