package date_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1111_IQ_Test {

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) { // 하나 주어진 경우는 전부 다 답이 될 수 있음
			String[] input = br.readLine().split(" ");
			System.out.println("A");
		}

		else if (N == 2) {// 한 점이 주어진 경우에는 둘이 같으면 답이 1개고, 둘이 다르면 답이 여러개임
			String[] input = br.readLine().split(" ");
			if (input[0].equals(input[1])) {// 같으면 1개
				System.out.println(input[0]);
			} else {// 다르면 여러개
				System.out.println("A");
			}
		}

		else if (N == 3) {// Point가 2개 주어진 경우에는 대입이 따로 필요 없이, 무조건 방정식이 나옴.
			// 다만 특수 case. 기울기가 무한 : divide 0으로 예외처리
			String[] input = br.readLine().split(" ");

			Point[] point = new Point[input.length - 1];

			for (int i = 0; i < input.length - 1; i++) { // 포인트 값 저장
				int x = Integer.parseInt(input[i]);
				int y = Integer.parseInt(input[i + 1]);
				point[i] = new Point(x, y);
			}

			double a = 0, b = 0;

			if (point[0].x - point[1].x != 0) { // 기울기, 절편 구하기
				a = (double) (point[0].y - point[1].y) / (double) (point[0].x - point[1].x);
				b = point[0].y - (a * point[0].x);

				if (a % 1 != 0) { // 정수가 아니면 B출력
					System.out.println("B");
					return;56
					 er234fd
				}
				if (b % 1 != 0) { // 정수가 아니면 B 출력
					System.out.println("B");
					return;
				}

				double ans = a * point[1].y + b;// 다음 항을 구하기 y = ax + b;

				System.out.println((int) ans);
			}

			else {// divide 0 예외처리
				System.out.println("B");
			}
		}

		else {
			String[] input = br.readLine().split(" ");

			Point[] point = new Point[input.length - 1];

			for (int i = 0; i < input.length - 1; i++) {// point 저장
				int x = Integer.parseInt(input[i]);
				int y = Integer.parseInt(input[i + 1]);
				point[i] = new Point(x, y);
			}

			double a = 0, b = 0;

			if (point[0].x - point[1].x != 0) {// 기울기, 절편 구하기
				a = (double) (point[0].y - point[1].y) / (double) (point[0].x - point[1].x);
				b = point[0].y - (a * point[0].x);

				if (a % 1 != 0) {
					System.out.println("B");
					return;
				}
				if (b % 1 != 0) {
					System.out.println("B");
					return;
				}

			} else {
				System.out.println("B");
				return;
			}

			for (int i = 2; i < point.length; i++) {// 0, 1번째 포인트 이후에 규칙을 만족하는가?
				if (point[i].y != a * point[i].x + b) {
					System.out.println("B");
					return;// 만족 못했으면 B 출력 후 리턴
				}
			}

			double ans = a * point[point.length - 1].y + b;// 다 만족했으면 답 구하기

			System.out.println((int) ans);
		}
	}

}
