package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Sol_8979_올림픽 {

    private static class Olympic implements Comparable<Olympic> {
        int id;
        int gold;
        int silver;
        int bronze;

        public Olympic(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Olympic o) {
            if (this.gold != o.gold) {
                return o.gold - this.gold;
            } else if (this.silver != o.silver) {
                return o.silver - this.silver;
            } else {
                return o.bronze - this.bronze;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Olympic> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Olympic(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && list.get(i).compareTo(list.get(i - 1)) != 0) {
                rank = i + 1;
            }

            if (list.get(i).id == K) {
                System.out.println(rank);
                break;
            }
        }
    }
}
