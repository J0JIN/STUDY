package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0;

        while (left < right) {
            int sum = solutions[left] + solutions[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                answer1 = solutions[left];
                answer2 = solutions[right];
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
