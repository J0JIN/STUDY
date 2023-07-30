package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_2606_바이러스 {

    static int map[][];// 링크 표현
    static boolean visit[];// 방문 표현
    static int n, m;// PC 갯수, 링크 갯수
    static int count = 0;// 방문 갯수

    public static int bfs(int i) {
        Queue<Integer> q = new LinkedList<>();// PC BFS 탐색을 위한 Queue

        q.offer(i);//입력된 i node를 Queue에 저장
        visit[i] = true;// i node는 방문 완료

        while (!q.isEmpty()) {// Stack이 빌때까지 = 최초 입력된 i 노드가 poll 될때까지

            int tmp = q.poll();// 하나 뽑아서,

            for (int k = 1; k <= n; k++) {// 나머지 피씨들에 대하여
                if (map[tmp][k] == 1 && visit[k] == false) {// 연결이 되어있다 AND 방문이 아직 안됬다.
                    q.offer(k);// 스택에 저장
                    visit[k] = true;// 방문 완료
                    count++;// 방문 완료된 것에대해 ++
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int start = 1;

        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = map[b][a] = 1;// 입력받은 a,b 에 대해 양방향 연결
        }

        System.out.println(bfs(start));
    }
}
