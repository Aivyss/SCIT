/*
 * 번호를 입력받아서 좋아하는 음식을 골라서 출력하는 코드를 작성 하시오. 
 * 1.민트초코 , 2.홍어 , 3.실론티 , 4. 하와이안 피자 5. 솔의눈(3또는 4를 입력할 경우, "실론티 또는 하와이안 피자" 라는 텍스트를 출력)

 */
package java08312020;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		// Define variables
		int choose;
		Scanner sc = new Scanner(System.in);
		
		// Input
		System.out.print("번호를 입력하세요 : ");
		choose = sc.nextInt();
		
		// Process
		switch (choose) {
		case 1 : 
			System.out.println("1. 민트초코");
			break;
		case 2 : 
			System.out.println("2. 홍어");
			break;
		case 3 : case 4:
			System.out.println("3. 실론티"); 
			System.out.println("4. 하와이안 피자");
		case 5 : 
			System.out.println("5. 솔의 눈");
			break;
		}
		sc.close();
	}
}
