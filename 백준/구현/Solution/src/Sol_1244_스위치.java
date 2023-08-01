import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Sol_1244_스위치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int swNum = Integer.parseInt(br.readLine());
		int[] sw = new int[swNum + 1];

		String[] str = br.readLine().split(" ");

		for (int i = 1; i <= swNum; i++) {
			sw[i] = Integer.parseInt(str[i - 1]);
		}

		int people = Integer.parseInt(br.readLine());

		for (int i = 0; i < people; i++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[1]);

//			System.out.println(input[0] +" "+input[1]);

			switch (input[0]) {
			case "1":
				int count1 = N;
				while (true) {
					if (N > swNum) {
						break;
					}

					if (sw[N] == 0) {
						sw[N] = 1;
					} else {
						sw[N] = 0;
					}
					N += count1;
				}
				break;

			case "2":
				int count2 = 1;
				int n1 = 0;
				int n2 = 0;

				if (sw[N] == 0) {
					sw[N] = 1;
				} else {
					sw[N] = 0;
				}

				while (true) {
					n1 = N + count2;
					n2 = N - count2;
					if (1 <= n1 && n1 <= swNum && 1 <= n2 && n2 <= swNum) {
						if (sw[n1] == sw[n2]) {
							if (sw[n1] == 0) {
								sw[n1] = 1;
								sw[n2] = 1;
							} else {
								sw[n1] = 0;
								sw[n2] = 0;
							}
						} else {
							break;
						}
					}else {
						break;
					}

					count2++;
				}
				break;

			}
		}
		for (int i = 1; i <= swNum; i++) {
			System.out.print(sw[i] + " ");
			if(i % 20 == 0){
				System.out.println();
			}
		}
	}
}
