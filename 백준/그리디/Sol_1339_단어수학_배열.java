import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_1339_단어수학_배열 {

    private static int[] alphabet = new int[26]; // 알파벳 별 가중치 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] charInput = input.toCharArray();
            int length = charInput.length;

            for (int j = 0; j < length; j++) {
                alphabet[charInput[j] - 'A'] += Math.pow(10, (length - j - 1));
            }
        }

        Arrays.sort(alphabet);

        int total = 0;
        int number = 9;

        for (int i = 25; i >= 0; i--) {
            if (alphabet[i] == 0) break;
            total += alphabet[i] * number--;
        }

        System.out.println(total);
    }
}
