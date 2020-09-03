package java09032020;

import java.util.Scanner;

public class Problem12 {
	public static void main(String[] args) {
		// Define variables
		int input1, input2;
		int choice;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("첫 번째 수 입력 : ");
		input1 = sc.nextInt();
		System.out.print("첫 번째 수 입력 : ");
		input2 = sc.nextInt();
		
		
		// Process
		System.out.println("==========");
		System.out.println("1.덧셈");
		System.out.println("2.뺄셈");
		System.out.println("3.곱셈");
		System.out.println("4.나눗셈");
		System.out.println("==========");
		System.out.print("메뉴 선택 : ");
		choice = sc.nextInt();
		
		switch(choice) {
			case 1 :
				System.out.println("덧셈 결과 : " + (input1 + input2));
				break;
			case 2 :
				System.out.println("뺄셈 결과 : " + (input1 - input2));
				break;
			case 3 :
				System.out.println("곱셈 결과 : " + input1 * input2);
				break;
			case 4 :
				System.out.println("나눗셈 결과 : " + 1.0*input1 / input2);
				break;
		}
		sc.close();
	}
}
