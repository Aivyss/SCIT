/*
 * Decide Odd or Even
 * Ternary Operator example
 */
package java08272020;

import java.util.Scanner;

public class EvenOdd {
	public static void main(String[] args) {
		// Define Variables
		int input;
		char t1;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("값을 입력하세요.");
		input = sc.nextInt();
		
		// Process
		t1 = (input%2==0) ? '짝':'홀';
		System.out.println(t1);
		sc.close();
		}
}