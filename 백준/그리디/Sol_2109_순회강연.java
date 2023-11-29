import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol_2109_순회강연 {

    private static class lecture implements Comparable<lecture>{
        int time;
        int money;
        public lecture(int time, int money) {
            this.time = time;
            this.money = money;
        }

        @Override
        public String toString() {
            return "lecture{" +
                    "time=" + time +
                    ", money=" + money +
                    '}';
        }

        @Override
        public int compareTo(lecture o) {
            return o.money - this.money;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<lecture> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10_001];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.add(new lecture(d,p));
        }

        int total = 0;

        while(!pq.isEmpty()){
            lecture l = pq.poll();
            int time = l.time;
            int money = l.money;

            while(time > 0){
                if(!arr[time]){
                    arr[time] = true;
                    total += money;
                    break;
                }else {
                    time--;
                }
            }
        }

        System.out.println(total);

    }
}
