import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sol_7568_덩치 {
//    일단 몸무게 기준으로 sort
//    이후 등수 순서대로 1 2 3 4 5
//     if 1등 키 < 2등 키
//     -> 2등을 자기 앞에 사람과 같은 등수로 갱신
//     if 2등 키 < 3등 키
//     -> 3등을 자기 앞에 사람과 같은 등수로 갱신

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] bigMan = new int[N][4];

        for (int i = 0; i < N; i++) {
            bigMan[i][0] = sc.nextInt();
            bigMan[i][1] = sc.nextInt();
        }

//        for (int i = 1; i < N; i++) {
//            for (int j = 0; j < N - i; j++) {
//                if (bigMan[j][0] < bigMan[j + 1][0]) {
//                    int tmp_0 = 0, tmp_1 = 0;
//                    tmp_0 = bigMan[j][0];
//                    tmp_1 = bigMan[j][1];
//                    bigMan[j][0] = bigMan[j + 1][0];
//                    bigMan[j][1] = bigMan[j + 1][1];
//                    bigMan[j + 1][0] = tmp_0;
//                    bigMan[j + 1][1] = tmp_1;
//                }
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            bigMan[i][2] = i + 1;
//            System.out.println(bigMan[i][3]);
//        }// 등수매기기
//
//        for (int i = 0; i < N - 1; i++) {
//            if (bigMan[i][1] < bigMan[i + 1][1]) {
//                bigMan[i + 1][2] = bigMan[i][2];
//            }
//        }
//
//        for (int i = 1; i <=N; i++) {
//            for(int j = 0; j < N; j ++){
//                if(bigMan[j][3] == i){
//                    System.out.print(bigMan[j][2] + " ");
//                }
//            }
//        } --> 소팅하니까 기존 등수를 모르네.. 처음부터 다시

//      ?? 그냥 본인보다 둘 다 큰거 갯수 세면 되는거 아님? ㅋㅋㅋㅋ
        for(int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N; j++) {
                if (bigMan[i][0] < bigMan[j][0] && bigMan[i][1] < bigMan[j][1]) {
                    count++;
                }
            }

            System.out.print(count + " ");

        }
    }
}
