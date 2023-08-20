package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_14510_나무높이 {
    static int count_2, count_1, count_0, count_fixed_1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            ArrayList<Integer> arr = new ArrayList<>();

            int size = Integer.parseInt(br.readLine());
            int day = 0;

            //나무크기 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);

            //자라야되는 키로 변경
            for (int i = 0; i < size; i++) {
                arr.set(i, Math.abs(arr.get(i) - arr.get(size - 1)));
            }

            //0인 값 제거
            for (int i = size - 1; i >= 0; i--) {
                if (arr.get(i) == 0) {
                    arr.remove(i);
                }
            }

            count_2 = 0;
            count_1 = 0;
            count_0 = 0;
            count_fixed_1 = 0;

            for (int num : arr) {
                if (num == 1) {
                    count_fixed_1++;
                } else {
                    if (num % 3 == 2) {
                        count_2++;
                        day += 2 * (num / 3);
                    }
                    if (num % 3 == 1) {
                        count_1++;
                        day += 2 * (num / 3);
                    }
                    if (num % 3 == 0) {
                        day += 2 * (num / 3);
                    }
                }
            }

            balance();

            while (!(count_1 + count_fixed_1 == 0 || count_2 == 0)){
                count_2--;

                if (count_fixed_1 > 0) {
                    count_fixed_1--;
                } else {
                    count_1--;
                }

                day += 2;
            }

            if (count_1 >= 1) {
                day += 2 * (count_1 - 1) + 1;
            }
            if (count_2 >= 1) {
                day += 2 * count_2;
            }

//            System.out.println(arr.toString());
//            System.out.println(count_1 + " " + count_2 + " " + day);
            System.out.println("#" + t + " " + day);
        }
    }

    private static void balance() {
        while (Math.abs(count_2 - (count_1 + count_fixed_1)) > 1) {
            if (count_1 < 2) {
                return;
            }
            if (count_2 > count_1 + count_fixed_1) {
                change2to1();
            } else {
                change1to2();
            }
        }
    }

    private static void change1to2() {
        if (count_fixed_1 >= 0) {
            count_fixed_1--;
        } else {
            count_1--;
        }
        if (count_fixed_1 >= 0) {
            count_fixed_1--;
        } else {
            count_1--;
        }
        count_2++;
    }

    private static void change2to1() {
        count_2--;
        count_1++;
        count_1++;
    }
}
