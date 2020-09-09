package java09092020;

import java.util.Scanner;

public class Problem4 {
	public static void main(String[] args) {
		// Define variables
		int number = 5;
		int[] arry = new int[number];
		Scanner sc = new Scanner(System.in);
		double avg = 0;
		
		// Input Process
		for (int i=0; i<arry.length; i++) {
			System.out.print((i+1) + "번째 학생의 점수 : ");
			arry[i] = sc.nextInt();
			avg += arry[i];
		}
		avg /=number;
		
		// Output
		System.out.println();
		System.out.println("평균 점수 : " + avg);
		for (int i=0; i<arry.length; i++) {
			if (arry[i]>=avg) {
				System.out.println((i+1) + "번째 학생의 점수 : " + arry[i]);
			}
		}
	}

}
