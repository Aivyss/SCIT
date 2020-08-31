/*
 * 태어난 해를 입력 받아서 (ex : 1996) 성인인지 
 * 청소년인지를 판단하는 코드를 작성 하시오. 
 * 만약 입력한 숫자가 음수 이거나 2020보다 큰 숫자 일 경우에는 
 * "잘못입력하셨습니다"를 출력하고 그 외의 경우에 20살 미만인 
 * 경우에는 "청소년 입니다.", 20살 이상인 경우에는 "성인 입니다."를 출력하시오.
 * (2001년이 성인)
 */

package java08312020;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		// Define variables
		int year;
		Scanner sc = new Scanner(System.in);
		
		// Input process
		System.out.print("출생년도를 입력하세요 : ");
		year = sc.nextInt();
		
		// Process
		if (year > 2020)
			System.out.println("잘못 입력하셨습니다 다시 입력하세요.");
		else if (year > 2001)
			System.out.println("청소년입니다.");
		else
			System.out.println("성인입니다.");
		
		sc.close();
	}
}
