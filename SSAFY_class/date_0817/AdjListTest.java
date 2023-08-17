package date_0817;

import java.util.Arrays;
import java.util.Scanner;

public class AdjListTest {

	static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "(Node vertex : " + vertex + ") -> " + next;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node adjList[] = new Node[V];
		
		for(int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			adjList[start] = new Node(end, adjList[start]);
			adjList[end] = new Node(start, adjList[end]);
		}
		
		int idx = 0;
		for(Node is : adjList) {
			System.out.print("List[" + idx + "] : ");
			System.out.println(is);
			idx++;
		}
		
	}
	
}
