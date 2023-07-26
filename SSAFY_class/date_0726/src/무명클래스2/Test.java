package 무명클래스2;

public class Test {
	
	public static void main(String[] args) {
		func(new MyInterface() {
			
//			@Override
//			public void b() {
//				// TODO Auto-generated method stub
//				System.out.println("b");
//			}
			
			@Override
			public void a() {
				// TODO Auto-generated method stub
				System.out.println("a");
			}
		});
		
		func(()->{System.out.println("a");});
//		위와 같은 무명 클래스 구현 시 인터페이스 내부에 함수는 1개만 있어야 된다.
//		2개 있으면 뭘 할지 모른다..
		
	}
	
	static void func(MyInterface obj) {
		obj.a();
	}
}
