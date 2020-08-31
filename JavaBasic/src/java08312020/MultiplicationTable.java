package java08312020;

import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) { // Java main method
		//Define variables
		int initial = 0;
		int finish = 0;
		Scanner sc = new Scanner(System.in);
		
		// Input values
		System.out.print("Input initial value = ");
		initial = sc.nextInt();
		System.out.print("Input final value = ");
		finish = sc.nextInt();
		
		// Output
		mult(initial, finish);
	}
	
	// Multiplication method
	public static void mult(int i, int j) {
		for (int l = i; l <= j; l++) {
			for (int k = 1; k <= 9; k++) {
				System.out.println(l + " x " + k + " = " + l*k);
			}
			System.out.println("===============");
		}
	}
}