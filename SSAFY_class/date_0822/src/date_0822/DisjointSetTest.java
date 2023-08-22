package date_0822;

import java.util.Arrays;

public class DisjointSetTest {

	static int N;
	static int parents[];

	private static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
//		return find(parents[a]);
		return parents[a] = find(parents[a]); // path compression
	}
	
	private static boolean union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		
		if(a_root == b_root) {
			return false;
		}else {
			parents[b_root] = a_root;
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		N = 5;
		make();
		
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,2));
		System.out.println(Arrays.toString(parents));
	}
}
