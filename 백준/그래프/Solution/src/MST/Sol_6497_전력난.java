package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_6497_전력난 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static Edge[] edgeList;
    static int V, E;
    static int[] parents;

    static void make() {
        parents = new int[V];
        for(int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if(parents[a] == a) {
            return a;
        }
        return parents[a]= find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if(V == 0 && E == 0){
                break;
            }

            edgeList = new Edge[E];
            int total = 0;

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                total += weight;

                edgeList[i] = new Edge(from, to, weight);
            }

            Arrays.sort(edgeList);

            make();

            int mst_total = 0;
            for(int i = 0; i < edgeList.length; i++){
                if(union(edgeList[i].from, edgeList[i].to)){
                    mst_total += edgeList[i].weight;
                }
            }

            System.out.println(total - mst_total);
        }

    }

}
