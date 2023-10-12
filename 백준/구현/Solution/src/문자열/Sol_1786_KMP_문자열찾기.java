package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1786_KMP_문자열찾기 {

    static String T, P;
    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = br.readLine();
        P = br.readLine();

        kmp(P, P, 0);
        kmp(T, P, 1);

    }

    private static void kmp(String t, String p, int init) {
        int tsize = t.length();
        int psize = p.length();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        if (init == 0) {
            pi = new int[psize];

            int j = 0;
            for (int i = 1; i < tsize; i++) {
                while (t.charAt(i) != p.charAt(j) && j > 0) {
                    j = pi[j - 1];
                }

                if (t.charAt(i) == p.charAt(j)) {
                    pi[i] = ++j;
                }
            }
        }

        if(init == 1){
            int j = 0;
            for (int i = 0; i < tsize; i++) {
                while (t.charAt(i) != p.charAt(j) && j > 0) {
                    j = pi[j - 1];
                }

                if (t.charAt(i) == p.charAt(j)) {
                    if(j == psize - 1){
                        cnt++;
                        sb.append(i-j+1).append(" ");
                        j = pi[j];
                    }else{
                        j++;
                    }
                }
            }
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
    }
}
