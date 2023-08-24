import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {

    static ArrayList<ArrayList<Node>> list;
    static boolean visited[];
    static StringTokenizer st;
    static int maxDepth;
    static int maxVertex;

    private static class Node {
        int vertex, depth;

        public Node(int vertex, int depth) {
            this.vertex = vertex;
            this.depth = depth;
        }

        public Node(int vertex) {
            this.vertex = vertex;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            list = new ArrayList<>();
            for (int a = 0; a <= 100; a++) {
                list.add(new ArrayList<>());
            }

            visited = new boolean[101];

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list.get(from).add(new Node(to));
            }

            bfs(start);
            System.out.println("#" + t + " " + maxVertex);
        }
    }

    private static void bfs(int start) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start, 0));
        visited[start] = true;
        maxDepth = -1;
        maxVertex = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int tmp = cur.vertex;

            if (cur.depth > maxDepth) {
                maxDepth = cur.depth;
                maxVertex = tmp;
            } else if (cur.depth == maxDepth) {
                maxVertex = Math.max(maxVertex, tmp);
            }

            for (Node next : list.get(tmp)) {
                if (!visited[next.vertex]) {
                    visited[next.vertex] = true;
                    q.offer(new Node(next.vertex, cur.depth + 1));
                }
            }
        }
    }
}
