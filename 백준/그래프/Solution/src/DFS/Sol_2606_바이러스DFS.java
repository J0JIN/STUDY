import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sol_2606_바이러스DFS {

    static int V, E;
    static Node[] nodes;
    static boolean[] visit;
    static int count = 0;

    static class Node {
        int V;
        ArrayList<Integer> E = new ArrayList<>();

        public Node(int v) {
            V = v;
        }
    }

    public static void dfs(int v) {
        visit[v] = true;

        for (int i = 0; i < nodes[v].E.size(); i++) {
            int n_node = nodes[v].E.get(i);
            if (visit[n_node] == false) {
                dfs(n_node);
                visit[n_node] = true;
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();

        nodes = new Node[V + 1];
        visit = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= E; i++) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            nodes[v].E.add(e);
            nodes[e].E.add(v);
        }

        dfs(1);

        System.out.println(count);
    }

}
