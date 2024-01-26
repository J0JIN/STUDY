package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_8983_사냥꾼 {

    private static int M, N, L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> hunter = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            hunter.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(hunter);

        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y - L <= 0) {
                int upper = x - y + L;
                int under = x + y - L;

                if (under < 0) {
                    under = 0;
                }
                animals.add(new Animal(under, upper));
            }
        }
        Collections.sort(animals);


        int ans = 0;
        for(int i = 0; i < hunter.size();i++){
            hunter.get(i)
        }
    }

    private static class Animal implements Comparable<Animal> {
        int under;
        int upper;

        public Animal(int under, int upper) {
            this.under = under;
            this.upper = upper;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "under=" + under +
                    ", upper=" + upper +
                    '}';
        }

        @Override
        public int compareTo(Animal o) {
            return this.under - o.under;
        }
    }

}
