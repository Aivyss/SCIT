package java08282020;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		// Define variables
		int input;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("값을 입력하세요.");
		input = sc.nextInt();
		
		// Process
		if (input >= 50)
			System.out.println("50 이상입니다.");
		else
			System.out.println("50 미만입니다.");
		
		sc.close();
	}
	

}
