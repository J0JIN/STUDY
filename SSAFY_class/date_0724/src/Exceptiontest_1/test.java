package Exceptiontest_1;

/* ������ ����
 * 1: ��üũ ����(RuntimeException�� �ڼ� ��ü) > ����ó�� �ʼ� X
 * 2: üũ���� (������ Exception Ŭ������ �ڼհ�ü) > ����ó�� �ʼ�
 * 	2-1: ����ó�� ���� > throws �ؼ� ������
 * 	2-2: try-catch-finally�� ������ ����
 */	


public class test {
	public static void main(String[] args) throws InterruptedException {
		for(int i = 10; i < 10; i--) {
			Thread.sleep(1000);
			System.out.println(i);
		}
	}
}
