package date1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {

	static int N, W, H;
	static int ans;

	static int[][] map;
	static int[][] usemap;
	static int[] select;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static StringTokenizer st;

	static class Point {
		int x;
		int y;
		int size;

		public Point(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[W][H];
			usemap = new int[W][H];

			select = new int[N];

			for (int j = 0; j < H; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < W; i++) {
					int input = Integer.parseInt(st.nextToken());
					map[i][j] = input;
					usemap[i][j] = input;
				}
			}

			ans = Integer.MAX_VALUE;
			perm(0, N);
			System.out.println("#" + tc + " " + ans);

		}
	}

	private static void perm(int idx, int p) {
		
		if (ans == 0) {
			return;
		}
		
		if (idx == p) {
			for (int i = 0; i < N; i++) {
				bfs(select[i]);
				updateMap();
			}

			ans = Math.min(count(), ans);

			// 더럽힌 맵 정리
			deepcopy();
			return;
		}

		for (int i = 0; i < W; i++) {
			select[idx] = i;
			perm(idx + 1, p);
		}
	}

	// 이렇게 cnt 하지 말고 전체 갯수를 세고서 없어지면 빼는 식으로 하는게 더 빠를듯.
	// 다만 시간초과는 맵이 너무 작아서 안날듯
	private static int count() {
		int cnt = 0;
		for (int j = 0; j < H; j++) {
			for (int i = 0; i < W; i++) {
				if (usemap[i][j] > 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	// 블럭 깨는것은 bfs로 구현
	private static void bfs(int idx) {
		int y = -1;

		// 가장 위에 있는 벽돌 찾기
		for (int i = 0; i < H; i++) {
			if (usemap[idx][i] > 0) {
				y = i;
				break;
			}
		}

		// 빈 line 이라면 종료
		if (y == -1) {
			return;
		}

		Point start = new Point(idx, y, usemap[idx][y]);

		Queue<Point> q = new ArrayDeque<>();
		q.add(start);

		while (!q.isEmpty()) {
			Point cpoint = q.poll();
			int cx = cpoint.x;
			int cy = cpoint.y;
			int csize = cpoint.size;
			usemap[cx][cy] = 0;

			for (int d = 0; d < 4; d++) {

				for (int size = 1; size < csize; size++) {
					int nx = cx + size * dx[d];
					int ny = cy + size * dy[d];

					if (inIn(nx, ny)) {
						if (usemap[nx][ny] != 0) {
							q.add(new Point(nx, ny, usemap[nx][ny]));
						}
					}
				}
			}
		}
	}

	private static boolean inIn(int nx, int ny) {
		if (0 <= nx && nx < W && 0 <= ny && ny < H) {
			return true;
		}
		return false;
	}

	// 부순 벽돌 제거, 아래로 댕기기
	private static void updateMap() {
		// 아래서부터 댕기기
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {

				// 아래에 있는 벽돌이 0이면
				if (usemap[i][j] == 0) {

					// 위에서 부터 0보다 큰걸 찾아서 바꾸기
					for (int k = j - 1; k >= 0; k--) {
						if (usemap[i][k] > 0) {
							int swap = usemap[i][k];
							usemap[i][k] = usemap[i][j];
							usemap[i][j] = swap;
							break;
						}
					}
				}
			}
		}
	}

	private static void deepcopy() {
		for (int j = 0; j < H; j++) {
			for (int i = 0; i < W; i++) {
				usemap[i][j] = map[i][j];
			}
		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < H; j++) {
			for (int i = 0; i < W; i++) {
				sb.append(usemap[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		System.out.println("--------------------");
	}
}
