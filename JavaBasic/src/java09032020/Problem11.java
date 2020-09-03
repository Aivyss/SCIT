package java09032020;

import java.util.Scanner;

public class Problem11 {
	public static void main(String[] args) {
		// Define variable
		int input;
		char grade;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("점수 입력 : ");
		input = sc.nextInt();
		
		// Process
		if (input>=90)
			grade = 'A';
		else if (input>=80)
			grade = 'B';
		else if (input>=70)
			grade = 'C';
		else if (input>=60)
			grade = 'D';
		else
			grade = 'F';
		
		// Output
		System.out.println(grade + "입니다.");
		sc.close();
	}

}
