package date_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class SWEA_2382_미생물격리 {

	private static class Micro implements Comparable<Micro> {
		int x, y;
		int size;
		int look;

		public Micro(int x, int y, int size, int look) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.look = look;
		}

		@Override
		public int compareTo(Micro o) {
			return o.size - this.size;
		}

	}

	static ArrayList<Micro> micro;
	static ArrayList<Micro> addMicro;

	static int[][] map;

	static int K, N, M;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static BufferedReader br;
	static StringTokenizer st;

//	// 1. 군집은 이동 방향에있는 다음셀로 이동한다.
//	
//	// 2. 군집 판정
//		// 2.1) 일반 땅
//			// -> 혼자인가?
//				//: 그대로 진행
//			// -> 둘 이상인가?
//				//: 병합 진행
//	
//		// 2.2) 약품 땅 
//			// -> 반토막, 보는 방향 반대로
//	
//	// 3. 죽임 판정
//		// 군집 내에 미생물이 0이 되면 게임에서 제외

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			init();

			for (int m = 0; m < M; m++) {
				move();
				updateState();
				print();
			}

			System.out.println(checkAns());
		}

	}

	private static int checkAns() {
		int total = 0;
		for (Micro next : micro) {
			total += next.size;
		}
		return total;
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		micro = new ArrayList<>();
		addMicro = new ArrayList<>();
		map = new int[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			int look = Integer.parseInt(st.nextToken());
			micro.add(new Micro(x, y, size, look - 1));

			map[x][y]++;
		}
	}

	private static void updateState() {
		for (int i = micro.size() - 1; i >= 0; i--) {

			if (!isRedzone(micro.get(i).x, micro.get(i).y)) {
				if (map[micro.get(i).x][micro.get(i).y] > 1) {
					addMicro.add(micro.get(i));
					micro.remove(micro.get(i));
				}
			} else {
				micro.get(i).size /= 2;
				if (micro.get(i).size == 0) {
					micro.remove(micro.get(i));
				}

				if (micro.get(i).look % 2 == 1) {
					micro.get(i).look--;
				} else {
					micro.get(i).look++;
				}
			}
		}

		if (!addMicro.isEmpty()) {
			Collections.sort(addMicro);
			// 사이즈 더하기
			for (int i = 1; i < addMicro.size(); i++) {
				addMicro.get(0).size += addMicro.get(i).size;
			}
			// 다시 마이크로에 추가하기
			micro.add(addMicro.get(0));

			// 다시 맵에 칠하기
			map[addMicro.get(0).x][addMicro.get(0).y] = 1;

			addMicro.clear();
		}
	}

	private static void move() {
		for (Micro next : micro) {
			int x = next.x;
			int y = next.y;
			int look = next.look;

			int nx = x + dx[look];
			int ny = y + dy[look];

			next.x = nx;
			next.y = ny;

			map[nx][ny]++;
			map[x][y]--;
		}
	}

	private static boolean isRedzone(int x, int y) {
		if (1 <= x && x < N - 1 && 1 <= y && y < N - 1) {
			return false;
		} else {
			return true;
		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[j][i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println("---------------------");
		
	}
}
