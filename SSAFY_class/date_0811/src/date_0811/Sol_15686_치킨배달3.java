package date_0811;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol_15686_치킨배달3 {

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static ArrayList<Point> homes;
	static ArrayList<Point> chickens;

	static boolean[] select;

	static int N, M, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		homes = new ArrayList<>();
		chickens = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				int tmp = sc.nextInt();

				if (tmp == 1) {
					homes.add(new Point(i, j));
				}

				if (tmp == 2) {
					chickens.add(new Point(i, j));
				}
			}
		}

		select = new boolean[chickens.size()];
		ans = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int idx, int cnt) {

		if (cnt == M) {
			int sum = 0;
			for (Point home : homes) {
				int minDist = Integer.MAX_VALUE;
				for (int c = 0; c < chickens.size(); c++) {
					if (select[c]) {
						Point chicken = chickens.get(c);
						int dist = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);
						minDist = Math.min(minDist, dist);
					}
				}
				sum += minDist;
			}

			ans = Math.min(ans,sum);
			return;
		}
		if (idx == chicken.size()) {
			return;
		}

		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);

	}

}
