import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sol_1199_오일러 {
    static int N;
    static ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    static int[][] edgeCount;

    static StringBuilder sb = new StringBuilder();

    public static class Pair {
        int index;
        int vtx;

        public Pair(int index, int vtx) {
            this.index = index;
            this.vtx = vtx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        edgeCount = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int vtxTotal = 0;

            for (int j = 0; j < N; j++) {
                int vtx = Integer.parseInt(input[j]);
                if (vtx > 0) {
                    list.get(i).add(new Pair(j, vtx));
                    edgeCount[i][j] = vtx;
                    vtxTotal += vtx;
                }
            }

            if (vtxTotal % 2 == 1) {
                System.out.println(-1);
                return;
            }
        }

        dfs(0);
        System.out.println(sb.toString());
    }

    static void dfs(int start) {
        for (int i = 0; i < list.get(start).size(); i++) {
            Pair pair = list.get(start).get(i);
            int next = pair.index;
            if (pair.vtx > 0) {
                pair.vtx--;
                for (int j = 0; j < list.get(next).size(); j++) {
                    if (list.get(next).get(j).index == start) {
                        list.get(next).get(j).vtx--;
                        break;
                    }
                }
                dfs(next);
            } else {
                list.get(start).remove(i);
                i--;
            }
        }
        sb.append((start + 1) + " ");
    }
}

