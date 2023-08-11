package date_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_17406_배열돌리기4 {
	static int R, C, K;
	static int[][] map, originMap;
	static boolean[] isSelected;
	static int[][] Ks;
	static String ans;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		originMap = new int[R + 1][C + 1];
		map = new int[R + 1][C + 1];
		for (int r = 1; r <= R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= C; c++) {
				int input = Integer.parseInt(st.nextToken());
				originMap[r][c] = input;
				map[r][c] = input;
			}
		}

		// 수열 구해서 명령어 순서 바꿔가며 시행해야함
		Ks = new int[K][3];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			Ks[k][0] = Integer.parseInt(st.nextToken());
			Ks[k][1] = Integer.parseInt(st.nextToken());
			Ks[k][2] = Integer.parseInt(st.nextToken());
		}

		int perm[] = new int[K];
		for (int k = 0; k < K; k++) {
			perm[k] = k;
		}
		
		isSelected = new boolean[K];
		// 0 1 2 3 순서대로 담아서 인덱스 수열 구해서 순서대로 시행할 예정
		
		permutation(K, "");
		
		System.out.println(result);
	}

	public static void rotate(int startR, int startC, int endR, int endC) {

		if (startR >= (startR + endR) / 2 || startC >= (startC + endC) / 2)
			return;
		
		int[][] delta = { {1, 0}, { 0, 1}, {-1, 0}, {0, -1}};
		
		int r = startR, c = startC, dr, dc;
		int d = 0;
		int tmp = map[r][c];
		while(true /*TODO */) {
			dr = r + delta[d][0];
			dc = c + delta[d][1];
			
			if (dr == startR && dc == startC) {
				map[r][c] = tmp;
				break;
			}
			
			if (dr < startR || dc < startC || dr > endR || dc > endC) {
				d = (d + 1) % 4;

				dr = r + delta[d][0];
				dc = c + delta[d][1];
			}
			
			map[r][c] = map[dr][dc];
			r = dr;
			c = dc;
			
		}
		
		rotate(startR + 1, startC + 1, endR - 1, endC - 1);
	}
	
	public static int getMinimumSum() {
		int min = 100 * C + 1;
		int sum = 0;
		for (int r = 1; r <= R; r++) {
			sum = 0;
			for (int c = 1; c <= C; c++) {
				sum += map[r][c];
			}
			if (sum < min) {
				min = sum;
			}
		}
		
		return min;
	}
	
	public static void permutation(int depth, String str) {
		if (depth == 0) {
			arrayCopy();
			for (int i = 0; i < str.length(); i++) {
				int startR = Ks[str.charAt(i) - '0'][0] - Ks[str.charAt(i) - '0'][2];
				int startC = Ks[str.charAt(i) - '0'][1] - Ks[str.charAt(i) - '0'][2];
				int endR = Ks[str.charAt(i) - '0'][0] + Ks[str.charAt(i) - '0'][2];
				int endC = Ks[str.charAt(i) - '0'][1] + Ks[str.charAt(i) - '0'][2];
				rotate(startR, startC, endR, endC);
			}
			
			int tmp = getMinimumSum();
			if (tmp < result)
				result = tmp;
			
			return;
		}
		
		for (int k = 0; k < K; k++) {
			if (isSelected[k])
				continue;
			
			isSelected[k] = true;
			permutation(depth - 1, str + k);
			isSelected[k] = false;
		}
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				sb.append(map[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void arrayCopy() {
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				map[r][c] = originMap[r][c];
			}
		}
	}
}
