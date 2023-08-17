package date_0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Sol_11582_치킨_TOP_N {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(br.readLine());

		// N / k -> 리스트 사이즈
		// k -> 리스트 개수

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			list.add(new ArrayList<>());
			for (int j = 0; j < N / k; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list.get(i));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < N / k; j++) {
				sb.append(list.get(i).get(j)).append(" ");
			}
		}

		System.out.println(sb.toString());
	}

}
