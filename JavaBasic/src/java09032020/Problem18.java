package java09032020;

import java.util.Scanner;

public class Problem18 {
	public static void main(String[] args) {
		// Define variables
		int num1;
		int num2; 
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("num1 에 대입할 값 : ");
		num1 = sc.nextInt();
		System.out.print("num2 에 대입할 값 : ");
		num2 = sc.nextInt();
		
		// Output1
		System.out.println("---교환 전---");
		System.out.println("num1 의 값 : " + num1);
		System.out.println("num2 의 값 : " + num2);
		
		// Process and Output2
		temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("---교환 후---");
		System.out.println("num1 의 값 : " + num1);
		System.out.println("num2 의 값 : " + num2);
		sc.close();
	}

}
