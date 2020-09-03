package java09032020;

import java.util.Scanner;

public class Problem17 {
	public static void main(String[] args) {
		// Define variables
		int won;
		int choice;
		double change;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("원 단위 금액 입력 : ");
		won = sc.nextInt();
		
		// Process
		System.out.print("환전할 화폐 (1:달러, 2:엔화, 3:유로화) : ");
		choice = sc.nextInt();
		
		if (won <= 0) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			switch(choice) {
			case 1: 
				change = won*(0.82/1000);
				System.out.println(won + "원은 " + change + "달러입니다.");
				break;
			case 2:
				change = won*(88.24/1000);
				System.out.println(won + "원은 " + change + "엔입니다.");
				break;
			case 3 :
				change = won*(0.78/1000);
				System.out.println(won + "원은 " + change + "유로입니다.");
				break;
			}
		}
		sc.close();
	}
}
