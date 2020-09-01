/*
 * 사용자로부터 여러 개의 정수를 입력받아 그 합을 계산하여 
 * 결과를 출력해주는 코드를 작성하시오. 단, 사용자가 『-1』을 입력 시 입력받는 
 * 행위를 중지하고 그 동안 입력받아둔 정수들의 합을 출력할 수 있도록 한다. 
 * 출력 예문은 아래의 그림을 참조하시오.
 */
package java09012020;

import java.util.Scanner;

public class WhileProblem3 {

	public static void main(String[] args) {
		// Define variables
		int input=0;
		int sum=0;
		int count = 1;
		Scanner sc = new Scanner(System.in);
		
		//Input Process
		while (true) {
			System.out.print(count+"번째 정수 입력(-1 종료) : ");
			input = sc.nextInt();
			if (input != -1) {
				sum+=input;
				count++;
			} else {
				break;
			}		
		}
		
		// Output Process
		System.out.println(">>현재까지 입력된 정수의 합: " + sum);
		sc.close();
	}
}
