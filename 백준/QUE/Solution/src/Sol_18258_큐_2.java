import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sol_18258_큐_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int input = Integer.parseInt(st.nextToken());
                    queue.offer(input);
                    last = input;
                    break;

                case "pop":
                    if (!queue.isEmpty()) {
                        bw.write(queue.poll() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;

                case "size":
                    bw.write(queue.size() + "\n");
                    break;

                case "empty":
                    if (!queue.isEmpty()) {
                        bw.write("0\n");
                    } else {
                        bw.write("1\n");
                    }
                    break;

                case "front":
                    if (!queue.isEmpty()) {
                        bw.write(queue.peek() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;

                case "back":
                    if (!queue.isEmpty()) {
                        bw.write(last + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;

            }

        }

        bf.close();
        bw.close();
    }
}
