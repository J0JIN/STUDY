package date_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_1753_최단경로 {

	static int V, E;
	static int start;
	static LinkedList<Edge>[] adjList;
	static int[] dist;

	static class Edge implements Comparable<Edge> {
		int to, weight;

		Edge(int t, int w) {
			to = t;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new LinkedList[V + 1];
		for(int v = 1; v<=V; v++) {
			adjList[v] = new LinkedList<>();
		}

		start = Integer.parseInt(br.readLine());

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new Edge(to, weight));
		}

		// BFS 느낌이라고 생각하면 이해가 쉽다
		dijkstra(start);
		
		StringBuilder sb =new StringBuilder();
		for(int v=1; v<=V; v++) {
			if(dist[v] == Integer.MAX_VALUE) {
				sb.append("INF");
			}else {
				sb.append(dist[v]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra(int start) {
		dist = new int[V + 1];

		boolean[] visit = new boolean[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int tmpVertex = tmp.to;

			if (!visit[tmpVertex]) {
				visit[tmpVertex] = true;

				for (Edge nextEdge : adjList[tmpVertex]) {
					if (dist[nextEdge.to] > tmp.weight + nextEdge.weight) {
						dist[nextEdge.to] = tmp.weight + nextEdge.weight;
						pq.add(new Edge(nextEdge.to, tmp.weight + nextEdge.weight));
					}
				}
			}
		}
	}

}
