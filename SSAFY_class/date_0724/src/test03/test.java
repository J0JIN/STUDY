package test03;

public class test {
	public static void main(String[] args) throws SoSadException, RuntimeException {
		Student s1 = new Student();
		s1.SetName("조영진");
		s1.SetScore(85);
		s1.printInfo();
		
		Student s2 = new Student();
		s2.SetName("양유진");
		s2.SetScore(55);
		s2.printInfo();
	}
}
