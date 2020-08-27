package java08272020;

import java.util.Scanner;

public class Times3 {
	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력하세요");
		input = sc.nextInt();
		
		System.out.println(input%3==0);
		sc.close();
	}

}
