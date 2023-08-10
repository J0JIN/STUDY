
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree<T> {
	private Object[] nodes;
	private int lastIdx;
	private final int SIZE;

	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new Object[size + 1];
	}

	public boolean isEmpty() {
		return lastIdx == 0;
	}

	public boolean isFull() {
		return lastIdx == SIZE;
	}

	public boolean add(T data) {
		if (isFull()) {
			return false;
		}
		nodes[++lastIdx] = data;
		return true;

	}

	public void bfs(int root) {
		if (isEmpty()) {
			return;
		}

		// 탐색 순서를 관리할 대기열 생성
		Queue<Integer> q = new ArrayDeque<>();
		// 탐색 시작 대상부터 큐에 넣기
		q.offer(root);

		int breadth = 0;
		while (!q.isEmpty()) {// 탐색 대상이 있다면
			int size = q.size();
			// +--------------+
			// | 대상 노드 방문처리 |
			// +--------------+
			while (--size >= 0) {
				int tmp = q.poll();// 대상을 큐에서 꺼내고
				System.out.print(nodes[tmp] + "\t");
				// 현재 탐색 대상의 자식들을 큐에 넣기

				if (tmp * 2 <= lastIdx) {// 왼쪽 자식이 있다면
					q.offer(tmp * 2);// 넣고
				}
				if (tmp * 2 + 1 <= lastIdx) {// 오른쪽 자식이 있다면
					q.offer(tmp * 2 + 1);// 넣고
				}
				// 위에 코드는 완전이진트리이기에 자식 판별을 저렇게 하는거임.
			}
			System.out.println();
			System.out.println(breadth);
			breadth++;

		}

	}

	public void dfs() {
		if (isEmpty()) {
			return;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		
		while (!stack.isEmpty()) {// 탐색 대상이 있다면
			// +--------------+
			// | 대상 노드 방문처리 |
			// +--------------+

			int tmp = stack.pop();// 대상을 큐에서 꺼내고
			System.out.print(nodes[tmp] + "-");

			if (tmp * 2 + 1 <= lastIdx) {// 오른쪽 자식이 있다면
				stack.push(tmp * 2 + 1);// 넣고
			}
			if (tmp * 2 <= lastIdx) {// 왼쪽 자식이 있다면
				stack.push(tmp * 2);;// 넣고
			}

		}

	}

	public void dfsByMiddleOrder(int cur) {

		if (cur * 2 <= lastIdx) {// 왼쪽 자식이 있다면
			dfsByPreOrder(cur * 2);
		}
		System.out.print(nodes[cur] +"-");
		
		if (cur * 2 + 1 <= lastIdx) {// 오른쪽 자식이 있다면
			dfsByPreOrder(cur * 2 + 1);
		}
	}
	
	public void dfsByPreOrder(int cur) {
		System.out.print(nodes[cur] +"-");

		if (cur * 2 <= lastIdx) {// 왼쪽 자식이 있다면
			dfsByPreOrder(cur * 2);
		}
		if (cur * 2 + 1 <= lastIdx) {// 오른쪽 자식이 있다면
			dfsByPreOrder(cur * 2 + 1);
		}
	}
	
	public void dfsByPostOrder(int cur) {

		if (cur * 2 <= lastIdx) {// 왼쪽 자식이 있다면
			dfsByPreOrder(cur * 2);
		}
		if (cur * 2 + 1 <= lastIdx) {// 오른쪽 자식이 있다면
			dfsByPreOrder(cur * 2 + 1);
		}
		
		System.out.print(nodes[cur] +"-");
		
	}
	
	public void bfs2() {
		if (isEmpty()) {
			return;
		}

		// 탐색 순서를 관리할 대기열 생성
		Queue<int[]> q = new ArrayDeque<>();
		// 탐색 시작 대상부터 큐에 넣기
		q.offer(new int[] { 1, 0 });

		while (!q.isEmpty()) {// 탐색 대상이 있다면
			// +--------------+
			// | 대상 노드 방문처리 |
			// +--------------+

			int[] tmp = q.poll();// 대상을 큐에서 꺼내고
			int current = tmp[0];
			System.out.print(nodes[current] + "//" + tmp[1]);
			// 현재 탐색 대상의 자식들을 큐에 넣기

			if (current * 2 <= lastIdx) {// 왼쪽 자식이 있다면
				q.offer(new int[] { current * 2, tmp[1] + 1 });// 넣고
			}
			if (current * 2 + 1 <= lastIdx) {// 오른쪽 자식이 있다면
				q.offer(new int[] { current * 2 + 1, tmp[1] + 1 });// 넣고
			}

			System.out.println();
		}

	}

}
