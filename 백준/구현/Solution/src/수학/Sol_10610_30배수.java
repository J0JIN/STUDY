package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Sol_10610_30배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        Arrays.sort(input);

        if (check0(input) && check3(input)) {
            for (int i = input.length - 1; i >= 0; i--) {
                System.out.print(input[i]);
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static boolean check3(char[] input) {
        int total = 0;
        for (int i = 0; i < input.length; i++) {
            total += input[i] - '0';
        }

        if (total % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean check0(char[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '0') {
                return true;
            }
        }
        return false;
    }
}
