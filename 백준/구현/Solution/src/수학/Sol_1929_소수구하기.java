package 수학;

import java.util.Scanner;

public class Sol_1929_소수구하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] prime = new boolean[N + 1];

        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j <= N; j += i) {
                prime[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }

    }
}
