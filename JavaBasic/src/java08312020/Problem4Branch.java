package java08312020;

import java.util.Scanner;

public class Problem4Branch {
	public static void main(String[] args) {
		// Define variables
		int month;
		Scanner sc = new Scanner(System.in);
		
		// Input
		System.out.print("월을 입력하세요 : ");
		month = sc.nextInt();
		
		// Process
		switch (month) {
			case 4: case 6: case 9: case 11:
				System.out.println("30일까지 있습니다.");
			case 2: 
				System.out.println("28일까지 있습니다.");
			default : 
				System.out.println("31일까지 있습니다.");
		}
		
		sc.close();
	}
}

