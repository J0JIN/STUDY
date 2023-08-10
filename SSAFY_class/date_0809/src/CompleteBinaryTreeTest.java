

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		
		int size = 9;
		
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
		
		for(int i = 0; i<size; i++) {
			tree.add((char)(65+i));
		}
		
//		tree.bfs(1); // 해당 노드의 자식들 출력
//		tree.bfs2(); // 모든 노드를 깊이별로 출력
		tree.dfsByPreOrder(1);
		System.out.println();
		tree.dfsByMiddleOrder(1);
		System.out.println();
		tree.dfsByPostOrder(1);
		System.out.println();		
		tree.dfs();
	}
}
