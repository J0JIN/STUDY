import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_11724_연결요소개수 {
    static int N;
    static int M;
    static int map[][];
    static boolean visit[];
    static int count;

    public static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        visit[i] = true;
        queue.offer(i);

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for (int j = 1; j <= N; j++) {
                if(map[tmp][j] == 1 && visit[j] == false){
                    queue.offer(j);
                    visit[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            map[u][v] = map[v][u] = 1; // 간선 표현
        }

        for(int i = 1; i <= N; i++){// 전체 노드에 대하여
            if(visit[i]==false){// 탐색 안한 노드 발견 시
                bfs(i);// 노드 트리 탐색 후 발견되는 노드를 TRUE로 세팅
                count++;// 트리 1개 추가
            }
        }

        System.out.println(count);

    }
}
