package date_0802;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Sol_15650_NandM_2 {
	static int N, M;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[M];

		comb(0, 1);

	}

	public static void comb(int idx, int start) {

		if (idx == M) {
			for(int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {
			nums[idx] = i;
			comb(idx + 1, i + 1);
		}

	}
}
