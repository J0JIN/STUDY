package date_0802;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N, numbers[];
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Math.
		
		N = sc.nextInt();// 주사위 던지는 횟수

		int M = sc.nextInt();// 주사위 던지기 모드

		numbers = new int[N];

		switch (M) {
		case 1: // 중복순열
			dice1(0);
			break;
		case 2: // 순열
			isSelected = new boolean[7];
			dice2(0);
			break;
		case 3: 
			dice3(0, 1);
			break;
		case 4: 
			dice4(0, 1);
			break;
		}
	}

	private static void dice1(int idx) { // cnt + 1번째 주사위 던지기, 기존까지 던져진 주사위 횟수
		if (idx == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 1; i <= 6; i++) {
			numbers[idx] = i;
			dice1(idx + 1);
		}
	}

	private static void dice2(int idx) { // cnt + 1번째 주사위 던지기, 기존까지 던져진 주사위 횟수

		if (idx == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 한번 던질 떄 가능한 상황에 대한 시도(1 to 6)
		for (int i = 1; i <= 6; i++) {
			// 기존 주사위의 눈과 중복되는지 체크
			if (isSelected[i] == false) {
				numbers[idx] = i;
				isSelected[i] = true;
				dice2(idx + 1);
				isSelected[i] = false;
			}
		}
	}
	
	private static void dice3(int idx, int start) { // 시작 주사위 눈의 수

		if (idx == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 한번 던질 떄 가능한 상황에 대한 시도(1 to 6)
		for (int i = start; i <= 6; i++) {
			numbers[idx] = i;
			dice3(idx + 1, i);
		}
	}

	private static void dice4(int idx, int start) { // 시작 주사위 눈의 수

		if (idx == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 한번 던질 떄 가능한 상황에 대한 시도(1 to 6)
		for (int i = start; i <= 6; i++) {
			numbers[idx] = i;
			dice3(idx + 1, i +1);
		}
	}
	
	

}