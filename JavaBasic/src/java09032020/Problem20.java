package java09032020;

import java.util.Scanner;

public class Problem20 {

	public static void main(String[] args) {
		// Define variable
		int year;
		int choice;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("태어난 해를 입력하세요 : ");
		year = sc.nextInt();
		
		// Process
		choice = year%12;
		switch(choice) {
		case 0: 
			System.out.println(year + "년생은 원숭이띠입니다.");
			break;
		case 1: 
			System.out.println(year + "년생은 닭띠입니다.");
			break;
		case 2: 
			System.out.println(year + "년생은 개띠입니다.");
			break;
		case 3: 
			System.out.println(year + "년생은 돼지띠입니다.");
			break;
		case 4: 
			System.out.println(year + "년생은 쥐띠입니다.");
			break;
		case 5: 
			System.out.println(year + "년생은 소띠입니다.");
			break;
		case 6: 
			System.out.println(year + "년생은 호랑이띠입니다.");
			break;
		case 7: 
			System.out.println(year + "년생은 토끼띠입니다.");
			break;
		case 8: 
			System.out.println(year + "년생은 용띠입니다.");
			break;
		case 9: 
			System.out.println(year + "년생은 뱀띠입니다.");
			break;
		case 10: 
			System.out.println(year + "년생은 말띠입니다.");
			break;
		case 11: 
			System.out.println(year + "년생은 양띠입니다.");
			break;
		}
		sc.close();
	}
}
