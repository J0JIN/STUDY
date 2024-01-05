import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_7662_이중우선순위큐_못품 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int T = Integer.parseInt(br.readLine());

            Queue<Integer> minQ = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            Queue<Integer> maxQ = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            Queue<Integer> store_minQ = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            Queue<Integer> store_maxQ = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            int I_count = 0;
            int D_count = 0;

            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (cmd) {
                    case "I":
                        minQ.offer(num);
                        maxQ.offer(num);
                        break;
                    case "D":

                        if (num == 1 && !maxQ.isEmpty()) {
                            minQ.remove(maxQ.poll());
                        }

                        if (num == -1 && !minQ.isEmpty()) {
                            maxQ.remove(minQ.poll());
                        }

//                        System.out.println(maxQ.toString());
//                        System.out.println(minQ.toString());
//                        System.out.println("---------------");

                        break;
                }
            }
            if (minQ.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxQ.poll() + " " + minQ.poll());
            }
        }

    }
}
