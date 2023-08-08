package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Sol_1199_오일러 {

	static int N;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();

	static StringBuilder sb = new StringBuilder();

	public static class Node {
		int index;
		int vtx;

		public Node(int index, int vtx) {
			super();
			this.index = index;
			this.vtx = vtx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Node>());
		}

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int vtxTotal = 0;

			for (int j = 0; j < N; j++) {
				int vtx = Integer.parseInt(input[j]);
				if (vtx > 0) {
					list.get(i).add(new Node(j, vtx));
					vtxTotal += vtx;
				}
			}

			if (vtxTotal % 2 == 1) {
				System.out.println(-1);
				return;
			}
		}

		dfs(new Node(0, 0));
		System.out.println(sb.toString());
	}

	static void dfs(Node start) {// 끝까지 가야되는 경로를 찾는거니까 dps가 적합
		for (Node n : list.get(start.index)) {
			if (n.vtx > 0) {
				n.vtx--;
				list.get(n.index).get(start.index).vtx--;
				dfs(n);
			}
		}
		sb.append((start.index + 1) + " ");
	}
}
