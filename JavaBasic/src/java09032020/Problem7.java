package java09032020;

import java.util.Scanner;

public class Problem7 {
	public static void main(String[] args) {
		// Define variables
		int input1;
		int input2;
		Scanner sc= new Scanner(System.in);
		
		// Input Process
		System.out.print("제품의 가격을 입력 : ");
		input1 = sc.nextInt();
		System.out.print("제품의 구매가를 입력 : ");
		input2 = sc.nextInt();
		
		// Calc
		System.out.println("할인율 : " + 100.0*(input1-input2)/input1 + "%");
		sc.close();
	}

}
