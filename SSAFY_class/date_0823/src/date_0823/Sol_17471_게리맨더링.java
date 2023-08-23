package date_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_17471_게리맨더링 {
	static int N;

	static class Node {
		int vertex, people;

		public Node(int vertex, int people) {
			super();
			this.vertex = vertex;
			this.people = people;
		}

	}

	static ArrayList<ArrayList<Node>> arr;
	static boolean[] visit;
	static Node[] node;

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		node = new Node[N + 1];
		visit = new boolean[N + 1];

		arr = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			arr.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			node[i] = new Node(i, Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int edge = Integer.parseInt(st.nextToken());
			for (int j = 0; j < edge; j++) {
				arr.get(i).add(node[Integer.parseInt(st.nextToken())]);
			}
		}

		perm(1);
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}

	private static void perm(int idx) {
		if (idx > N) {
			int a_root = 0;
			int b_root = 0;

			for (int i = 1; i < N + 1; i++) {
				if (visit[i] == false) {
					a_root = i;
				}
				if (visit[i] == true) {
					b_root = i;
				}
			}

			boolean[] visitAnother = new boolean[N + 1];
			for (int i = 1; i < N + 1; i++) {
				visitAnother[i] = !visit[i];
			}

			if (a_root != 0 && b_root != 0) {
				int a = bfsAnother(a_root, visit);
				int b = bfsAnother(b_root, visitAnother);

				if (a != -1 && b != -1) {
					ans = Math.min(ans, Math.abs(a - b));
				}
			}
			return;
		}

		visit[idx] = true;
		perm(idx + 1);
		visit[idx] = false;
		perm(idx + 1);

	}

	private static int bfsAnother(int i, boolean[] visit) {
		boolean[] visitCopy = new boolean[N + 1];

		for (int v = 0; v < visit.length; v++) {
			visitCopy[v] = visit[v];
		}

		visitCopy[i] = true;

		Queue<Node> q = new ArrayDeque<>();
		q.add(node[i]);

		int total = node[i].people;

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			int vertex = tmp.vertex;

			for (Node next : arr.get(vertex)) {
				if (!visitCopy[next.vertex]) {
					q.add(next);
					visitCopy[next.vertex] = true;
					total += node[next.vertex].people;
				}
			}
		}

		if (!checkTrue(visitCopy)) {
			return -1;
		}
		return total;
	}

	private static boolean checkTrue(boolean[] visit) {
		for (int i = 1; i <= N; i++) {
			if (visit[i] == false) {
				return false;
			}
		}
		return true;
	}
}
