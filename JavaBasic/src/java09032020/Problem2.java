package java09032020;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		// Define variables
		int length1, length2;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("사각형의 세로 길이를 입력 : ");
		length1 = sc.nextInt();
		System.out.print("사각형의 가로 길이를 입력 : ");
		length2 = sc.nextInt();
		
		// Calc
		System.out.println("사각형의 넓이는 " + length1*length2+"제곱센티입니다.");
		sc.close();
	}

}
