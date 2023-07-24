package Exceptiontest_1;

/* 예외의 종류
 * 1: 비체크 예외(RuntimeException의 자손 객체) > 예외처리 필수 X
 * 2: 체크예외 (나머지 Exception 클래스의 자손객체) > 예외처리 필수
 * 	2-1: 예외처리 문법 > throws 해서 던지기
 * 	2-2: try-catch-finally로 뭐할지 적기
 */	


public class test {
	public static void main(String[] args) throws InterruptedException {
		for(int i = 10; i < 10; i--) {
			Thread.sleep(1000);
			System.out.println(i);
		}
	}
}
