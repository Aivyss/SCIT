/*
 * 사용자로부터 원하는 단(구구단)을 입력받아 
 * 해당하는 구구단을 출력하는 코드를 while문을 사용하여 작성하시오. 
 * 단, 1단 ~ 9단 사이의 수를 입력받은 것이 아니라면 
 * "1부터 9까지의 정수만 입력 가능합니다"를 출력하시오.
 */
package java09012020;

import java.util.Scanner;

public class WhileProblem1 {
	public static void main(String[] args) {
		// Define variables
		int input;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("원하는 단의 값을 입력하세요 : ");
		input = sc.nextInt();
		while(input<1 || input>9) {
			System.out.println("1부터 9까지의 정수만 입력 가능합니다.");
			System.out.print("원하는 단의 값을 입력하세요 : ");
			input = sc.nextInt();
		}
		
		// Multiplication Process and Output
		for (int i=1; i<=9; i++) {
			System.out.println(input + "*" + i + " = " + input*i);
		}
		sc.close();
	}
}
