package date_0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol_2239_½ºµµÄí {

	private static int[][] map = new int[9][9];

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		insertNum(1);
	}

	private static void insertNum(int input) {

		int i = input % 9;
		int j = input / 9;
		
		if(map[i][j] == 0) {
			
			for(int k = 1; k <=9;k++) {
				
				map[i][j] = k;
				if(test()) {
					insertNum(input+1);
				}
			}
			
		}else {
			insertNum(input+1);
		}

	}

	private static boolean test() {

		int[] test;

		// row test
		for (int j = 0; j < 9; j++) {
			test = new int[10];
			for (int i = 0; i < 9; i++) {
				test[map[i][j]]++;
				if (test[map[i][j]] > 1) {
					return false;
				}
			}
		}

		// col test
		for (int i = 0; i < 9; i++) {
			test = new int[10];
			for (int j = 0; j < 9; j++) {
				test[map[i][j]]++;
				if (test[map[i][j]] > 1) {
					return false;
				}
			}
		}

		// box test
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				test = new int[10];

				for (int di = 0; di < 3; di++) {
					for (int dj = 0; dj < 3; dj++) {

						test[map[3 * i + di][3 * j + dj]]++;
						if (test[map[3 * i + di][3 * j + dj]] > 1) {
							return false;
						}

					}
				}

			}
		}

		return true;
	}
}
