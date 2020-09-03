package java09032020;

import java.util.Scanner;

public class Problem8 {
	public static void main(String[] args) {
		// Define variables
		int nihongo, it, shutseki;
		double total;
		boolean pass = false;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("출결 점수 : ");
		shutseki = sc.nextInt();
		System.out.print("IT 점수 : ");		
		it = sc.nextInt();
		System.out.print("일본어 점수 : ");
		nihongo = sc.nextInt();
		
		// Calc
		total = shutseki*0.4 + it*0.3 + nihongo*0.3;
		
		// Check the pass / fail
		if (total >= 70)
			pass = true;
		else 
			pass = false;
		
		// Output
		System.out.println("총점 : " + total + " 수료여부 : " + pass);
		sc.close();
	}

}
