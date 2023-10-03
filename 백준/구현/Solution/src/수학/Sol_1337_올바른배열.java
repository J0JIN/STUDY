package 수학;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class Sol_1337_올바른배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = Integer.MAX_VALUE;

        int[] arr= new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = arr[i]; j < arr[i]+5; j++){
                for(int k = 0; k < N; k++){
                    if(arr[k] == j){
                        cnt++;
                    }
                }
            }
            ans = Math.min(ans, 5-cnt);
        }

        System.out.println(ans);
    }


}
