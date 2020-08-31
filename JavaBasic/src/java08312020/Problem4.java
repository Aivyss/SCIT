package java08312020;

import java.util.Scanner;

public class Problem4 {
	public static void main(String[] args) {
		// Define variables
		int month;
		Scanner sc = new Scanner(System.in);
		
		// Input
		System.out.print("월을 입력하세요 : ");
		month = sc.nextInt();
		
		// Process
		if (month == 4 ||month == 6 ||month == 9 ||month == 11 )
			System.out.println("30일까지 있습니다.");
		else if (month == 2)
			System.out.println("28일까지 있습니다.");
		else
			System.out.println("31일까지 있습니다.");
		
		sc.close();
	}
}
