import java.util.Scanner;

public class Sol_1002_터렛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int x1, x2, y1, y2, r1, r2;

            x1 = sc.nextInt();
            y1 = sc.nextInt();
            r1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            r2 = sc.nextInt();

            double dist_p = Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));

            if (Math.abs(r2 - r1) < dist_p && dist_p < Math.abs(r1 + r2)) {
                System.out.println("2");
            }else if ((Math.abs(r1 + r2) == dist_p || Math.abs(r1 - r2) == dist_p)) {
                if (dist_p == 0 && r1 == r2) {
                    System.out.println("-1");
                } else if(dist_p == 0 && r1 != r2) {
                    System.out.println("0");
                }else {
                    System.out.println("1");
                }
            }else if (Math.abs(r1 + r2) < dist_p || Math.abs(r1 - r2) > dist_p) {
                System.out.println("0");
            }
        }

    }
}
