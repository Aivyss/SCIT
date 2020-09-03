package java09032020;

import java.util.Scanner;

public class Problem14 {
	public static void main(String[] args) {
		// Define variables
		int input1, input2;
		int temp;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("첫 번째 정수 입력 : ");
		input1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		input2 = sc.nextInt();
		
		// Check bigger
		if (input1>input2) {
			temp = input1;
			input1 = input2;
			input2 = temp;
		}
		
		// Process
		for (int i=input1; i<=input2; i++) {
			sum += i;
		}
		System.out.println(input1 + " ~ " + input2 + "까지의 합계 : " + sum);
		sc.close();
	}

}
