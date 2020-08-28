/*
 * Switch Basic
 * 
 * switch(조건값) {
 * 		case 값1: 문장1
 * 			break;
 * 		case 값2: 문장2
 * 			break;
 * 		case 값3: 문장3
 * 			break;
 * 		....
 *		default: 문장n
 *			break;
 * }
 * 
 * 값n에 대입가능한 데이터 타입: 숫자, 문자, 문자열 
 */
package java08282020;

import java.util.Scanner;

public class SwitchBasic {
	public static void main(String[] args) {
		// Define variables
		int code;
		Scanner sc = new Scanner(System.in);
		
		// Input values
		System.out.print("분류코드를 입력하시오 : ");
		code = sc.nextInt();
		
		// Process
		switch(code) {
			case 1: 
				System.out.println("Physics");
				break;
			case 2: 
				System.out.println("Chemistry");
				break;
			case 3: 
				System.out.println("Mathematics");
				break;
			case 4: 
				System.out.println("Biology");
				//break;
			case 5:
				System.out.println("no break test");
				break;
			default:
				System.out.println("default");
				break;
		}
		
		sc.close();
	}
}
