package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Sol_1199_오일러회로 {
    // 노드 방문인 줄 알았는데 간선이네..
    // 테케좀 잘 보자 진짜;;
    // 노드 정보가 중요한게 아니라 간선 정보가 중요하니까 배열 쓰는게 좋을 듯 싶다.

    static int N;
    static int[][] map;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int j = 0; j < N; j++) {
            String[] input = br.readLine().split(" ");
            int vtx = 0;

//            if (input.length % 2 == 1) { // 종료조건(각 지점에 짝수개의 간선만 있어야함)
//                System.out.println(-1);
//                return;
//            }// 이거 사이즈가 무조건 N이 나오는구만

//            간선이 여러개로 주어질 수 있으니까 이 부분도 수정해야지

            for (int i = 0; i < N; i++) {
                map[i][j] = Integer.parseInt(input[i]);
                vtx += map[i][j];
            }

            if (vtx % 2 == 1) {
                System.out.println(-1);
                return;
            }
        }// 2차원 배열에 갑 저장

        dfs(0);
        System.out.println(sb.toString());
    }

//    접행렬의 값은 두 정점 사이의 간선 개수를 의미하며, 0보다 크거나 같고, 10보다 작거나 같은 정수이다.
//    조건 뭔데..

    static void dfs(int start) {// 끝까지 가야되는 경로를 찾는거니까 dps가 적합
        for (int i = 0; i < N; i++) {
            if (map[start][i] > 0) {
                map[start][i]--;
                map[i][start]--;
                dfs(i);
            }
        }
        sb.append((start + 1) + " ");
    }
}


//    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//    static boolean visit[];
//    static int[] ans;
//    static int N;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            list.add(new ArrayList<>());
//        }// 2차원 리스트 생성
//
//        for (int i = 0; i < N; i++) {
//            String[] input = br.readLine().split(" ");
//            if (input.length % 2 == 1) { // 종료조건(각 지점에 짝수개의 간선만 있어야함)
//                System.out.println(-1);
//                return;
//            }
//
//            int j = Integer.parseInt(input[i]);
//            list.get(i).add(j);
//        }// 2차원 리스트에 갑 저장
//
//        visit = new boolean[N];
//
//        ans = new int[]
//        dps(1, 1, 0);
//
//    }
//
//    public static void dps(int start, int next, int idx) {
//
//        if (idx == N) {
//            System.out.println("탐색완료");
//            return;
//        }
//
//        for (int nLink : list.get(next)) {
//            if (!visit[nLink]) {
//                ans.add(nLink);
//                dps(start, nLink, idx + 1);
//
//                visit[nLink] = false;
//                ans.remove(nLink);
//            }
//        }
//
//    }
//
//}
