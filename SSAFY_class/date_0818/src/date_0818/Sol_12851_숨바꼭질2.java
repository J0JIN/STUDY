package date_0818;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Sol_12851_숨바꼭질2 {
	static int N, K;
	static int[] dist;
	static int[] ways;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		dist = new int[100_001];
		ways = new int[100_001];

		bfs(N);

		if (N == K) {
			System.out.println(0);
			System.out.println(1);
		} else {
			System.out.println(dist[K]);
			System.out.println(ways[K]);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		dist[start] = 0;
		ways[start] = 1;

		while (!q.isEmpty()) {
			int current = q.poll();

			int next1 = current - 1;
			int next2 = current + 1;
			int next3 = current * 2;

			int[] nextPositions = { next1, next2, next3 };

			for (int nextPos : nextPositions) {
				if (nextPos >= 0 && nextPos <= 100_000) {
					if (dist[nextPos] == 0) {
						dist[nextPos] = dist[current] + 1;
						ways[nextPos] = ways[current];
						q.offer(nextPos);
					} else if (dist[nextPos] == dist[current] + 1) {
						ways[nextPos] += ways[current];
					}
				}
			}
		}
	}
}
