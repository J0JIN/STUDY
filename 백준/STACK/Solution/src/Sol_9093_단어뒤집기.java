import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_9093_단어뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= tc; t++) {
            String input = bf.readLine();
            String[] words = input.split(" ");

            StringBuilder reversed = new StringBuilder();

            for (String word : words) {
                for (int i = word.length() - 1; i >= 0; i--) {
                    reversed.append(word.charAt(i));
                }
                reversed.append(" ");
            }

            System.out.println(reversed.toString());
        }
    }
}
