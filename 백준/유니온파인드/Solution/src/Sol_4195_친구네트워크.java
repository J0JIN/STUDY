import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sol_4195_친구네트워크 {

    static final int MAX = 200_000;
    static int[] root;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T; tc++ ) {
            int F = Integer.parseInt(br.readLine());
            int idx = 0;
            HashMap<String, Integer> map = new HashMap<>();

            root = new int[MAX];
            for(int i = 0; i < MAX; i++){
                root[i] = i;
            }

            size = new int[MAX];
            for(int i = 0; i < MAX; i++){
                size[i] = 1;
            }

            for(int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String A = st.nextToken();
                if(!map.containsKey(A)) {
                    map.put(A,idx);
                    idx++;
                }

                String B = st.nextToken();
                if(!map.containsKey(B)){
                    map.put(B,idx);
                    idx++;
                }

                union(map.get(A), map.get(B));
                sb.append(size[findRoot(map.get(A))]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static void union(int i, int j) {
        i = findRoot(i);
        j = findRoot(j);
        root[j] = i;

        if(i != j) {
            size[i] += size[j];
            size[j] = 0;
        }
    }

    private static int findRoot(int i) {
        if (i == root[i]) {
            return i;
        }
        return root[i] = findRoot(root[i]);
    }
}
