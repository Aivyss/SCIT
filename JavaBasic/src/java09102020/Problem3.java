package java09102020;

import java.util.Random;
import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		// Define variables
		int solution;
		int input;
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		solution = rd.nextInt(50)+1;
		System.out.println("1~50사이의 랜덤한 숫자가 생성되었습니다.");
		
		// Guess Process
		while(true) {
			System.out.print("숫자를 맞춰보세요 : ");
			input = sc.nextInt();
			
			if (solution > input) {
				System.out.println("Up");
			} else if (solution < input) {
				System.out.println("Down");
			} else {
				System.out.println("Good");
				break;
			}
		}
	}
}
