import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1011_센타우리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            int dist = y-x;

            int count = ((int) Math.sqrt(dist) * 2) - 1;
            int max = (int) Math.sqrt(dist);

            if(max == Math.sqrt(dist)){
                sb.append(count);
                sb.append("\n");
            } else if (dist <= max*(max+1)) {
                sb.append(count+1);
                sb.append("\n");
            }else{
                sb.append(count+2);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
