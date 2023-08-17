package date_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1260_DFS_BFS_인접리스트 {

	static int N, M, V;
	static LinkedList<LinkedList<Integer>> adj;
	static StringBuilder sb;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		//------------------------------------------//
		adj = new LinkedList<>();
		for(int n = 0; n <= N; n++) {
			adj.add(new LinkedList<>());
		}
		//------------------------------------------//

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			//------------------------------------------//
			adj.get(v1).add(v2);
			adj.get(v2).add(v1);
			//------------------------------------------//
		}

		//------------------------------------------//
		for(int n = 0; n <= N; n++) {
			Collections.sort(adj.get(n));
		}
		//------------------------------------------//
		visit = new boolean[N + 1];
		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb.toString());

		visit = new boolean[N + 1];
		sb = new StringBuilder();
		bfs(V);
		System.out.println(sb.toString());

	}

	private static void dfs(int start) {
		visit[start] = true;
		sb.append(start + " ");

		//------------------------------------------//
		for (int n : adj.get(start)) {
			if (!visit[n]) {
				dfs(n);
			}
		}
		//------------------------------------------//
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		visit[start] = true;

		while (!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp +" ");
			
			//------------------------------------------//
			for (int n : adj.get(tmp)) {
				if (!visit[n]) {
					visit[n] = true;
					q.offer(n);
				}
			}
			//------------------------------------------//
		}

	}

}
