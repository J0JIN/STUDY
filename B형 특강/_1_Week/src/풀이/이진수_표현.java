package 풀이;

import java.util.Scanner;

public class 이진수_표현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int bit = (1 << (N)) - 1;

//            if ((M & bit) == bit) {
//                System.out.println("#" + t + " " + "ON");
//            } else {
//                System.out.println("#" + t + " " + "OFF");
//            }

            if ((M | bit) == bit) {
                System.out.println("#" + t + " " + "ON");
            } else {
                System.out.println("#" + t + " " + "OFF");
            }
        }
    }
}
