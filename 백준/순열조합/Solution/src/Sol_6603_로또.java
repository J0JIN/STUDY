import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_6603_로또 {

    static String[] input;
    static boolean[] visit;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            input = br.readLine().split(" ");

            if (input[0].equals("0")) {// 설마.. String 가지고 == 비교 하지말자
                break;
            }

            K = Integer.parseInt(input[0]);
            visit = new boolean[K];

            comb(0, 0);
            System.out.println();
        }
    }

    public static void comb(int idx, int count) {
        if (count == 6) {
            for (int i = 0; i < K; i++) {
                if (visit[i] == true) {
                    System.out.print(input[i + 1] + " ");
                }
            }
            System.out.println();
            return;
        }

        if(idx == K){
            return;
        }

        visit[idx] = true;
        comb(idx + 1, count + 1);
        visit[idx] = false;
        comb(idx + 1, count);

    }
}
