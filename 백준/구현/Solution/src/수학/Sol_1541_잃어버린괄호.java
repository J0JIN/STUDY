package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("-");

        int[] num = new int[input.length];

        for(int i = 0; i < input.length; i++){
            String[] nums = input[i].split("\\+");

            int total = 0;
            for(int j = 0; j<nums.length; j++){
                total += Integer.parseInt(nums[j]);
            }

            num[i] = total;
        }

        if(num.length == 1){
            System.out.println(num[0]);
        }else {
            int total = 0;
            for(int i = 1; i < num.length; i++){
                total += num[i];
            }

            System.out.println(num[0] - total);
        }

    }
}
