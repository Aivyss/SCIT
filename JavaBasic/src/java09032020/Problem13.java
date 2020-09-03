package java09032020;

import java.util.Scanner;

public class Problem13 {
	public static void main(String[] args) {
		// Define variables
		int input;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("정수 입력 : ");
		input = sc.nextInt();
		
		// Calc
		int[] arry2 = div(input);
		
		// Output
		for (int i=0; i<arry2.length; i++) {
			System.out.println(arry2[i]);
		}
		sc.close();
	}
	
	public static int[] div(int input) {
		// Define array
		int[] arry = new int[input];
		int count = 0;
		// Process
		for (int i=1; i<=input; i++) {
			if (input%i == 0) {
				arry[i-1] = i;
				count++;
			} 
		}
		//Define array2
		int[] arry2 = new int[count];
		int j = 0;
		// Select
		for (int i=0; i<input; i++) {
			if (arry[i] != 0) {
				arry2[j] = arry[i];
				j++;
			}
		}
		return arry2; 
	}
}
