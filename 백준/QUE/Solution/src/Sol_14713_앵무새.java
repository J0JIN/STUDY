import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sol_14713_앵무새 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        LinkedList<String>[] Q_parrot = new LinkedList[N];
        LinkedList<String> Q_listener = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Q_parrot[i] = new LinkedList<String>();
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] input = str.split(" ");
            for (int j = 0; j < input.length; j++) {
                Q_parrot[i].offer(input[j]);
            }
        }

        String str = br.readLine();
        String[] input = str.split(" ");
        for (int i = 0; i < input.length; i++) {
            Q_listener.offer(input[i]);
        }

        boolean possible = true;

        while (!Q_listener.isEmpty()) {
            String compare = Q_listener.poll();
            boolean found = false;

            for (int i = 0; i < N; i++) {
                if (compare.equals(Q_parrot[i].peek())) {
                    Q_parrot[i].poll();
                    found = true;
                }
            }

            if(found == false){
                possible = false;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!Q_parrot[i].isEmpty()) {
               possible = false;
               break;
            }
        }

        if(possible == true) {
            bw.write("Possible\n");
        }else{
            bw.write("Impossible\n");
        }

        br.close();
        bw.close();

    }
}
