package 실습2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class test03 {
	
	public static int size;
	
	public static void main(String[] args) {
		ArrayList<Student> sList = new ArrayList<>();
		
		sList.add(new Student("1", "조영진", 56));
		sList.add(new Student("2", "조영지", 56));
		
		Collections.sort(sList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		Collections.sort(sList, (s1, s2) ->{
//			int num;
//			람다 함수가 실행되는 타이밍에 만들어지는 지역변수
			
			if(s1.getScore() > s2.getScore()) {
				return 1;
			}else if(s1.getScore() < s2.getScore()) {
				return -1;
			}
//			sList = new ArrayList<>();
//			람다식 내부에는 밖에있는 변수를 건드리려고 하면 에러 발생
			
			size = 0;
//			하지만 클래스 멤버변수는 사용 가능
			
			return 0;
		});
		
	}
}
