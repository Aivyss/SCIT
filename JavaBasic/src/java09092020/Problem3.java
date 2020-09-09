package java09092020;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		// Define variables
		int[] arry = new int[5];
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		double avg;
		
		// Input Process
		for (int i=0; i<arry.length; i++) {
			arry[i] = sc.nextInt();
			sum += arry[i];
		}
		
		// Calculation
		avg = 1.0*sum / arry.length;
		
		// Output
		System.out.println(sum);
		System.out.println(avg);
	}

}
