package java08282020;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		// Define variables
		int i, j, k;
		double avg;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("세 값을 차례대로 입력하시오 : ");
		i = sc.nextInt();
		j = sc.nextInt();
		k = sc.nextInt();
		
		// Calculation
		avg = (i+j+k)/3.0;
		if (i<40 || j<40 || j<40) {
			System.out.println("과락입니다");
		} else {
			if (avg >= 70) {
				System.out.println("합격입니다.");
			} else {
				System.out.println("불합격입니다.");
			}
		}
		sc.close();
	}
}
