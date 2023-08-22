package date_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {

	static int parents[];
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		 
			parents = new int[N+1];
			
			for(int i = 0; i < N+1; i++) {
				parents[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch (cmd) {
				case 0:
					union(a,b);
					break;

				case 1:
					if(find(a) == find(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
					break;

				}
			}
//			sb.append("\n");
			System.out.println(sb.toString());
		}
	}

	private static boolean union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		
		if(a_root == b_root) {
			return true;
		}else{
			parents[b_root] = a_root;
			return false;
		}
		
	}

	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	
	
}
