package 못푼문제;

import java.util.Scanner;

public class Sol_11401_이항계수3 {
    //    Cr = n-1Cr + n-1Cr-1
//    메모이제이션으로 풀면 모듈러 연산에서 뻑나감
//    모듈러 연산 관련 공식 이용해야됨
    static long div = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long R = sc.nextLong();

//      페르마 소정리 이용
//      n! / ((n-k)! * k!)   ->   n! * ((n-k)! * k!)^(-1) 으로 변환
//      ((n-k)! * k!)^(-1) == ((n-k)! * k!)^(p-2) 동치

        System.out.println((factorial(N) * exponent((factorial(N - R) * factorial(R)) % div, div - 2)) %div);
    }

    static long factorial(long N) {
        if (N == 0) {
            return 1l;
        }
        return (N % div) * (factorial(N - 1) % div);
    }

    static long exponent(long a, long n) {
        long ret = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ret *= a;
                n--;
                ret %= div;
            }
            a *= a;
            a %= div;
            n /= 2;
        }
        return ret;
    }
}
