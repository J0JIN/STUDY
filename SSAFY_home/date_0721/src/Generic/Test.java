package Generic;

public class Test {
	public static void main(String[] args) {
		Box box = new Box();
		box.setObj(10);
		
//		box.setObj("Hello");
		int result = (int)box.getObj();
		System.out.println(result*100);
	}

}
