package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Sol_14226_이모티콘 {

    private static class Emoji {
        int clipboard;
        int monitor;
        int step;

        public Emoji(int clipboard, int monitor, int step) {
            this.clipboard = clipboard;
            this.monitor = monitor;
            this.step = step;
        }

        @Override
        public String toString() {
            return "Emoji{" +
                    "clipboard=" + clipboard +
                    ", monitor=" + monitor +
                    '}';
        }
    }

    private static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());

        boolean[][] visit = new boolean[1001][1001];
        Queue<Emoji> q = new ArrayDeque<>();

        q.offer(new Emoji(0, 1, 0));
        visit[1][0] = true; // 초기 상태 방문 체크

        while (!q.isEmpty()) {
            Emoji cur = q.poll();
            int clipboard = cur.clipboard;
            int monitor = cur.monitor;
            int step = cur.step;

            if (monitor == S) {
                System.out.println(step);
                break;
            }

            // case1 화면에 있는 이모지 복사
            if (monitor > 0 && clipboard != monitor && !visit[monitor][monitor]) {
                q.offer(new Emoji(monitor, monitor, step + 1));
                visit[monitor][monitor] = true;
            }

            // case2 화면에 붙여넣기
            if (clipboard != 0 && monitor + clipboard <= 1000 && !visit[monitor + clipboard][clipboard]) {
                q.offer(new Emoji(clipboard, monitor + clipboard, step + 1));
                visit[monitor + clipboard][clipboard] = true;
            }

            // case3 화면에 있는 이모티콘 하나 삭제
            if (monitor > 1 && !visit[monitor - 1][clipboard]) { // monitor가 0이 되지 않도록 변경
                q.offer(new Emoji(clipboard, monitor - 1, step + 1));
                visit[monitor - 1][clipboard] = true;
            }
        }
    }
}
