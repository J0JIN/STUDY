import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_7662_이중우선순위큐_못품 {

    private static PriorityQueue<Integer> minQ;
    private static PriorityQueue<Integer> maxQ;
    private static HashMap<Integer, Integer> deleteItem;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int T = Integer.parseInt(br.readLine());

            init();

            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (cmd) {
                    case "I":
                        insert(num);
                        break;
                    case "D":
                        if (deleteItem.size() == 0) continue;

                        if (num == 1) {
                            delete(maxQ);
                        } else {
                            delete(minQ);
                        }
                        break;
                }

            }

            if (deleteItem.size() == 0) {
                sb.append("EMPTY\n");
            } else {
                int res = delete(maxQ);
                sb.append(res + " ");

                if (deleteItem.size() > 0) {
                    res = delete(minQ);
                }
                sb.append(res + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void init() {
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
        deleteItem = new HashMap<>();
    }

    public static void insert(int number) {
        minQ.add(number);
        maxQ.add(number);
        deleteItem.put(number, deleteItem.getOrDefault(number, 0) + 1);
    }

    static int delete(Queue<Integer> q) {
        int res = 0;
        while (true) {
            res = q.poll();
            int cnt = deleteItem.getOrDefault(res, 0);

            if (cnt == 0) {
                continue;
            } else if (cnt == 1) {
                deleteItem.remove(res);
            } else {
                deleteItem.put(res, cnt - 1);
            }
            break;
        }
        return res;
    }

}
