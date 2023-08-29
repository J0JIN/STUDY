package date_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sol_17143_상어왕 {

	static int X, Y, M;
	static int[][] map;
	static ArrayList<Shark> sharks;
	static int ans;

	static int kingPlace = 0;

	// 상,하,좌,우
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	private static class Shark implements Comparable<Shark> {
		int x, y, speed, look, size;

		public Shark(int x, int y, int speed, int look, int size) {
			super();
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.look = look;
			this.size = size;
		}

		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return o.size - this.size;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", speed=" + speed + ", look=" + look + ", size=" + size + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// 1. 낚시왕 이동

		// 2. 낚시왕과 가장 가까운, 아래에 있는 상어 한마리 GET.

		// 3. 상어 이동

		// 3.1. 상어가 벽에 부딪히면 튕긴다
		// 3.2. 안부딪히면 걍 고

		// 4. 이동 이후 처리

		// 4.1. 혼자 산다. => 문제없음
		// 4.2. 여러명 있다.
		// 4.2.1. 덩치가 가장 큰 아이만 남긴다.
		init();
		while (kingPlace < X) {
			moveKing();
			moveShark();
			sharkEat();
		}
		System.out.println(ans);
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sharks = new ArrayList<>();
		map = new int[X][Y];
		ans = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int look = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			sharks.add(new Shark(x - 1, y - 1, speed, look, size));
			map[x - 1][y - 1] = 1;
		}

	}

	private static void moveKing() {
		getShark();
		kingPlace++;
	}

	private static void getShark() {
		for (int i = 0; i < Y; i++) {
			if (map[kingPlace][i] == 1) {
				for (int k = 0; k < sharks.size(); k++) {
					if (sharks.get(k).x == kingPlace && sharks.get(k).y == i) {
						ans += sharks.get(k).size;
						sharks.remove(k);
						map[kingPlace][i]--;
						return;
					}
				}
			}
		}
	}

	private static void moveShark() {
		for (Shark next : sharks) {
			int x = next.x;
			int y = next.y;
			int speed = next.speed;
			int look = next.look;
			map[x][y]--;

			for (int i = 0; i < speed; i++) {
				x += dx[look];
				y += dy[look];

				if (!isIn(x, y)) {
					if (look == 1) {
						look = 2;
					} else if (look == 2) {
						look = 1;
					} else if (look == 3) {
						look = 4;
					} else if (look == 4) {
						look = 3;
					}
					x += 2 * dx[look];
					y += 2 * dy[look];
				}
			}

			next.x = x;
			next.y = y;
			next.look = look;
			map[x][y]++;
		}
	}

	private static void sharkEat() {
		ArrayList<Shark> delete = new ArrayList<>();

		for (int j = 0; j < Y; j++) {
			for (int i = 0; i < X; i++) {
				if (map[i][j] > 1) {
					for (int k = 0; k < sharks.size(); k++) {
						if (sharks.get(k).x == i && sharks.get(k).y == j) {
							delete.add(sharks.get(k));
							sharks.remove(k);
							k--;
						}
					}
					
					if (delete.size() > 0) {
						Collections.sort(delete);
						sharks.add(delete.get(0));
						delete.clear();
					}
					map[i][j] = 1;
				}
			}
		}

//		if (delete.size() > 0) {
//			Collections.sort(delete);
//			sharks.add(delete.get(0));
//			delete.clear();
//		}
	}

	private static boolean isIn(int x, int y) {
		if (0 <= x && x < X && 0 <= y && y < Y) {
			return true;
		}
		return false;
	}

}
