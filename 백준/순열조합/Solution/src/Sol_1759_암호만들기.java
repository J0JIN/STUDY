import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_1759_암호만들기 {

    static int L, C;
    static char[] input;
    static ArrayList<String> ans;
    static boolean visit[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[C];
        visit = new boolean[C];
        ans = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < input.length; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);

        comb(0, 0,0,0);

    }

    private static void comb(int idx, int cnt, int mo, int ja) {
        if (cnt == L) {
            if (mo >= 1 && ja >= 2) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < visit.length; i++){
                    if(visit[i] == true) {
                        sb.append(input[i]);
                    }
                }
                System.out.println(sb.toString());
            }
            return;
        }

        if (idx == visit.length) {
            return;
        }

        if (checkMouem(input[idx]) == true) {
            visit[idx] = true;
            comb(idx + 1, cnt + 1, mo + 1, ja);
        } else {
            visit[idx] = true;
            comb(idx + 1, cnt +1, mo, ja+1);
        }

        visit[idx] = false;
        comb(idx + 1, cnt, mo, ja);
    }

    private static boolean checkMouem(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
