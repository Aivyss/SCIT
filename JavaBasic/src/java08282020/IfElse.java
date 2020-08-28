package java08282020;

import java.util.Scanner;

public class IfElse {
	public static void main(String[] args) {
		// Define variables
		int score;
		Scanner sc = new Scanner(System.in);
		
		// Input value
		System.out.print("Input your score (integer type): ");
		score = sc.nextInt();
		
		// Processing 1
		if (score >=70)
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		// Processing 2
		if (score >= 95)
			System.out.println("A");
		else if (score >=90)
			System.out.println("B");
		else if (score >= 80)
			System.out.println("C");
		else
			System.out.println("D");
	}

}
