/*
 * < --- without sc.nextLine(), then input process --- >
 * num <- sc <-integer
 * sc(scanner object) <- enter
 * str3 <- sc(scanner object)
 */
package java09082020;

import java.util.Scanner;

public class StringPractice {
	public static void main(String[] args) {
		// Define variables 1
		String str1;
		String str2;
		Scanner sc = new Scanner(System.in);
		
		// Input test 1
		System.out.print("scanner.next() test : ");
		str1 = sc.next(); // Do not use Space, and Input the string1
		sc.nextLine(); // Input enter
		System.out.print("scanner.nextLine() test : ");
		str2 = sc.nextLine(); // input the string2
		
		// Output test 1
		System.out.println("scanner.next() output : " + str1);
		System.out.println("scanner.nextLine() output : " + str2);
		
		// Define variables 2
		int num;
		String str3=null;
		
		System.out.println("initialization test for str3 : " + str3); // initial value = null
		
		// Input test 2
		System.out.print("input integer  : ");
		num = sc.nextInt(); // Do not use Space, and Input integer
		System.out.print("scanner.nextLine() test : ");
		str3 = sc.nextLine(); // input 'enter' to str3
		
		// Output test 2
		System.out.println("integer : " + num);
		System.out.println("scanner.nextLine() output : " + str3); // change null to 'enter'
		sc.close();
	}
}
