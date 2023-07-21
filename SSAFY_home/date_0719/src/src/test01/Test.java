package src.test01;

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person();
		
//		p1.name = "헬로링";
//		-> private라 못바꿔유~
		
		p1.setName("헬로링");
		String p1_name = p1.getName();
		System.out.println(p1_name);
		
///-----------------------------------------
		
		p1.printInfo();
		
		Person p2 = new Student();
		Student s1 = new Student();
		
		p2.printInfo();
		s1.printInfo();
	
		
	}
}