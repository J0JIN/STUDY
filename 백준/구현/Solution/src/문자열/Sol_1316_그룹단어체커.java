package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int count = 0;

        for (int t = 0; t < tc; t++) {
            String str = br.readLine();
            if(check(str)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check(String str){
        boolean[] check = new boolean[26];
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);
            if (now != prev) {
                if(check[now - 'a'] == false){
                    check[now - 'a'] = true;
                    prev = now;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
