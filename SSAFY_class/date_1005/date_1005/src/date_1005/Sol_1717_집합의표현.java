package date_1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1717_집합의표현 {

	static int N, M;
	static int[] root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		make(N);

		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case 0:
				union(a,b);
				break;
			case 1:
				String ans = check(a,b) ? "YES" : "NO";
				sb.append(ans).append("\n");
				break;
			}
			
		}
		
		System.out.println(sb.toString());
	}

	private static boolean check(int a, int b) {
		if(find(a) == find(b)) {
			return true;
		}else {
			return false;
		}
	}

	private static void union(int a, int b) {
		if(find(a) != find(b)) {
			root[b] = find(a); 
		}
	}

	private static int find(int a) {
		if(a == root[a]) {
			return a;
		}
		return root[a] = find(root[a]);
	}

	private static void make(int n) {
		root = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			root[i] = i;
		}
	}
}
