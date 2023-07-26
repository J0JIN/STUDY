package 실습2;

import java.io.Serializable;

public class Student implements Serializable {
	private String stuNum;
	private String name;
	private int score;
	
	public Student(String stuNum, String name, int score) {
		super();
		this.stuNum = stuNum;
		this.name = name;
		this.score = score;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", name=" + name + ", score=" + score + "]";
	}
	
	
}
