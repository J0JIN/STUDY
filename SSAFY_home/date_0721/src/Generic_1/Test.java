package Generic_1;

public class Test {
	public static void main(String[] args) {
		Box<Integer> box = new Box<Integer>();
		box.setObj(10);
		
//		box.setObj("Hello");
		int result = box.getObj();
		System.out.println(result*100);
	}

}
