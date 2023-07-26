package 실습;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class test01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Student> aList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("1:add / 2: print / 3: save / 4: load / -1: exit");
			System.out.print("Select > ");

			int select = Integer.parseInt(br.readLine());

			switch (select) {
			case 1:
				System.out.println("stuNum > ");
				String stuNum = br.readLine();
				System.out.println("socre > ");
				int score = Integer.parseInt(br.readLine());
				System.out.println("name > ");
				String name = br.readLine();

				aList.add(new Student(stuNum, name, score));

				System.out.println("add complete");

				break;

			case 2:
				System.out.println("-------------------");
				for (Student s : aList) {
					System.out.println(s);
				}
				System.out.println("-------------------");
				break;

			case 3:
				save(aList);
				break;

			case 4:
				aList = load();
				break;

			case -1:
				System.out.println("프로그램을 종료합니다.");
				return;

			}
		}
	}

	private static ArrayList<Student> load() {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("C:\\Temp\\savefile"));
			return (ArrayList<Student>) ois.readObject();
		}catch(ClassNotFoundException e) {
			System.out.println("? ㅋ");
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			System.out.println("? ㅋ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("? ㅗ");
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private static void save(ArrayList<Student> aList) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("C:\\Temp\\savefile"));
			oos.writeObject(aList);
		} catch (FileNotFoundException e) {
			System.out.println("? ㅋ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("? ㅗ");
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
