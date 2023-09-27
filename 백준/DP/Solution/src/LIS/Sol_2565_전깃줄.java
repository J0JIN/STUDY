package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sol_2565_전깃줄 {

    static ArrayList<ArrayList<Line>> list;
    static int[] cross;
    static int N;

    public static class Line {
        int start, end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        cross = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new ArrayList<>());
            list.get(i).add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cross(list.get(i).get(0), list.get(j).get(0))) {
                    list.get(i).add(list.get(j).get(0));
                    cross[i]++;
                }
            }
        }

        int count = 0;

        while (true) {
            if(isEmpty(cross)){
                break;
            }
            int idx = findMaxIdx(cross);
            for (int i = 1; i < list.get(idx).size(); i++) {
                for (int j = 0; j < N; j++) {
                    if(list.get(j).contains(list.get(idx).get(i))) {
                        list.get(j).remove(list.get(idx).get(i));
                        cross[j]--;
                    }
                }
            }
            cross[idx] = 0;
            count++;
        }

        System.out.println(count);
    }

    public static boolean cross(Line l1, Line l2) {
        if (l1.start > l2.start && l1.end < l2.end) {
            return true;
        } else if (l1.start < l2.start && l1.end > l2.end) {
            return true;
        } else {
            return false;
        }
    }

    public static int findMaxIdx(int[] arr) {
        int idx = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    public static boolean isEmpty(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return true;
            }
        }
        return false;
    }
}
