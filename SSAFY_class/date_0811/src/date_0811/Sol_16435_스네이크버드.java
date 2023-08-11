package date_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sol_16435_스네이크버드 {
	static ArrayList<Integer> fruits;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input01 = br.readLine().split(" ");
		
		int N = Integer.parseInt(input01[0]);
		int L = Integer.parseInt(input01[1]);
		
		fruits = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			fruits.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(fruits);
		
		for(int fruit : fruits) {
			if(fruit <= L) {
				L++;
			}
		}
		
		System.out.println(L);
		
	}
}
