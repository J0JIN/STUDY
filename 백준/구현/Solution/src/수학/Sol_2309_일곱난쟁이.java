package 수학;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sol_2309_일곱난쟁이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> height = new ArrayList<>(9);

        int total = 0;
        for (int i = 0; i < 9; i++) {
            int h = sc.nextInt();
            total += h;
            height.add(h);
        }

        out:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - height.get(i) - height.get(j) == 100) {
                    height.remove(i);
                    height.remove(j-1);
                    break out;
                }
            }
        }

        Collections.sort(height);

        for (int i = 0; i< height.size(); i++){
            System.out.println(height.get(i));
        }

    }
}