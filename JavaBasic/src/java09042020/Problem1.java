/*
 * Harshad Number Problem
 * 12 -> 1 + 3, 12%3==0 (true)
 * 11 -> 1 + 1, 11%2==0 (false)
 */
package java09042020;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		// Define variables
		int input;
		int test1, test2;
		int range = 1;
		int sum = 0;
		boolean tf = false;
		Scanner sc = new Scanner(System.in);

		// Input Process
		System.out.print("하샤드 수인지 판별할 값을 입력해 주세요 : ");
		input = sc.nextInt();
		test1 = input;

		// Check range
		while (test1 > 0) {
			if (range == 1) {
				test1 = input - 9;
				range = 10;
			} else {
				range *= 10;
				test1 = input - (range - 1);
			}
		}
		range = range / 10;
		test2 = input;

		// Calculation 1
		for (int i = range; i >= 1; i /= 10) {
			test1 = input / i;
			sum += test1;
			input = input - test1 * i;
		}

		// Check the Hashad 2
		if (test2 % sum == 0) {
			tf = true;
			System.out.println("하샤드 수 판별: " + tf);
		} else {
			tf = false;
			System.out.println("하샤드 수 판별: " + tf);
		}
		
		System.out.println(sum);
		sc.close();
	}
}
