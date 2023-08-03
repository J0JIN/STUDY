package 수학;

import java.util.Scanner;

public class Sol_2477_참외밭 {

////ㄱ   : 오1 하1 -> 전체 - 하 2, 왼 1
////┏    : 왼1 하1 -> 전체 - 하 2, 오 1
////┗    : 왼1 상1 -> 전체 - 상 2, 오 1
////┛    : 오1 상1 -> 전체 - 상 2, 왼 1
//
//   public static boolean isOne(int[] a) {
//       if (a[1] == 0) {
//           return true;
//       } else {
//           return false;
//       }
//   }
//
//   public static void main(String[] args) {
//       Scanner sc = new Scanner(System.in);
//
//       int price = sc.nextInt();
//
//       int[] up = {0, 0};
//       int[] down = {0, 0};
//       int[] right = {0, 0};
//       int[] left = {0, 0};
//
//       int start_way = 0;
//
//       for (int i = 0; i < 6; i++) {
//           int way = sc.nextInt();
//           if (i == 0) {
//               start_way = way;
//           }
//           switch (way) {
//               case 1:
//                   if (right[0] == 0) {
//                       right[0] = sc.nextInt();
//                   } else {
//                       right[1] = sc.nextInt();
//                   }
//                   break;
//               case 2:
//                   if (left[0] == 0) {
//                       left[0] = sc.nextInt();
//                   } else {
//                       left[1] = sc.nextInt();
//                   }
//                   break;
//               case 3:
//                   if (down[0] == 0) {
//                       down[0] = sc.nextInt();
//                   } else {
//                       down[1] = sc.nextInt();
//                   }
//                   break;
//               case 4:
//                   if (up[0] == 0) {
//                       up[0] = sc.nextInt();
//                   } else {
//                       up[1] = sc.nextInt();
//                   }
//                   break;
//           }
//       }
//
//       int total = 0;
//       int sub = 0;
//
//       if (isOne(up) == true && isOne(right) == true) {
//           total = up[0] * right[0];
//           if (start_way == 4) {
//               sub = down[1] * left[0];
//           } else {
//               sub = down[0] * left[1];
//           }
//           System.out.println("1");
//       }
//
//       if (isOne(down) == true && isOne(right) == true) {
//           total = down[0] * right[0];
//           if (start_way == 3) {
//               sub = up[1] * left[0];
//           } else {
//               sub = up[0] * left[1];
//           }
//           System.out.println("2");
//       }
//
//       if (isOne(up) == true && isOne(left) == true) {
//           total = up[0] * left[0];
//           if (start_way == 4) {
//               sub = down[1] * right[0];
//           } else {
//               sub = down[0] * right[1];
//           }
//           System.out.println("3");
//       }
//
//       if (isOne(down) == true && isOne(left) == true) {
//           total = down[0] * left[0];
//           if (start_way == 3) {
//               sub = up[1] * right[0];
//           } else {
//               sub = up[0] * right[1];
//           }
//           System.out.println("4");
//       }
//
//       System.out.println(price * (total - sub));
//
//
//   } -> 케이스별로 쪼개기에는 무리가 있다,,

//	순서는 아무리봐도 따지는게 아니다.. 전체를 어떻게 구할지
//	어차피 모든 길이가 주어지니 순서대로 다 곱한 넓이도 4분할 네모로 표현 가능
//	곱해보니 전체 X 3 - 표적사각형이 나오네.. 근데 이걸 짧은 시간에 생각 가능 할런지 ㅋㅋ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int price = sc.nextInt();

		int h_max = 0;
		int w_max = 0;

		int[] go = new int[6];
		for (int i = 0; i < 6; i++) {
			int way = sc.nextInt();
			int distance = sc.nextInt();
			if (way == 1 || way == 2) {
				if (w_max < distance) {
					w_max = distance;
				}
			}
			if (way == 3 || way == 4) {
				if (h_max < distance) {
					h_max = distance;
				}
			}
			go[i] = distance;
		}

		int total = h_max * w_max;
//		System.out.println(total);

		int total3_Sub = 0;
		for (int i = 0; i < 5; i++) {
			total3_Sub += go[i] * go[i + 1];
		}
		total3_Sub += go[0] * go[5];
//		System.out.println(total3_Sub);

		int total_Sub = price * (total3_Sub - 2 * total);
		System.out.println(total_Sub);
		
	}
}