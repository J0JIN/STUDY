import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sol_1744_수묶기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                plus.add(num);
            }else{
                minus.add(num);
            }
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int total = 0;
        int idx = 0;
        while(idx < minus.size()){
            if(idx+1 < minus.size() && minus.get(idx) * minus.get(idx+1) > minus.get(idx)){
                total += minus.get(idx) * minus.get(idx+1);
                idx += 2;
            }else{
                total += minus.get(idx);
                idx++;
            }
        }


        idx = 0;
        while(idx < plus.size()){
            if(idx+1 < plus.size() && plus.get(idx) * plus.get(idx+1) > plus.get(idx)){
                total += plus.get(idx) * plus.get(idx+1);
                idx += 2;
            }else{
                total += plus.get(idx);
                idx++;
            }
        }

        System.out.println(total);

    }
}
