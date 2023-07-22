import java.util.Scanner;

public class Sol_2108_통계학 {
    // 데이터 개수가 50만개.. 소트는 어림도 없겠네
    // -4000~ 4000.. 평균 구할 때 전체를 더하면 20억? Int로 처리 가능하겠구먼

    // 애초에 최빈값 구할 때 arr[input]++ 사용하니까 이거 기준으로 다른 통계값 구할 수 있나?

    // 1. 산술평균 -> 입력 시 total값 구하기
    // 2. 중앙값 -> 가능 | count 두고  arr[i]의 누적 합이 N/2가 되는 곳
    // 3. 최빈값 -> 가능 | 가장 큰 arr[i]
    // 4. 범위 -> 가능 | arr[i]가 0이 되는 곳과 끝나는 곳 체크.

    // 최대값 최소값은 입력 받을때, total은 입력 받을 때
    // -> 1, 4번 해결

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[8001];

        int N = sc.nextInt();

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int med = 0;
        int frq = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            arr[num + 4000]++;

            sum += num;

            if (max < num) {
                max = num;
            }

            if (min > num) {
                min = num;
            }
        }

        int count = 0;
        int frq_max = 0;
        boolean first = false;

        for (int i = min + 4000; i <= max + 4000; i++) {

            if (arr[i] > 0) {
                if (count < (N + 1) / 2) {
                    count += arr[i];
                    med = i - 4000;
                }

                if (frq_max < arr[i]) {
                    frq_max = arr[i];
                    frq = i - 4000;
                    first = true;
                }

                else if(frq_max == arr[i] && first == true){
                    frq = i -4000;
                    first = false;
                }
            }
        }

        System.out.println((int) Math.round((double) sum / N));    // 산술평균
        System.out.println(med);    // 중앙값
        System.out.println(frq);    // 최빈값
        System.out.println(max - min);    // 범위

    }

}
