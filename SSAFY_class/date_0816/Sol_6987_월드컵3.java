package date_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_6987_월드컵3 {
	static int[][] game = { // 하루에 하나 게임 진행한다고 하자
			{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 }, // team1
			{ 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 } // team2
	};

	static int[][] input; // 입력으로 들어온 점수표, 가능한 점수인지 계산 예정.
	static int[][] make; // 내가 모든 경기에 대한 승무패 경우를 만들어서 누가 몇승, 몇패하는 경우 입력과 일치하는가?

	static final int WIN = 0, LOSE = 2, DRAW = 1;

	static int ans; // 0 or 1

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			input = new int[6][3];
			make = new int[6][3];

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

			ans = 0;

			game(0);

			System.out.print(ans + " ");
		}
	}

	private static void game(int day) {// 총 15번의 경기가 이루어질 예정
		if (day == 15) {
			if (check()) {
				ans = 1;
			}
			return;
		}

		int team1 = game[0][day];
		int team2 = game[1][day];

		// 만약 팀 1이 이기는 경우
		if (make[team1][WIN] + 1 <= input[team1][WIN] && make[team2][LOSE] + 1 <= input[team2][LOSE]) {

			make[team1][WIN]++; // 각각 승과 패 카운트를 기록
			make[team2][LOSE]++;
			game(day + 1);// 다음 날 경기 진행
			make[team1][WIN]--;
			make[team2][LOSE]--; // reset
		}

		// 만약 팀 2가 이기는 경우
		if (make[team1][LOSE] + 1 <= input[team1][LOSE] && make[team2][WIN] + 1 <= input[team2][WIN]) {

			make[team2][WIN]++;
			make[team1][LOSE]++; // 각각 승과 패 카운트를 기록
			game(day + 1);// 다음 날 경기 진행
			make[team2][WIN]--;
			make[team1][LOSE]--; // reset
		}

		// 비기는 경우
		if (make[team1][DRAW] + 1 <= input[team1][DRAW] && make[team2][DRAW] + 1 <= input[team2][DRAW]) {

			make[team1][DRAW]++;
			make[team2][DRAW]++;
			game(day + 1);// 다음 날 경기 진행
			make[team1][DRAW]--;
			make[team2][DRAW]--; // reset
		}
	}

	private static boolean check() { // 기자의 예측표와 내가 만든 예측표와 비교
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (input[i][j] != make[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
