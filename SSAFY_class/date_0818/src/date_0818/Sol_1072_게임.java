package date_0818;

import java.util.Scanner;

public class Sol_1072_게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double X = sc.nextDouble();
        double Y = sc.nextDouble();

        int targetWinRate = (int) (Y * 100 / X);

        if (targetWinRate >= 99) {
            System.out.println(-1);
        } else {
            long low = 0;
            long high = 1_000_000_000;
            long result = -1;

            while (low <= high) {
                long mid = (low + high) / 2;
                int currentWinRate = (int) ((Y + mid) * 100 / (X + mid));  // 현재 승률을 정수로 계산

                if (currentWinRate > targetWinRate) {
                    result = mid;  // 결과 값 업데이트
                    high = mid - 1;  // 더 작은 범위에서 탐색
                } else {
                    low = mid + 1;  // 더 큰 범위에서 탐색
                }
            }

            System.out.println(result);
        }
    }
}
