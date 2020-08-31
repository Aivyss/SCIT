package java08312020;

import java.util.Scanner;

public class Problem6 {

	public static void main(String[] args) {
		// Define variables
		int input;
		int output = 1;
		Scanner sc = new Scanner(System.in);
		
		// Input
		System.out.print("정수 값을 입력하시오 (팩토리얼): ");
		input = sc.nextInt();
		
		// Process
		for (int i=input; i>0; --i) {
			output = output*i;
		}
		
		// Output
		System.out.println(output);
		
		sc.close();
	}

}
