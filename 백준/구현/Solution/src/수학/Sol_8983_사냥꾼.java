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

            if (y <= L) {
                int upper = x + (L - y);
                int under = x - (L - y);
                animals.add(new Animal(under, upper));
            }
        }
        Collections.sort(animals);

        int ans = 0;
        for (Animal animal : animals) {
            if (isCatchable(hunter, animal)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isCatchable(List<Integer> hunter, Animal animal) {
        int left = 0;
        int right = hunter.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (hunter.get(mid) >= animal.under && hunter.get(mid) <= animal.upper) {
                return true;
            } else if (hunter.get(mid) < animal.under) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private static class Animal implements Comparable<Animal> {
        int under;
        int upper;

        public Animal(int under, int upper) {
            this.under = under;
            this.upper = upper;
        }

        @Override
        public int compareTo(Animal o) {
            return this.under - o.under;
        }
    }
}
