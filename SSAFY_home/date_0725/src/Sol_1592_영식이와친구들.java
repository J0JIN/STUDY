import java.util.Scanner;

public class Sol_1592_영식이와친구들 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // catch 한도
        int L = sc.nextInt(); // 던지는 방향

        int[] ballcatch = new int[N];//

        ballcatch[0] = 1;
        int cur_people = 0;
        int count = 0;

        while (true) {
            if (ballcatch[cur_people] == M) {// 종료 조건
                break;
            }

            if (ballcatch[cur_people] % 2 == 1) { // 홀수일시
                cur_people = (cur_people + L) % N;
                ballcatch[cur_people]++;
                count++;
            } else {
                cur_people = (cur_people - L + N) % N;// 짝수일시
                ballcatch[cur_people]++;
                count++;
            }
        }
        System.out.println(count);
    }

}
