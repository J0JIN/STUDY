import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_1339_단어수학_해쉬맵 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> weight = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int len = input.length();
            for (int j = 0; j < len; j++) {
                char c = input.charAt(j);
                int power = (int) Math.pow(10, len - j - 1);
                weight.put(c, weight.getOrDefault(c, 0) + power);
            }
        }

        ArrayList<Integer> values = new ArrayList<>(weight.values());
        values.sort(Collections.reverseOrder());

        int answer = 0, num = 9;
        for (int value : values) {
            answer += value * num--;
        }

        System.out.println(answer);
    }
}
