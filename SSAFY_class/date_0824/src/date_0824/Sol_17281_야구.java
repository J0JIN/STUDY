package date_0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_17281_야구 {
	static Queue<Integer> Hitter;
	static int[] hit, base, select;
	static int[][] result;
	static boolean[] isSelected;
	static int ining;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
	
		init();
		
		perm(0);

		System.out.println(ans);
	}

	private static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ining = Integer.parseInt(br.readLine());

		Hitter = new ArrayDeque<Integer>();
		isSelected = new boolean[10];
		select = new int[8];

		result = new int[ining + 1][10];
		for (int i = 1; i <= ining; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

	private static void perm(int idx){
		if (idx >= 8) {

//			System.out.println(Arrays.toString(select));

			for (int i = 1; i <= 9; i++) {
				if (i == 4) {
					Hitter.add(1);
				} else if (i < 4) {
					Hitter.add(select[i - 1]);
				} else {
					Hitter.add(select[i - 2]);
				}
			}

			Simulate();
			Hitter.clear();
			return;
		}

		for (int i = 2; i <= 9; i++) {
			if (!isSelected[i]) {
				select[idx] = i;
				isSelected[i] = true;
				perm(idx + 1);
				isSelected[i] = false;
			}
		}
	}

	private static void Simulate() {
		int total = 0;

		for (int n = 1; n <= ining; n++) {

			int outCount = 0;
			int iningScore = 0;
			base = new int[5];

			while (outCount < 3) {
				int tmpHitter = Hitter.poll();
				Hitter.offer(tmpHitter);

				switch (result[n][tmpHitter]) {
				case 1:
					iningScore += hit_1();
					break;
				case 2:
					iningScore += hit_2();
					break;
				case 3:
					iningScore += hit_3();
					break;
				case 4:
					iningScore += hit_4();
					break;
				case 0:
					outCount++;
					break;

				}
			}

			total += iningScore;

		}

		ans = Math.max(total, ans);
	}

	private static int hit_4() {
		int iningScore = 0;
		for (int i = 1; i <= 3; i++) {
			if (base[i] == 1) {
				base[i] = 0;
				iningScore++;
			}
		}
		iningScore++;

		return iningScore;
	}

	private static int hit_3() {
		int iningScore = 0;
		for (int i = 3; i >= 1; i--) {
			if (base[i] == 1) {
				if (i + 3 < 4) {
					base[i + 3] = 1;
					base[i] = 0;
				} else {
					base[i] = 0;
					iningScore++;
				}
			}
		}

		base[3] = 1;
		return iningScore;
	}

	private static int hit_2() {
		int iningScore = 0;
		for (int i = 3; i >= 1; i--) {
			if (base[i] == 1) {
				if (i + 2 < 4) {
					base[i + 2] = 1;
					base[i] = 0;
				} else {
					base[i] = 0;
					iningScore++;
				}
			}
		}

		base[2] = 1;
		return iningScore;
	}

	private static int hit_1() {
		int iningScore = 0;
		for (int i = 3; i >= 1; i--) {
			if (base[i] == 1) {
				if (i + 1 < 4) {
					base[i + 1] = 1;
					base[i] = 0;
				} else {
					base[i] = 0;
					iningScore++;
				}
			}
		}

		base[1] = 1;
		return iningScore;
	}
}
