package 수학;

import java.util.Scanner;

public class Sol_11401_이항계수2 {
//    Cr = n-1Cr + n-1Cr-1
//    메모이제이션으로 풀면 모듈러 연산에서 뻑나감
//    모듈러 연산 관련 공식 이용해야됨
    static int[][] C;
    static int N, R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
//      페르마 소정리 이용
//      n! / ((n-k)! * k!)   ->   n! * ((n-k)! * k!)^(-1) 으로 변환
//      ((n-k)! * k!)^(-1) == ((n-k)! * k!)^(p-2) 동치

        System.out.println((factorial(N) * exponent((factorial(N - R) * factorial(R)) % 10007, 10007 - 2)) % 10007);
    }

    static int factorial(int N) {
        if(N == 0) {
            return 1;
        }
        return N * factorial(N - 1) % 10007;
    }

    static int exponent(int a, int n) {
        int ret = 1;
        while(n > 0) {
            if(n % 2 == 1) {
                ret *= a;
                n--;
                ret %= 10007;
            }
            a *= a;
            a %= 10007;
            n /= 2;
        }
        return ret;
    }
}
