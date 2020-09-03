package java09032020;

import java.util.Scanner;

public class Problem9 {
	public static void main(String[] args) {
		// Define variables
		int input;
		boolean even, odd;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("숫자 입력 : ");
		input = sc.nextInt();
		
		// Calc
		if (input%2 == 0) {
			even = true;
			odd  = !(even);
		} else {
			even = false;
			odd = !(even);
		}
		
		// Output
		System.out.println("짝수 여부 : " + even);
		System.out.println("홀수 여부 : " + odd);
		sc.close();
	}

}
