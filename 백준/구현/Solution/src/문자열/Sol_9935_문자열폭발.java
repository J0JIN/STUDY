package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_9935_문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            sb.append(A.charAt(i));

            // 현재 StringBuilder의 길이가 B의 길이 이상이고, 마지막 부분이 B와 같다면 삭제
            if (sb.length() >= B.length() && sb.substring(sb.length() - B.length()).equals(B)) {
                sb.delete(sb.length() - B.length(), sb.length());
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
