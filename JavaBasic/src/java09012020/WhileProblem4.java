/*
 * 사용자로부터 두 개의 정수를 입력받아서 
 * 1부터 첫 번째 입력받은 수 까지의 합을 구한다. 
 * 단, 두 번째 입력받은 수의 배수를 제외한 합을 구하며 
 * 첫 번째 입력받은 수가 음수이거나 두 번째 입력받은 수가 첫 번째 입력받은 수보다 클경우, 
 * "잘못 입력하셨습니다" 메시지 출력 후, 프로그램을 종료한다.
 */
package java09012020;

import java.util.Scanner;

public class WhileProblem4 {
	public static void main(String[] args) {
		// Define variables
		int input1 = 1;
		int input2 = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
			
		// Input Process --> Exit or Calculation
		while (input1>0 && input2<=input1) {
			// Input
			System.out.print("두 정수의 값을 차례대로 기입하시오 : ");
			input1 = sc.nextInt();
			input2 = sc.nextInt();	
			
			// Calculation
			for (int i=1; i<=input1; i++) {
				if (i%input2==0) {}
				else {
					sum+=i;
				}
			}
			// Output and Initialization
			System.out.println("sum = " + sum);
			sum = 0;
		}
		
		if (input1<0 || input2>input1) {
			System.out.println("잘못 입력하셨습니다.");
			System.exit(0);
		} else {
			System.out.println("어차피 끝은 없는거야...");
		}
		
		sc.close();
	}
}
