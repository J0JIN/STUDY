import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1976_여행가자 {

    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        root = new int[N];

        for (int i = 0; i < N; i++) {
            root[i] = i;
        }

        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            findRoot(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int storeParent = root[Integer.parseInt(st.nextToken()) - 1];
        for (int i = 0; i < M - 1; i++) {
            if (storeParent != root[Integer.parseInt(st.nextToken()) - 1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }


    private static void union(int i, int j) {
        i = findRoot(i);
        j = findRoot(j);
        root[j] = i;
    }

    private static int findRoot(int i) {
        if (i == root[i]) {
            return i;
        }
        return root[i] = findRoot(root[i]);
    }
}
