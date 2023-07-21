package src.test02;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Student[] students = new Student[24]; // 배열 객체 1개 생성
		
		students[0] = new Student("영진","12", 12); // student 객체 1개 생성
		
		System.out.println(Arrays.toString(students));
		System.out.println(students[0].getName());
		
	}
}
