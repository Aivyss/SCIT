package java09032020;

import java.util.Scanner;

public class Problem21 {
	public static void main(String[] args) {
		// Define variables
		int input = 1;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		// Input process
		while(input !=0) {
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			if (input%3==0) {
				count++;
			}
		}
		System.out.println("3의 배수 개수 : " + (count-1));
		sc.close();
	}
}
