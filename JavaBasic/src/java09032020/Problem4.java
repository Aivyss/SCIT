package java09032020;

import java.util.Scanner;

public class Problem4 {
	public static void main(String[] args) {
		// Define variables
		int length1;
		double length2;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("길이 입력 (cm단위) : ");
		length1 = sc.nextInt();
		
		// Calc
		length2 = length1/2.54;
		
		// Output
		System.out.println(length1+ " cm = " + length2 + " inch");
		sc.close();
	}

}
