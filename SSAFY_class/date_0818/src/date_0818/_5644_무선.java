package date_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5644_무선 {

	// 이동X, 상 - 우 - 하 - 좌
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };

	static int M, A;
	static int[] Acmd, Bcmd;

	static ChargePoint[] Charge;

	static people Aperson, Bperson;

	static StringTokenizer st;
	static BufferedReader br;

	private static class people {
		int x, y;
		boolean[] AC;

		public people(int x, int y, boolean[] ac) {
			super();
			this.x = x;
			this.y = y;
			this.AC = ac;
		}
	}

	private static class ChargePoint {
		int x, y;
		int chargeRange;
		int power;

		public ChargePoint(int x, int y, int chargeRange, int power) {
			super();
			this.x = x;
			this.y = y;
			this.chargeRange = chargeRange;
			this.power = power;
		}

		@Override
		public String toString() {
			return "ChargePoint [x=" + x + ", y=" + y + ", chargeRange=" + chargeRange + ", power=" + power + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			init();

			// 최초 위치 덧셈
			updateCharge();
			int total = getMax();

			// 그 이후 덧셈
			for (int time = 0; time < M; time++) {
				move(time);
				updateCharge();
				total += getMax();
			}

			System.out.println("#" + t + " " + total);
		}
	}

	private static int getMax() {
		// 모든 AP의 조합 탐색
		int sum = 0;
		int max = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {

				// CASE1. 둘다 접근 가능
				if (Aperson.AC[i] == true && Bperson.AC[j] == true) {
					// 근데 같으면 나눠 갖기
					if (i == j) {
						sum = Charge[i].power;
					}
					// 아니면 따로 갖기
					else {
						sum = Charge[i].power + Charge[j].power;
					}
				}

				// CASE2. 둘다 접근 불가능
				else if (Aperson.AC[i] == false && Bperson.AC[j] == false) {
					sum = 0;
				}

				// CASE3. 둘 중 하나만 접근가능
				else {
					if (Aperson.AC[i] == true) {
						sum = Charge[i].power;
					}
					if (Bperson.AC[j] == true) {
						sum = Charge[j].power;
					}
				}

				max = Math.max(max, sum);
			}
		}

		return max;
	}

	private static void updateCharge() {
		// A의 현재위치
		int ax = Aperson.x;
		int ay = Aperson.y;

		// B의 현재위치
		int bx = Bperson.x;
		int by = Bperson.y;

		// 모든 AP에 대해서
		for (int i = 0; i < A; i++) {
			// 현재 AP정보
			int cx = Charge[i].x;
			int cy = Charge[i].y;
			int cRange = Charge[i].chargeRange;

			if (cRange >= Math.abs(cx - ax) + Math.abs(cy - ay)) {
				Aperson.AC[i] = true;
			} else {
				Aperson.AC[i] = false;
			}

			if (cRange >= Math.abs(cx - bx) + Math.abs(cy - by)) {
				Bperson.AC[i] = true;
			} else {
				Bperson.AC[i] = false;
			}
		}
	}

	private static void move(int time) {
		// A위치 갱신
		int a_nx = Aperson.x + dx[Acmd[time]];
		int a_ny = Aperson.y + dy[Acmd[time]];
		Aperson.x = a_nx;
		Aperson.y = a_ny;

		// B위치 갱신
		int b_nx = Bperson.x + dx[Bcmd[time]];
		int b_ny = Bperson.y + dy[Bcmd[time]];
		Bperson.x = b_nx;
		Bperson.y = b_ny;
	}

	private static void init() throws IOException {

		// M, A값 입력
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());

		// 사용자 A의 이동 정보
		st = new StringTokenizer(br.readLine());
		Acmd = new int[M];
		for (int i = 0; i < M; i++) {
			Acmd[i] = Integer.parseInt(st.nextToken());
		}

		// 사용자 B의 이동정보
		st = new StringTokenizer(br.readLine());
		Bcmd = new int[M];
		for (int i = 0; i < M; i++) {
			Bcmd[i] = Integer.parseInt(st.nextToken());
		}

		// AP의 정보를 Charge에 저장
		Charge = new ChargePoint[A];
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			Charge[i] = new ChargePoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 사람을 새로 만들기
		Aperson = new people(1, 1, new boolean[A]);
		Bperson = new people(10, 10, new boolean[A]);

	}

}