package date_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST_PrimQueueTest {

	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[V][V];

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방문정점 표시
		boolean[] visited = new boolean[V];
		// 자신과 트리의 정점들 간 최소 간선 비용
		int[] minEdge = new int[V];
		// ================================================
		PriorityQueue<Vertex> pQ = new PriorityQueue<>();
		// ================================================

		// INF값 세팅
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		// 시작점 세팅
		minEdge[0] = 0;
		// ================================================
		pQ.offer(new Vertex(0, minEdge[0]));
		// ================================================

		// MST 비용
		int result = 0;
		int min = 0, minVertex = 0, cnt = 0;

		while(!pQ.isEmpty()) {
			min = Integer.MAX_VALUE;
			minVertex = -1;

			// Step1. 미방문 정점 중 최소간선비용의 정점 선택
			// ================================================
			Vertex cur = pQ.poll();
			minVertex = cur.no;
			min = cur.weight;
			if (visited[minVertex])
				continue;

			// ================================================

			// Step2. 트리 정점에 추가
			// + 방문 처리 = 트리에 추가
			visited[minVertex] = true;
			// + 비용 추가
			result += min;
			if (++cnt == V)
				break;

			// Step3. 트리에 추가된 새로운 정점 기준으로 비트리 정점과 간선 비용 고려
			for (int i = 0; i < V; i++) {
				// 연결되어 있으며 && 아직 방문하지 않은 노드(= 트리에 없는 노드) && 현재 최소비용 > 선택 노드 연결 비용
				if (adjMatrix[minVertex][i] != 0 && !visited[i] && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
					// ================================================
					pQ.offer(new Vertex(i, minEdge[i]));
					// ================================================
				}
			}
		}
		// MST 누적비용 출력
		System.out.println(result);

	}

}
