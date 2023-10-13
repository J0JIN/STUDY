package date_1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class Sol_12100_2048EASY {

	static int N;
	static int[][] map;
	static int[][] copyMap;

	static int ans = 0;

	static int[] select;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		select = new int[5];

		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0, 0);
		System.out.println(ans);
	}

	private static void perm(int idx, int cnt) {
		if (cnt == 5) {
			play(map);
			return;
		}

		for (int d = 0; d < 4; d++) {
			select[idx] = d;
			perm(idx + 1, cnt + 1);
		}
	}

	private static void play(int[][] inMap) {
		copyMap = new int[N][N];
		deepCopy(copyMap, inMap);

		for (int i = 0; i < 5; i++) {
			switch (select[i]) {
			case 0:
				push();
				break;
			case 1:
				rotate();
				push();
				break;
			case 2:
				rotate();
				rotate();
				push();
				break;
			case 3:
				rotate();
				rotate();
				rotate();
				push();
				break;
			}
		}

	}

	private static void deepCopy(int[][] copyMap2, int[][] inMap) {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				copyMap[i][j] = inMap[i][j];
			}
		}
	}

	private static void rotate() {
		int[][] rotMap = new int[N][N];

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				rotMap[i][j] = copyMap[N - 1 - j][i];
			}
		}
		deepCopy(copyMap, rotMap);
	}

	private static void push() {
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (copyMap[i][j] == 0) {
					for (int cnt = i; cnt < N; cnt++) {
						if (copyMap[cnt][j] > 0) {
							copyMap[i][j] = copyMap[cnt][j];
							copyMap[cnt][j] = 0;
							break;
						}
					}
				}
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (copyMap[i][j] == copyMap[i + 1][j]) {
					copyMap[i][j] *= 2;

					ans = Math.max(ans, copyMap[i][j]);
					copyMap[i + 1][j] = 0;
				}
			}

			for (int i = 0; i < N; i++) {
				if (copyMap[i][j] == 0) {
					for (int cnt = i; cnt < N; cnt++) {
						if (copyMap[cnt][j] > 0) {
							copyMap[i][j] = copyMap[cnt][j];
							copyMap[cnt][j] = 0;
							break;
						}
					}
				}
			}
		}
	}

}
