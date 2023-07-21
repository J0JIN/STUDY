package date_0720;

class SingletonClass {
	// TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
//	외부에서 생성자에 접근을 금지!!

//	private SingletonClass sc = new SingletonClass();
	private static SingletonClass sc = new SingletonClass();

//	public SingletonClass getInstance() {
	public static SingletonClass getInstance() {
		return sc;
	}

	// END
	public void sayHello() {
		System.out.println("Hello");
	}

}

public class Singleton {
	public static void main(String[] args) {
		// TODO:SingletonClass를 사용해보세요.

		// END
	}
	
}
