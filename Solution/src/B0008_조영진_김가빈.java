import java.net.*;
import java.io.*;

public class test01 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "조영진2";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final double SIZE_BALL = 4.0;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
	static final int[][] NEW_HOLES = { { 3, 3 }, { 127, 3 }, { 251, 3 }, { 3, 124 }, { 127, 124 }, { 251, 124 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// 타겟 순서
				int[] order_target = new int[3];

				if (order == 1) {
					order_target[0] = 1;
					order_target[1] = 3;
					order_target[2] = 5;
				}

				if (order == 2) {
					order_target[0] = 2;
					order_target[1] = 4;
					order_target[2] = 5;
				}

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				double whiteBall_x = balls[0][0];
				double whiteBall_y = balls[0][1];

				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				double targetBall_x;
				double targetBall_y;

				if (balls[order_target[0]][0] > 0 && balls[order_target[0]][1] > 0) {
					targetBall_x = balls[order_target[0]][0];
					targetBall_y = balls[order_target[0]][1];
					
//					double a = (targetBall_y - whiteBall_y) / (targetBall_x - whiteBall_x);
//					double b = (targetBall_y - a * targetBall_x);
//					
//					for(int i = 1; i < 6; i++) {
//						double x = balls[i][0];
//						double y = balls[i][1];
//						
//						if((y-a*x-b-SIZE_BALL)*(y-a*x-b+SIZE_BALL) < 0) {
//							targetBall_x = balls[order_target[1]][0];
//							targetBall_y = balls[order_target[1]][1];
//						}
//					}
					
				} else if (balls[order_target[1]][0] > 0 && balls[order_target[1]][1] > 0) {
					targetBall_x = balls[order_target[1]][0];
					targetBall_y = balls[order_target[1]][1];
				} else {
					targetBall_x = balls[order_target[2]][0];
					targetBall_y = balls[order_target[2]][1];
				}

				
				// 목표 HOLE 구하기
				double a = (targetBall_y - whiteBall_y) / (targetBall_x - whiteBall_x);
				System.out.println(a);

				// divide0 오류 방지
				if (-0.001 <= a && a <= 0.001) {
					if (a >= 0) {
						a = 0.001;
					} else {
						a = -0.001;
					}
				}

				// 직선 방정식 y = -1/a + b
				double orthogonal_a = -1 / a;
				double b = (targetBall_y - (orthogonal_a * targetBall_x));

				boolean[] canPocket = new boolean[6];
				for (int i = 0; i < 6; i++) {
					System.out.println(i + ":" + (orthogonal_a * whiteBall_x + b - whiteBall_y) + " "
							+ (orthogonal_a * HOLES[i][0] + b - HOLES[i][1]));

					// f(white) * f(hole) < 0 이라면 서로 직선을 기준으로 반대편에 있음
					if ((orthogonal_a * whiteBall_x + b - whiteBall_y)
							* (orthogonal_a * HOLES[i][0] + b - HOLES[i][1]) < 0) {
						canPocket[i] = true;
					}
				}

				double dist = 1000;
				int target_Hole = -1;

				for (int i = 0; i < 6; i++) {
					if (canPocket[i]) {
						double width = Math.abs(HOLES[i][0] - targetBall_x);
						double height = Math.abs(HOLES[i][1] - targetBall_y);
						double dist_a = Math.sqrt((width * width) + (height * height));

						double tan_a = Math.atan2(targetBall_y - whiteBall_y, targetBall_x - whiteBall_x);
						double tan_b = Math.atan2(HOLES[i][1] - whiteBall_y, HOLES[i][0] - whiteBall_x);
						double theta = 0;

						if (tan_a * tan_b <= 0) {
							theta = Math.abs(tan_a) + Math.abs(tan_b);
						} else {
							theta = Math.abs(tan_a - tan_b);
						}

						double dist_b = a * (Math.cos(theta));
						double dist_c = Math.sqrt((dist_a * dist_a) - (dist_b * dist_b));

						if (dist_c < dist) {
							target_Hole = i;
							dist = dist_c;
						}
					}
				}

				// 혹시 모를 예외 case는 그냥 2번으로 쳐라
				if (target_Hole == -1) {
					target_Hole = 2;
				}

				double target_to_pocket = Math.atan2(NEW_HOLES[target_Hole][1] - targetBall_y,
						NEW_HOLES[target_Hole][0] - targetBall_x);

				double dx = Math.abs(SIZE_BALL * Math.cos(target_to_pocket));
				double dy = Math.abs(SIZE_BALL * Math.sin(target_to_pocket));

				
				double degree = Math.toDegrees(target_to_pocket);
				System.out.println(degree);
				
				if (0 <= degree && degree < 90) {
					dx = -dx;
					dy = -dy;
				} else if (90 <= degree && degree <= 180) {
					dy = -dy;
				} else if (0 > degree && degree >= -90) {
					dx = -dx;
				}

				double toGo_x = targetBall_x + dx;
				double toGo_y = targetBall_y + dy;

				double answerAngle = 90.0 - Math.toDegrees(Math.atan2(toGo_y - whiteBall_y, toGo_x - whiteBall_x));

				// distance: 두 점(좌표) 사이의 거리를 계산
				double width = Math.abs(targetBall_x - whiteBall_x);
				double height = Math.abs(targetBall_y - whiteBall_y);
				double distance = Math.sqrt((width * width) + (height * height));

				// power: 거리 distance에 따른 힘의 세기를 계산
				power = (float) distance;
				angle = (float) answerAngle;

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
				//
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}