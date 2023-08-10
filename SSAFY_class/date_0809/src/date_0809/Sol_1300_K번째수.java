package date_0809;

import java.util.Scanner;

public class Sol_1300_K번째수 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		System.out.println(getNum(n,k));
		
	}
	
	static long getNum(int n, int k) {

		long left = 1, right = k;
		long mid;
		long ret = k;

		while (left <= right) {
			mid = (left + right) / 2;

			long cnt = 0;
			for (int i = 1; i <= n; i++) {
				cnt += Math.min(n, mid / i);
			}

			if (cnt >= k) {
				right = mid - 1;
				ret = Math.min(ret, mid);
			} else {
				left = mid + 1;
			}
		}
		return ret;
	}
}