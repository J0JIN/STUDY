package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2166_다각형의면적 {

    static long[] x, y;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        x = new long[N+1];
        y = new long[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];

        long xy = 0;
        long yx = 0;

        for (int i = 0; i < N ; i++) {
            xy += x[i] * y[i + 1];
            yx += y[i] * x[i + 1];
        }

        String area = String.format("%.1f", (Math.abs(xy - yx) / 2.0));
        System.out.printf(area);
    }

}
