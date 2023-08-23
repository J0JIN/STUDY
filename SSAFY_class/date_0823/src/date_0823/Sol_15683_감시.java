package date_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sol_15683_감시 {

	static int[][][] cctvInfo = { //
			{}, //
			{ { 0 }, { 1 }, { 2 }, { 3 } }, //
			{ { 0, 1 }, { 2, 3 } }, //
			{ { 0, 3 }, { 3, 1 }, { 1, 2 }, { 2, 0 } }, //
			{ { 1, 2, 3 }, { 0, 2, 3 }, { 0, 1, 3 }, { 0, 1, 2 } }, //
			{ { 0, 1, 2, 3 } } //
	};//

	static int N, M;
	static ArrayList<CCTV> camera;
	static int ans;

	static int[] di = { -1, 1, 0, 0 }; // 0상 1하 2좌 3우
	static int[] dj = { 0, 0, -1, 1 };

	static class CCTV {
		int x, y, num;

		public CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		camera = new ArrayList<>();
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					camera.add(new CCTV(i, j, map[i][j]));
				}
			}
		}

		dfs(0, map);

		System.out.println(ans);
	}

	private static void dfs(int camIdx, int[][] origin) {
		if (camIdx == camera.size()) {
			int zero = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					zero += origin[i][j] == 0 ? 1 : 0;
				}
			}
			ans = Math.min(ans, zero);
			return;
		}

		int[][] camRotate = cctvInfo[camera.get(camIdx).num];
		CCTV nowCam = camera.get(camIdx);

		for (int r = 0; r < camRotate.length; r++) {
			int[][] copy = deepcopy(origin);

			int[] now = camRotate[r];
			for (int d = 0; d < now.length; d++) {
				draw(nowCam.x, nowCam.y, now[d], copy);
			}
			dfs(camIdx + 1, copy);
		}
	}

	static void draw(int si, int sj, int dir, int[][] copy) {
		int nexti = si + di[dir];
		int nextj = sj + dj[dir];
		while (true) {
			if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || copy[nexti][nextj] == 6)
				break;

			copy[nexti][nextj] = 7;
			nexti += di[dir];
			nextj += dj[dir];
		}
	}

	static int[][] deepcopy(int[][] origin) {
		int[][] copy = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

}
