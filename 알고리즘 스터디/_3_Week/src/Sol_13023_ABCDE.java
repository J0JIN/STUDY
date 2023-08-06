import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_13023_ABCDE {
    // 이거 2차원 배열로 삽질해서 틀린거구만..
    // 어차피 WorstCase(전부다 연결 된 경우)는 N^2이라 상관 없을거라 생각했는데
    // 아닌가..

    static class Node {
        int n;
        int depth;

        public Node(int n, int depth) {
            this.n = n;
            this.depth = depth;
        }
    }

    static int ans = 0;
    static int N, M;
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }// 2차월 리스트 생성

        for (int t = 0; t < M; t++) {
            int Node1 = sc.nextInt();
            int Node2 = sc.nextInt();
            list.get(Node1).add(Node2);
            list.get(Node2).add(Node1);
        }// 양방향 링크로 리스트에 IN

        boolean isfind = false;
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (ans == 1) {
                break;
            }
        }

        System.out.println(ans);
    }

    static void dfs(int start, int depth) {
        if (depth >= 4) {
            ans = 1;
            return;
        }
        visit[start] = true; // start랑 i랑 헷갈리지 말자..
        for (int nLink : list.get(start)) {
            if (!visit[nLink]) {
                visit[nLink] = true;
                dfs(nLink, depth + 1);
            }
        }
        visit[start] = false;
    }
}
