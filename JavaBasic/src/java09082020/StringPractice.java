package java09082020;

import java.util.Scanner;

public class StringPractice {
	public static void main(String[] args) {
		// Define variables
		String str1;
		String str2;
		Scanner sc = new Scanner(System.in);
		
		// Input test
		System.out.print("scanner.next() test : ");
		str1 = sc.next(); // Do not use Space, and Input the string1
		sc.nextLine(); // Input enter
		System.out.print("scanner.nextLine() test : ");
		str2 = sc.nextLine(); // input the string2
		
		// Output test
		System.out.println("scanner.next() output : " + str1);
		System.out.println("scanner.nextLine() output : " + str2);
		
		sc.close();
	}
}
