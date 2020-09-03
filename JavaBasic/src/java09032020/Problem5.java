package java09032020;

import java.util.Scanner;

public class Problem5 {
	public static void main(String[] args) {
		// Define variables
		int input;
		int second;
		int minute;
		int hour;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("시간을 초 단위로 입력하세요 : ");
		input = sc.nextInt();
		
		// Calc
		hour = input/3600;
		minute = (input%3600)/60; 
		second = (input%3600)%60;
		
		// Output
		System.out.println(input + "초는 " + hour + "시간" + minute + "분" + second + "초입니다.");
		sc.close();
	}

}
