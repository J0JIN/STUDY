import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_5430_AC_배열구현 {

    // R 함수, D함수 구현
    // R 함수
    // 동일한 크기의 배열을 만들고 끝에서부터 순서대로 담고 갱신

    // D함수
    // 크기-1 배열을 선언하고 n에 n+1값을 순서대로 집어넣기
    // 크기-1 배열을 생성할 수 없으면 error 출력

    static int[] arr;
    static int N;

    public static void R() {
        int[] swp = new int[N];
        for (int i = 0; i < N; i++) {
            swp[N - 1 - i] = arr[i];
        }
        for (int i = 0; i < N; i++) {
            arr[i] = swp[i];
        }
    }

    public static void D() {
        if (N - 1 >= 0) {
            int[] del = new int[N - 1];
            for (int i = 0; i < N - 1; i++) {
                del[i] = arr[i + 1];
            }
            for (int i = 0; i < N - 1; i++) {
                arr[i] = del[i];
            }
            N--;
        } else {
            System.out.println("error");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {

            String str1 = br.readLine();
            char[] command = new char[str1.length()];

            for (int i = 0; i < str1.length(); i++) {
                command[i] = str1.charAt(i);
            }

            N = Integer.parseInt(br.readLine());

            arr = new int[N];

            String str2 = br.readLine();
            str2 = str2.replace("]", "");
            str2 = str2.replace("[", "");
            String[] num = str2.split(",");

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(num[i]);
            }

            for (int i = 0; i < command.length; i++) {
                switch (command[i]) {
                    case 'R':
                        R();
                        break;
                    case 'D':
                        D();
                        break;
                }
            }

            for (int i = 0; i < N; i++) {
                if(i == 0){
                    System.out.print("[");
                }
                System.out.print(arr[i]);
                if (i < N - 1) {
                    System.out.print(",");
                }else {
                    System.out.println("]");
                }
            }
            N = 0;
        }
    }
}
