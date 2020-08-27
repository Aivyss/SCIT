/*
 * Type Casting examples
 * Average calculation
 */
package java08272020;

import java.util.Scanner;

public class AverageOutput {
	public static void main(String[] args) {
		// Define variables
		int i, j, k;
		double avg;
		Scanner keyin = new Scanner(System.in);
		
		// Process
		System.out.print("값을 순서대로 3개 입력하세요");
		i = keyin.nextInt();
		j = keyin.nextInt();
		k = keyin.nextInt();
		avg = (i+j+k)/3.0;
		
		//Output
		System.out.println("average = " + avg);
		System.out.println(avg>80);
		keyin.close();
	}

}
