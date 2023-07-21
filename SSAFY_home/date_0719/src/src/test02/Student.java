package src.test02;

public class Student {
	private String name;
	private String num;
	private int age;

/////////////////////////////////////////////////////////////////
	public Student() {
	}

	public Student(String name, String num, int age) {
		this.num = num;
		this.age = age;
		this.name = name;
	}
/////////////////////////////////////////////////////////////////

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
