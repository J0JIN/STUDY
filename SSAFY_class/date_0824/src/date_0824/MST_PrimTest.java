package date_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_PrimTest {

	static int V, adjMatrix[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		adjMatrix = new int[V][V];

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

		// INF값 세팅
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		// 시작점 세팅
		minEdge[0] = 0;

		// MST 비용
		int result = 0;
		int min = 0, minVertex = 0;

		for (int c = 0; c < V; c++) {
			min = Integer.MAX_VALUE;
			minVertex = -1;

			// Step1. 미방문 정점 중 최소간선비용의 정점 선택
			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			// Step2. 트리 정점에 추가
			// + 방문 처리 = 트리에 추가
			visited[minVertex] = true;
			// + 비용 추가
			result += min;
			
			// Step3. 트리에 추가된 새로운 정점 기준으로 비트리 정점과 간선 비용 고려
			for(int i = 0; i < V; i++) {
				// 연결되어 있으며 && 아직 방문하지 않은 노드(= 트리에 없는 노드) && 현재 최소비용 > 선택 노드 연결 비용 
				if(adjMatrix[minVertex][i] != 0 && !visited[i] && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		// MST 누적비용 출력
		System.out.println(result);

	}

}
