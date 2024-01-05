import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> plist = new ArrayList<>();
        List<Integer> mlist = new ArrayList<>();

        for(int tc = 1; tc <= N; tc++){
            int num = Integer.parseInt(br.readLine());
            if(num >0) {
                plist.add(num);
            }else{
                mlist.add(num);
            }
        }

        Collections.sort(plist);
        Collections.sort(mlist);

        int ans = 0;

        for(int i = plist.size()-1; i > 0; i=i-2){
            ans += plist.get(i)*plist.get(i-1);
            if(i == 2){
                ans += plist.get(0);
            }
        }

        

        System.out.println(ans);

    }

}
