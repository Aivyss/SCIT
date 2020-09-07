/*
 * https://www.acmicpc.net/problem/2577
 * 세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * 예를 들어 A = 150, B = 266, C = 427 이라면 
 * A × B × C = 150 × 266 × 427 = 17037300 이 되고, 
 * 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 */
package java09072020;

import java.util.Scanner;

public class BakjunProblem1 {
	public static void main(String[] args) {
		// Define variables
		int[] arry = new int[10];
		int input = 0;
		int multiple = 1;
		int test;
		Scanner sc = new Scanner(System.in);

		// Input variables and calculation
		for (int i = 0; i < 3; i++) {
			input = sc.nextInt();
			multiple *= input;
			input = multiple; // return origin value
		}

		// Counting
		while (multiple != 0) {
			test = multiple / 10;
			
			for (int i=0; i<arry.length; i++) {
				if (i == multiple - 10 * test) {
					arry[i]++;
				}
			}
			multiple = test;
		}
		
		System.out.println("=========");
		System.out.println(input);
		for (int i=0; i<arry.length; i++) {
			System.out.println(arry[i]);
		}
		
		sc.close();
	}
}
