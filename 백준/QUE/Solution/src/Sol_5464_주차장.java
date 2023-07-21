import java.util.LinkedList;
import java.util.Scanner;

public class Sol_5464_주차장 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] parking = new int[N];
        int[] carWeight = new int[M];
        int[] parkingWeight = new int[N];
        LinkedList<Integer> carWaiting = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            parkingWeight[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            carWeight[i] = sc.nextInt();
        }

        int sum = 0;
        out:
        for (int t = 0; t < (M * 2); t++) {
            int car = sc.nextInt();

            if (car > 0) {
                for (int i = 0; i < N; i++) {
                    if (parking[i] == 0) {
                        parking[i] = car;
                        continue out;
                    }
                }// 빈자리 있어서 주차
                carWaiting.offer(car);
            }

            if (car < 0) {
                car = -car;
                for (int i = 0; i < N; i++) {
                    if (parking[i] == car) {
                        sum += carWeight[car - 1] * parkingWeight[i]; // 정산
                        if(!carWaiting.isEmpty()){
                            parking[i] = carWaiting.poll();
                        }else {
                            parking[i] = 0;
                        }
                    }
                }// 출차
            }
        }
        System.out.println(sum);
    }
}
