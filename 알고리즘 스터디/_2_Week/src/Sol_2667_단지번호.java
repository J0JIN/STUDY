import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Sol_2667_단지번호 {

    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
        int cur_x;
        int cur_y;

        public Point() {
        }

        public Point(int x, int y) {
            this.cur_x = x;
            this.cur_y = y;
        }
    }

    public static int bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p); // 스타트 포인트 입력
        visit[p.cur_x][p.cur_y] = true;// 방문 check
        int count = 0;

        while (!queue.isEmpty()) {//큐가 빌떄까지
            Point tmp = queue.poll();// 큐에 하나 꺼내서
            count++;

            for (int i = 0; i < 4; i++) {// 네방향에 대하여
                int nx = tmp.cur_x + dx[i];
                int ny = tmp.cur_y + dy[i];

                if (1 <= nx && nx <= N && 1 <= ny && ny <= N){ //범위를 벗어나지 않고
                    if(visit[nx][ny] == false && map[nx][ny] == 1){// 방문하지 않았다면, 그리고 1이라면
                        Point np = new Point(nx, ny);
                        queue.offer(np);
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        return count;// poll 한 갯수 세기 = 노드의 갯수
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        int count = 0;
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];


        for (int j = 1; j <= N; j++) {
            String str = br.readLine();
            for (int i = 1; i <= N; i++) {
                map[i][j] = str.charAt(i - 1) - '0';
            }
        }

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {// 전체 맵에 대해
                if(visit[i][j] == false && map[i][j]==1){// bfs 탐색하여 트리의 갯수 세기
                    Point p = new Point(i,j);
                    list.add(bfs(p));// bfs는 노드의 개수를 return
                    count++;// bfs가 호출되면 Count++
                }
            }
        }

        System.out.println(count);

//      정렬 안했네?
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
