package 못푼문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sol_2304_창고다각형 {

    public static class Jim implements Comparable<Jim> {
        int x;
        int y;

        public Jim(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Jim o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x < o.x) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Jim [x=" + x + ", y=" + y + "]";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Jim> jim = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            Jim j = new Jim(sc.nextInt(), sc.nextInt());
            jim.add(j);
        }

        Collections.sort(jim);

        Jim max = new Jim(0, 0);
        for (int i = 0; i < N; i++) {
            if (jim.get(i).y > max.y) {
                max.y = jim.get(i).y;
                max.x = jim.get(i).x;
            }
        }

        int cur_y = 0;
        int cur_x = 0;
        int total = 0;
        for (int i = 0; jim.get(i).y == max.y; i++) {
            if (jim.get(i).y >= cur_y) {
                cur_y = jim.get(i).y;

            } else {
                cur_x += jim.get(i).x;
            }
            total += cur_x * cur_y;
        }

        System.out.println(total);
    }
}
//
//		int sum = 0;
//		int cur_y = 0;
//		for (int x = jim.get(0).x; x < max.x; x++) {
//			if(jim.get(x) != null) {
//				if(jim.get(x).y >= cur_y) {
//					cur_y = jim.get(x).y;
//				}
//			}
//			sum += cur_y;
//		}
//
//		cur_y = 0;
//		for (int x = jim.get(jim.size()-1).x; x>max.x; x--) {
//
//			if(jim.get(x) != null) {
//				if(jim.get(x).y >= cur_y) {
//					cur_y = jim.get(x).y;
//				}
//			}
//			sum += cur_y;
//		}
//
//		System.out.println(sum);
//
//    }
//
//}
