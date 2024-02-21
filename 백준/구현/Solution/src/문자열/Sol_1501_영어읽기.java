package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sol_1501_영어읽기 {

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> dict = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            String finalKey = createKeyFromWord(input);
            dict.put(finalKey, dict.getOrDefault(finalKey, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int total = 1;

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                String finalKey = createKeyFromWord(word);
                total *= dict.getOrDefault(finalKey, 0);

                if (total == 0) break;
            }

            System.out.println(total);
        }
    }

    private static String createKeyFromWord(String word) {
        if (word.length() <= 2) return word;

        String key = word.charAt(0) + "" + word.charAt(word.length() - 1);
        int[] alphabet = new int[26];
        for(int i = 1; i < word.length() - 1; i++){
            alphabet[word.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder(key);
        for(int count : alphabet){
            sb.append("#").append(count);
        }

        return sb.toString();
    }
}