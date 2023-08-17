package date_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_6987_월드컵 {

	static int[][] map;
	static int[][] WDL;
	static int[] A, B, C, D, E;
	static boolean[] visitA, visitB, visitC, visitD, visitE;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			map = new int[6][6];
			WDL = new int[6][3];

			A = new int[5];
			visitA = new boolean[5];

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					map[i][j] = -2;
				}
			}

			for (int i = 0; i < 6; i++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				WDL[i][0] = win;
				WDL[i][1] = draw;
				WDL[i][2] = lose;
			}

			ans = false;
			comb(A, visitA, 0, WDL[0][0], WDL[0][1], WDL[0][2]);
			System.out.print(ans ? "1 " : "0 ");
			
			ans = false;

		}

	}

	public static void comb(int[] arr, boolean[] visit, int idx, int win, int draw, int lose) {
		if (win < 0 || lose < 0 || draw < 0) {
			return;
		}

		if (win + draw + lose > 5) {
			return;
		}

		if (idx == arr.length) {
			int row = 5 - arr.length;

			for (int i = 5; i > row; i--) {
				map[row][i] = arr[i-row-1];
				map[i][row] = -arr[i-row-1];
			}
			
			int nextWin = WDL[row+1][0];
			int nextDraw = WDL[row+1][1];
			int nextLose = WDL[row+1][2];
			
			for (int j = 0; j < 6; j++) {
				if (map[row+1][j] == -1) {
					nextLose--;
				}
				if (map[row+1][j] == 0) {
					nextDraw--;
				}
				if (map[row+1][j] == 1) {
					nextWin--;
				}
			}
			
			if (nextWin < 0 || nextLose < 0 || nextDraw < 0) {
				return;
			}
			
			if (arr.length > 1) {
				int[] nextArr = new int[arr.length - 1];
				boolean[] nextVisit = new boolean[arr.length - 1];
				comb(nextArr, nextVisit, 0, nextWin, nextDraw, nextLose);
			} else {
				ans = true;
			}
			
			
			return;
		}

		if (visit[idx] == false) {

			visit[idx] = true;
			arr[idx] = 1;
			comb(arr, visit, idx + 1, win - 1, draw, lose);
			visit[idx] = false;

			visit[idx] = true;
			arr[idx] = 0;
			comb(arr, visit, idx + 1, win, draw - 1, lose);
			visit[idx] = false;

			visit[idx] = true;
			arr[idx] = -1;
			comb(arr, visit, idx + 1, win, draw, lose - 1);
			visit[idx] = false;

		}
	}
}
