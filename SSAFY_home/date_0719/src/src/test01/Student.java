package src.test01;
public class Student extends Person{
//	Student(){
//		super("", "");
//	}-> 이게 생략되어 있는거임

	@Override
//	public String printInfo() {
	public void printInfo() {	
		System.out.println("오버라이드된 인포다옹");
	}
}
