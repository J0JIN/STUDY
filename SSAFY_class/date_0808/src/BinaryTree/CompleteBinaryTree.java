package BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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

		while (!q.isEmpty()) {// 탐색 대상이 있다면
			int tmp = q.poll();// 대상을 큐에서 꺼내고
			// +--------------+
			// | 대상 노드 방문처리   |
			// +--------------+

			System.out.println(nodes[tmp]);
			// 현재 탐색 대상의 자식들을 큐에 넣기

			if (tmp * 2 <= lastIdx) {//왼쪽 자식이 있다면
				q.offer(tmp * 2);// 넣고
			}
			if (tmp * 2 + 1 <= lastIdx) {//오른쪽 자식이 있다면
				q.offer(tmp * 2 + 1);// 넣고
			}
			//위에 코드는 완전이진트리이기에 자식 판별을 저렇게 하는거임.
			
		}

	}

}
