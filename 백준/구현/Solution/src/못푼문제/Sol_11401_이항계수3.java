package 못푼문제;

import java.math.BigInteger;
import java.util.Scanner;

public class Sol_11401_이항계수3 {
    //    Cr = n-1Cr + n-1Cr-1
//    메모이제이션으로 풀면 모듈러 연산에서 뻑나감
//    모듈러 연산 관련 공식 이용해야됨
    static int div = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(factorial(N));
    }

    public static BigInteger factorial(int num) {
        if (num <= 1) {
            return BigInteger.ONE;
        } else {
            return factorial((num - 1)).multiply(new BigInteger("" + num)).remainder(new BigInteger(""+div));
        }
    }

}
