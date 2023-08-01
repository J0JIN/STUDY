package date_0801;

import java.util.Arrays;

public class Test01 {

	static String[] cards = { "a", "b", "c", "d", "e" };
	static boolean[] used = new boolean[cards.length];
	static String[] result = new String[3];

	public static void main(String[] args) {
		perm(0);
	}

	static void perm(int idx) {
		if(idx == 3) {
			System.out.println(Arrays.toString(result)); // 완료했으면 말하고 가
			return;
		}
		
		for (int i = 0; i < cards.length; i++) {
			if (used[i] == false) { // i번 카드가 사용 가능한지
				result[idx] = cards[i]; // 사용 가능하면 카드 둠
				used[i] = true;// 이제 내가 사용함
				perm(idx + 1);// 다음사람 지명
				used[i] = false;// 다씀
				
			}
		}
		
		return;
	}

}
