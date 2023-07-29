import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.toUpperCase();

        int[] alphabet = new int[26];

        for(int i = 0; i <str.length(); i++){
            alphabet[str.charAt(i)-'A']++;
        }

        int max = -1;
        int max_a = 0;

        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i]>= max){
                max = alphabet[i];
                max_a = i;
            }
        }

        int count = 0;
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] == max){
                count++;
            }
        }

        int ans = 'A' + max_a;

        if(count > 1){
            System.out.println("?");
        }else {
            System.out.println((char)ans);
        }

    }
}
