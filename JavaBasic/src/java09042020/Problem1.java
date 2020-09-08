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
		int test;
		int range = 1;
		int sum = 0;
		boolean tf = false;
		Scanner sc = new Scanner(System.in);

		// Input Process
		System.out.print("하샤드 수인지 판별할 값을 입력해 주세요 : ");
		input = sc.nextInt();
		test = input;

		// Check range
		while (test > 0) {
			if (range == 1) {
				test = input - 9;
				range = 10;
			} else {
				range *= 10;
				test = input - (range - 1);
			}
		}
		range = range / 10;
		test = input;

		// Calculation
		for (int i = range; i >= 1; i /= 10) {
			int temp = test;
			temp = temp / i;
			sum += temp;
			test = test - temp * i;
		}

		// Check the Harshad Number
		if (input % sum == 0) {
			tf = true;
		} else {
			tf = false;
		}
		System.out.println("하샤드 수 판별: " + tf);
		sc.close();
	}
}
