package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1110_더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int end = Integer.parseInt(str);
        int count = 1;

        while(true){
            if(str.length() == 1){
                str = "0"+str;
            }

            int num = Integer.parseInt(str);

            int first = num/10;
            int second = num%10;

            int n_first = second;
            int n_second = (first+second)%10;

            int n_num = 10*n_first + n_second;

            if(n_num == end){
                break;
            }
            str = Integer.toString(n_num);
            count++;
        }

        System.out.println(count);
    }
}
