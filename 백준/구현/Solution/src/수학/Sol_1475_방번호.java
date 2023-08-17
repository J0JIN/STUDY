package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[10];

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            num[str.charAt(i) - '0']++;
        }

        int count = 0;
        while(!isEmpty(num)){

            if(num[6]== 0 && num[9] >=2){
                num[9] -= 2;
                for (int i = 0; i < num.length; i++) {
                    if(i == 9){
                        continue;
                    }
                    if (num[i] != 0) {
                        num[i]--;
                    }
                }
            } else if(num[9]== 0 && num[6] >=2){
                num[6] -= 2;
                for (int i = 0; i < num.length; i++) {
                    if(i == 6){
                        continue;
                    }
                    if (num[i] != 0) {
                        num[i]--;
                    }
                }
            } else {
                for (int i = 0; i < num.length; i++) {
                    if (num[i] != 0) {
                        num[i]--;
                    }
                }
            }
             count++;
        }

        System.out.println(count);
    }

    public static boolean isEmpty(int[] num) {
        for(int i = 0; i < num.length; i++){
            if(num[i] != 0){
                return false;
            }
        }
        return true;
    }
}
