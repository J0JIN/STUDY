package Exceptiontest;

import java.util.Scanner;

public class test {
	public static void main(String[] args) throws ArithmeticException{
		Scanner sc = new Scanner(System.in);

		try {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			System.out.println("result : " + (n1 / n2));
		} catch (ArithmeticException ax) {
			System.out.println("Cannot div 0, it will be Inf");
		} 
		System.out.println("Á¾·á");
	}
}
