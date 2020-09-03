package java09032020;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		// Define variables
		int length;
		Scanner sc=  new Scanner(System.in);
		
		// Input Process
		System.out.print("정사각형 한 변의 길이를 입력하세요 (cm) : ");
		length = sc.nextInt();
		
		// Calc
		System.out.println("정사각형의 넓이는 " + length*length + " 제곱센티입니다.");
		sc.close();
	}

}
