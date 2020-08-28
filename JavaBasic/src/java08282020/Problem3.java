package java08282020;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		// Define variables
		int input;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("값을 입력하시오 : ");
		input = sc.nextInt();
		
		// Output Process
		if (input%3 == 0)
			System.out.println("3의 배수입니다.");
		else
			System.out.println("3의 배수가 아닙니다.");
		
		sc.close();
	}

}
