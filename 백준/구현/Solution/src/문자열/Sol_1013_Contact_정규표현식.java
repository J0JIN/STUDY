package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1013_Contact_정규표현식 {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            System.out.println(check(input) ? "YES" : "NO");
        }
    }

    private static boolean check(String input) {
        // 정규표현식을 사용하여 검사
        return input.matches("(100+1+|01)+");
    }
}