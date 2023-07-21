import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int lastElement = -1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.offer(x);
                    lastElement = x; // 마지막으로 추가된 값 갱신
                    break;
                case "pop":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.poll() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "front":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(queue.peek() + "\n");
                    break;
                case "back":
                    if (queue.isEmpty())
                        bw.write("-1\n");
                    else
                        bw.write(lastElement + "\n");
                    break;
            }
        }

        br.close();
        bw.close();
    }
}