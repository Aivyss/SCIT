/*
 * 정수형 점수를 입력받아서 학점을 구하는 코드를 작성하시오. 
 * 단, 점수가 0점보다 작거나 100점보다 클 경우에는 "잘못된 입력입니다"를 출력하고 
 * 90이상 100이하는 A. 80이상 90미만은 B, 70이상 80미만은 C, 
 * 나머지는 D를 출력하시오
 */
package java08312020;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		// Define variables
		int score;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("점수(정수형)으로 입력하세요 : ");
		score = sc.nextInt();
		
		// Process and Output
		if (score < 0 || score > 100) 
			System.out.println("잘못된 입력입니다.");
		else if (score >= 90) 
			System.out.println("A");
		else if (score >= 80) 
			System.out.println("B");
		else if (score >= 70) 
			System.out.println("C");
		else
			System.out.println("D");
		
		sc.close();
	}
}
