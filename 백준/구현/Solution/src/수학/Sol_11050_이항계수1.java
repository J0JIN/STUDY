package 수학;

import java.util.Scanner;

public class Sol_11050_이항계수1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long K = sc.nextInt();

        long a = 1;
        long b = 1;

        for (int i = 0; i < K; i++) {
            a *= ((long)N - (long)i);
        }
        System.out.println(a);
        for (int i = 1; i <= K; i++) {
            b *= (long)i;
        }
        System.out.println(b);

        System.out.println(a/b);


    }
}
