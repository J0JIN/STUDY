package date_0725;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sol_6603_로또 {
	
	public static int cnt;// 버려야하는 수 

	public static void discard(HashMap set,int count) {
		for (int i = set.size(); i >= 1; i--) {
			set.remove(i);
			count++; // 제거하고 갯수 세기
			
			if(count == cnt) {
				System.out.println(set);
				break;
			}//원하는 갯수를 버리면 멈추기
			
			discard(set, count);
			// 다시 set에서 count 시작
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			int set_num = sc.nextInt();

			if (set_num == 0) {
				break;
			}

			HashMap set = new HashMap();

			for (int i = 1; i <= set_num; i++) {
				set.put(i, sc.nextInt());
			}
			
			System.out.println(set);
			
			discard(set, set_num - 6);

		}
	}

}
