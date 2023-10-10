package date1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {

	static final int LEFT = 0;
	static final int RIGHT = 1;

	static int[][] magnet;
	static boolean[][] rotateInfo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());

			magnet = new int[5][9]; // [톱니번호][톱니정보]
			rotateInfo = new boolean[5][2];// [톱니번호][자성정보]

			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			updateRotateInfo();

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());

				int select = Integer.parseInt(st.nextToken());
				int rot = Integer.parseInt(st.nextToken());

				rotate(select, rot);

				updateRotateInfo();
			}

			System.out.println("#" + tc + " " + score());

		}

	}

	private static void updateRotateInfo() {
		// 우측 톱니
		for (int i = 1; i <= 3; i++) {
			if (magnet[i][2] != magnet[i + 1][6]) {
				rotateInfo[i][RIGHT] = true;
			}
		}
		// 좌측 톱니
		for (int i = 2; i <= 4; i++) {
			if (magnet[i][6] != magnet[i - 1][2]) {
				rotateInfo[i][LEFT] = true;
			}
		}
	}

	private static void rotate(int select, int rot) {
		rotatefunc(select, rot);

		if (rotateInfo[select][LEFT]) {
			rotateInfo[select][LEFT] = false;
			rotateInfo[select - 1][RIGHT] = false;
			rotate(select - 1, -rot);
		}
		if (rotateInfo[select][RIGHT]) {
			rotateInfo[select][RIGHT] = false;
			rotateInfo[select + 1][LEFT] = false;
			rotate(select + 1, -rot);
		}
	}

	private static void rotatefunc(int select, int rot) {
		// 시계방향
		if (rot > 0) {
			for (int i = 8; i > 0; i--) {
				magnet[select][i] = magnet[select][i - 1];
			}
			magnet[select][0] = magnet[select][8];
		}
		// 반시계방향
		else {
			magnet[select][8] = magnet[select][0];

			for (int i = 0; i < 8; i++) {
				magnet[select][i] = magnet[select][i + 1];
			}
		}
	}

	private static int score() {
		int ret = 0;
		for (int i = 1; i <= 4; i++) {
			if (magnet[i][0] == 1) {
				ret = ret | (1 << (i - 1));
			}
		}
		return ret;
	}
}
