package date_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1228_암호문1_2_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());

			ArrayList<String> crypto = new ArrayList<>();

			String[] input02 = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				crypto.add(input02[i]);
			}

			int cmd = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < cmd; i++) {

				switch (st.nextToken()) {
				case "I":
					int startIdx01 = Integer.parseInt(st.nextToken());
					int insertNum = Integer.parseInt(st.nextToken());
					ArrayList<String> insert = new ArrayList<>();

					for (int j = 0; j < insertNum; j++) {
						insert.add(st.nextToken());
					}
				
					crypto.addAll(startIdx01, insert);
					break;
					
				case "D":
					int startIdx02 = Integer.parseInt(st.nextToken());
					int delNum = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < delNum; j++) {
						crypto.remove(startIdx02);
					}
					break;
					
				case "A":
					int addNum = Integer.parseInt(st.nextToken());
					ArrayList<String> add = new ArrayList<>();

					for (int j = 0; j < addNum; j++) {
						add.add(st.nextToken());
					}
				
					crypto.addAll(add);
					break;
					
				}

			}
			
			
			while (true) {
				crypto.remove(10);
				if (crypto.size() == 10) {
					break;
				}
			}
			
			
			System.out.print("#" + t + " ");
			while (!crypto.isEmpty()) {
				System.out.print(crypto.remove(0) + " ");
			}
			System.out.println();

		}

	}
}
