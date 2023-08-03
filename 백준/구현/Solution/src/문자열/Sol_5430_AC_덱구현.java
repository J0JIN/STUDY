package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Sol_5430_AC_덱구현 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String str1 = br.readLine();
            char[] command = str1.toCharArray();
            int N = Integer.parseInt(br.readLine());

            String str2 = br.readLine();
            str2 = str2.replace("]", "");
            str2 = str2.replace("[", "");
            String[] num = str2.split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                deque.addLast(Integer.parseInt(num[i]));
            }

            boolean reverse = false;
            boolean error = false;

            for (int i = 0; i < command.length; i++) {
                char cmd = command[i];

                switch (command[i]) {
                    case 'R':
                        reverse = !reverse;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            error = true;
                            break;
                        }
                        if (reverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                        break;
                }
            }

            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder("[");
                while (!deque.isEmpty()) {
                    if (reverse) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }

                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}
