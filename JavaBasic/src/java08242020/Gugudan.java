package java08242020;

import java.util.Scanner;

public class Gugudan {
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
		gugudan(initial, finish);
	}
	
	// Gugudan method
	public static void gugudan(int i, int j) {
		for (int l = i; l <= j; l++) {
			for (int k = 1; k <= 9; k++) {
				System.out.println(l + " x " + k + " = " + l*k);
			}
			System.out.println("===============");
		}
	}
}