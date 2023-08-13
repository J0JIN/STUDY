package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1629_곱셈 {
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        System.out.println(pow(A, B));
    }

    public static long pow(long A, long B) {

        if (B == 0) {
            return 1;
        }

        if (B == 1) {
            return A % C;
        }

        long tmp = pow(A, B / 2);

        if (B % 2 == 1) {
            return (((tmp * tmp) % C) * A) % C;
        } else {
            return (tmp * tmp) % C;
        }
    }
}
