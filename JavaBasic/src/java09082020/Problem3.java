package java09082020;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		// Define variables 1
		int number;
		double avg = 0;
		Scanner sc = new Scanner(System.in);
		
		// Input value 1
		System.out.print("학급에 몇 명이 있습니까? : ");
		number = sc.nextInt();
		
		// Define variables(Array) 2
		int[] intArry = new int[number];
		
		// Input value 2 to array
		for (int i=0; i<intArry.length; i++) {
			System.out.print((i+1) + "번째 학생의 점수를 입력 해주세요 : ");
			intArry[i] = sc.nextInt();
			avg+= intArry[i];
		}
		avg = avg/number;
		
		// Output
		System.out.println(number + "명의 평균 : " + avg);
		
		sc.close();
	}
}
