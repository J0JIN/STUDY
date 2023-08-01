package date_0731;

public class RecursionTest {
	public static void main(String[] args) {
		System.out.println("1번 답---------------------");
//        1. 1부터 9까지 출력하기
		pr(0);
		System.out.println("2번 답---------------------");
//        2. 1부터 10까지의 합을 출력하는 재귀함수를 만드시오?
		doSum(0, 10);
		System.out.println("3번 답---------------------");
//        3. 팩토리얼
		int result = fact(4); // 4! = 4*3*2*1 = 6
		System.out.println(result);
		System.out.println("4번 답---------------------");
//        4. 자연수를 넣어 그 각자리의 수의 합을 반환하는 재귀함수를 만들어라
		int sum = digitSum(12356, 0);
		System.out.println("sum:" + sum);
		System.out.println("5번 답---------------------");
//        5. 문자열을 전달받아 그문자사이에 ,를 결합하여 반환하는 재귀함수를 만들어라
		String s = doStringComma("korea", "");
//        k,o,r,e,a
		System.out.println(s);
		System.out.println("6번 답---------------------");
//        6. 피보나치수열 10개를 출력하라 // fibo4 = 1+1+2+3
		for (int i = 1; i <= 10; i++) {
			System.out.println(fibo(i));
		}
		System.out.println("7번 답---------------------");
//        7. 2진수 3자리를 구성할 수 있는 재귀함수를 만들어라
		doMakeBinary(0, "");
		System.out.println("끝---------------------");
	}

	public static void doMakeBinary(int idx, String result) {
		result = result.concat(result + "0");
		doMakeBinary(idx + 1, result);

		result = result.concat(result + "1");
		doMakeBinary(idx + 1, result);
		
		if(idx == 3) {
			System.out.println(result);
		}
	}

	public static int fibo(int num) {
		if(num == 1) {
			return 1;
		}
		else if(num == 2) {
			return 1;
		}
		else {
			return fibo(num-1) + fibo(num-2);
		}

	}

	public static String doStringComma(String s, String result) {
		if(s.length() == 1) {
			return result.concat(s.charAt(0)+"");
		}
		result = result.concat(s.charAt(0) + ",");
		s = s.substring(1);
		return doStringComma(s, result);
	}

	public static int digitSum(int data, int sum) {
		if(data/10 == 0) {
			return data%10;
		}else {
			return data%10 + digitSum(data/10, sum);
		}
	}

	public static int fact(int num) {
		if (num == 1) {
			return 1;
		} else {
			return num * fact(num - 1);
		}
	}

	public static void doSum(int sum, int num) {
		sum += num;
		if (num > 0) {
			doSum(sum, num - 1);
		} else {
			System.out.println(sum);
		}
	}

//     숫자 출력예제
	public static void pr(int num) {
		System.out.println("num" + num);
		if (num < 9) {
			pr(num + 1);
		}
	}
}
