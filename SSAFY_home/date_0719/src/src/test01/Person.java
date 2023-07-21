package src.test01;

public class Person {
	private String name;
	private String phone;
	
	public Person() {
		this("무명", "123-123-123");
//		System.out.println("Person 생성자()생성은 니가 해,, 난 다른거 할랭");
//		System.out.println("-----------------------------------");
//		name ="무명";
//		phone = "123-123-123";
	}
	
	public Person(String n, String p) {
		this.name = n;
		this.phone = p;
//		System.out.println("Person 생성자(str, str) : 먼저 일한다이..");
//		System.out.println("-----------------------------------");
	}
	
	public void setName(String str) {
		this.name = str;
	}
	
	public String getName() {
		return this.name;
	}
	
	
//	이 위는 독특한 역할을 명확하게 가지는 메소드들. (생성자/ getter, setter)
	
//	아래는 사용자가 원하는 대로
	public void printInfo() {
		System.out.println(name + " " + phone + " 으..응기잇");
	}
	
}
