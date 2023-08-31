package date_0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.InputMap;

public class Sol_6588_골드바흐의추측 {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean prime[] = new boolean[1000001];
        prime[0] = prime[1] = true; // 소수는 false
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }

        }

        int n = Integer.parseInt(br.readLine());

        while (n != 0) {
            boolean isProve = false;
            for (int i = 2; i <= n / 2; i++) {
                if (!prime[i] && !prime[n - i]) {
                    sb.append(n + " = " + i + " + " + (n - i));
    				sb.append("\n");
                    isProve = true;
                    break;
                }
            }

            if (!isProve) {
				sb.append("Goldbach's conjecture is wrong");
				sb.append("\n");
            }

            n = Integer.parseInt(br.readLine());

        }
        
        System.out.println(sb.toString());

    }
}

