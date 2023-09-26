package date_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sol_18352_특정거리도시찾기BFS {

	static int N, M, K, X;
	static ArrayList<ArrayList<Integer>> arr;
	
	static class Node{
		int from, to;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			
		}
		
	}
}
