package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Sol_1764_듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");

        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);

        HashSet<String> noSee = new HashSet<>();
        HashSet<String> noHear = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for(int i = 0; i< N; i++){
            noSee.add(br.readLine());
        }

        for(int i = 0; i< M; i++){
            noHear.add(br.readLine());
        }

        int count = 0;
        for(String name : noHear){
            if(noSee.contains(name)){
                count++;
                ans.add(name);
            }
        }

        System.out.println(count);
        Collections.sort(ans);

        for(String name : ans){
            System.out.println(name);
        }

    }
}
