package date_0801;

import java.util.Scanner;

public class _1208_Flatten {

	static int[] box;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int dump = sc.nextInt();

			box = new int[100];

			for (int i = 0; i<100; i++) {
				box[i] = sc.nextInt();
			}

			for (int i = 0; i < dump; i++) {
				MaxMinus();
				MiniPlus();
			}

			int max = MaxMinus();
			int min = MiniPlus();

			System.out.println("#" + t + " " + (max - min));
		}

	}

	public static int MaxMinus() {
		int max = 0;
		int idx = 0;
		for (int i = 0; i < box.length; i++) {
			if (box[i] >= max) {
				max = box[i];
				idx = i;
			}
		}

		box[idx]--;
		return max;
	}

	public static int MiniPlus() {
		int min = 100;
		int idx = 0;
		for (int i = 0; i < box.length; i++) {
			if (box[i] <= min) {
				min = box[i];
				idx = i;
			}
		}

		box[idx]++;
		return min;
	}

}
