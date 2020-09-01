package java09012020;

import java.util.Scanner;

/*
 * 사용자가 100이상의 숫자를 입력할 때 까지 계속해서 입력받는 코드를 작성하시오. 
 * 출력 예문은 아래의 그림을 참조 하시오.
 */
public class WhileProblem2 {
	public static void main(String[] args) {
		// Define variables
		int input;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("100 이상의 정수를 입력하세요 : ");
		input = sc.nextInt();
		while(input<100) {
			System.out.print("100 이상의 정수를 입력하세요 : ");
			input = sc.nextInt();
		}
		
		// Output
		System.out.println(input + " → " + "100이상 정상 입력 완료~!!!");
		sc.close();
	}
}
