import java.util.Scanner;

public class Sol_3985_롤케이크 {

    public static class People {
        int low;
        int high;
        int eat;

        public People(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public String toString() {
            return "People{" +
                    "low=" + low +
                    ", high=" + high +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();

        boolean[] cake = new boolean[L+1];

        int M = sc.nextInt();
        int max = 0;
        int max_who = 0;

        People[] people = new People[M + 1];
        for (int i = 1; i <= M; i++) {
            People p = new People(sc.nextInt(), sc.nextInt());
            people[i] = p;
            if (p.high - p.low > max) {
                max = p.high - p.low;
                max_who = i;
            }
        }

        for (int i = 1; i <= M; i++) {
            int count = 0;
            for (int j = people[i].low; j <= people[i].high; j++) {
                if (cake[j] == false) {
                    cake[j] = true;
                    count++;
                }
            }
            people[i].eat = count;
        }

        int ans = 0;
        int ans_who = 0;
        for (int i = 1; i <= M; i++) {
           if(people[i].eat > ans){
               ans = people[i].eat;
               ans_who = i;
           }
        }

        System.out.println(max_who);
        System.out.println(ans_who);
    }
}
