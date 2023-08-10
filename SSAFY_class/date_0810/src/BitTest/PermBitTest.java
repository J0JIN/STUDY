package BitTest;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class PermBitTest {

	static int N, R, input[], numbers[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N];
		numbers = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		perm(0,0);
	}

	static void perm(int idx, int flag) {
		
		if(idx == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 모든 i에 대해서
		for (int i = 0; i < N; i++) {
			// flag가 설정되어 있지 않다면
			if ((flag & 1 << i) != 0) {
				continue;
			}
			// 수를 선택하고
			numbers[idx] = input[i];
			// 선택한 것에 대하여 플래그 갱신
			perm(idx + 1, flag | 1 << i);

		}

	}

}
