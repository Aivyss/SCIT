package java09072020;

import java.util.Scanner;

public class BakjunProblem2 {

	public static void main(String[] args) {
		// Define variables 1
		int number;
		int max = 0;
		double avg1 = 0.0;
		double avg2 = 0.0;
		Scanner sc = new Scanner(System.in);
		
		// Input Process 1
		number = sc.nextInt();
		
		// Define variables 2
		int[] score = new int[number];
		
		// Input Process 2
		for (int i=0; i<score.length; i++) {
			score[i] = sc.nextInt();
		}
		
		// Search max value
		for (int i=0; i<score.length; i++) {
			if(max < score[i]) {
				max = score[i];
			}
		}
		
		// Calculate average values
		for (int i=0; i<score.length; i++) {
			avg1 += score[i];
			avg2 += 100.0*score[i]/max;

		}
		avg1 /= score.length;
		avg2 /= score.length;
		
		// Output
		System.out.println(avg1);
		System.out.println(avg2);
		
		sc.close();
	}
}
