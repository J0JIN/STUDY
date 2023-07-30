import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_9205_맥주중독 {

    public static class node {
        int x;
        int y;
        boolean visit;

        public node() {
        }

        public node(int x, int y) {
            this.x = x;
            this.y = y;
            this.visit = false;
        }

        @Override
        public String toString() {
            return "node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static node[] store;
    public static Queue<node> queue;

    public static void bfs(node start) {
        queue.add(start);
        start.visit = true;

        while (!queue.isEmpty()) {
            node tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;

            for (int i = 0; i < store.length; i++) {
                int nx = store[i].x;
                int ny = store[i].y;
                int xDist = Math.abs(x - nx);
                int yDist = Math.abs(y - ny);

                if (store[i].visit == false && xDist+yDist <= 1000){ // 아직 미방문인 노드가 1000 거리 이내이면
                    if(i == store.length - 1) {// 근데 이게 마지막 노드면 끝내고
                        System.out.println("happy");
                        queue.clear(); // 이거 꼭 생각해보자..
                        return;
                    }
                    //아니면 큐에 넣어서 bfs 진행
                    queue.add(store[i]);
                    store[i].visit =true;
                }

            }
        }// 다 했는데도 못찾았음 슬픔

        System.out.println("sad");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<node>();

        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {

            int n = sc.nextInt();

            store = new node[n+1];

            node start = new node(sc.nextInt(), sc.nextInt()); // 시작점

            for (int i = 0; i < n; i++) {
                store[i] = new node(sc.nextInt(), sc.nextInt());// 편의점
            }
            node end = new node(sc.nextInt(), sc.nextInt());// 종착점
            store[n] = end; // 종착점은 맨 마지막에 넣어준다

            bfs(start);
            reset();
            //실수 1. 또 visit 초기화 안해줬네;
            //되도록이면 main 함수 내에서 선언하여서 알아서 초기화 시키면 좋긴한데
            //클래스 사용하면 그렇게는 힘드니까 항상 신경쓰자..
        }
    }
    public static void reset() {
        for (node n : store) {
            n.visit = false;
        }
    }
}
