import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol_5014_스타트링크 {

    static int F, S, G, U, D;

    public static class Stair {
        int height;
        int btn;

        public Stair(int height, int btn) {
            this.height = height;
            this.btn = btn;
        }
    }

    public static void bfs() {
        Queue<Stair> q = new LinkedList<>();
        boolean[] visit = new boolean[F + 1];
        q.offer(new Stair(S, 0));// 실수 3. 코드 수정하면서 여기를 1로 썼네 ㅋㅋ
        visit[S] = true;
        int btn = 0;

        if(S == G){ // 실수1. 시작 위치가 도착 위치인 경우 뺴먹었다.
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            Stair tmp = q.poll();
            int ND = tmp.height - D;
            int NU = tmp.height + U;
            
            if (tmp.height == G) {
                btn = tmp.btn;
                break;
            }

            if (NU <= F && visit[NU] == false) { // Next Up이 F보다 작으면
                q.offer(new Stair(NU, tmp.btn + 1));
                visit[NU] = true;
            }

            if (1 <= ND && visit[ND] == false) { // Next Down이 1보다 크면
                q.offer(new Stair(ND, tmp.btn + 1));
                visit[ND] = true;
            }

        }// 이렇게 해도 못찾으면
        if (btn != 0) {
            System.out.println(btn);
        } else {
            System.out.println("use the stairs");
        }
        // 실수2.
        // 최초에 count 이용해서 찾을려고 했는데 전체 탐색에서 버튼 누른 횟수가 되어버려서
        // count는.. 클래스안에 넣어서 최단 버튼 횟수를 찾아야 쓰겄네
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        bfs();
    }
}
