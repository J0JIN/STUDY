import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2096_내려가기 {
    static StringTokenizer st;
    static int[] map, dpMax, dpMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[3];
        dpMax = new int[3];
        dpMin = new int[3];

        for (int t = 0; t < N; t++) {

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                int input = Integer.parseInt(st.nextToken());
                map[i] = input;
            }

            if (t == 0) {
                for (int i = 0; i < 3; i++) {
                    int input = map[i];
                    dpMax[i] = dpMin[i] = input;
                }
            } else {
                int beforeMax_0 = dpMax[0];
                int beforeMax_1 = dpMax[1];
                int beforeMax_2 = dpMax[2];
                dpMax[0] = Math.max(beforeMax_0, beforeMax_1) + map[0];
                dpMax[1] = Math.max(Math.max(beforeMax_0, beforeMax_1), beforeMax_2) + map[1];
                dpMax[2] = Math.max(beforeMax_1, beforeMax_2) + map[2];


                int beforeMin_0 = dpMin[0];
                int beforeMin_1 = dpMin[1];
                int beforeMin_2 = dpMin[2];
                dpMin[0] = Math.min(beforeMin_0, beforeMin_1) + map[0];
                dpMin[1] = Math.min(Math.min(beforeMin_0, beforeMin_1), beforeMin_2) + map[1];
                dpMin[2] = Math.min(beforeMin_1, beforeMin_2) + map[2];
            }

        }

        int max = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
        int min = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);

        System.out.println(max + " " + min);
    }

}
