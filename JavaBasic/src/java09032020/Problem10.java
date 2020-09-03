package java09032020;

import java.util.Scanner;

public class Problem10 {
	public static void main(String[] args) {
		// Define variables
		int input;
		int hundred, ten, one;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("0~999까지의 정수입력: ");
		input = sc.nextInt();
		
		// Process;
		hundred = input/100;
		ten = (input - hundred*100)/10;
		one = input - (hundred*100 + ten*10);
		
		System.out.println(hundred + ten + one);
		sc.close();
	}

}
