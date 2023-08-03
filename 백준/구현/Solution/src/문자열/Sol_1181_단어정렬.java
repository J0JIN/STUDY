package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sol_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        List<String>[] word = new ArrayList[51];

        for (int i = 0; i < 51; i++) {
            word[i] = new ArrayList<>();
        }

        for (int i = 0; i < tc; i++) {
            String str = br.readLine();
            word[str.length()].add(str);
        }

        for (int i = 1; i <= 50; i++) {
            if(!word[i].isEmpty()){
                Collections.sort(word[i]);
                for(int j = 0; j < word[i].size(); j++){
                    if(j >= 1){
                        if(!word[i].get(j).equals(word[i].get(j-1))){
                            System.out.println(word[i].get(j));
                        }
                    }else {
                        System.out.println(word[i].get(j));
                    }
                }
            }
        }

    }
}
