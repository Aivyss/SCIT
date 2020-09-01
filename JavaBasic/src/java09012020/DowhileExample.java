package java09012020;

import java.util.Scanner;
import java.util.Random;

public class DowhileExample {

	public static void main(String[] args) {
		// Define variables
		int select;
		int count=0;
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		// Process
		do {
			System.out.println("0. 종료");
			System.out.println("1. count 1증가");
			System.out.println("2. count 1감소");
			System.out.println("3. count -2~2랜덤증감소");
			System.out.print("입력 >> ");
			select = sc.nextInt();
			
			switch (select) {
				case 0 :
					break;
				case 1 :
					count+=1;
					break;
				case 2 : 
					count-=1;
					break;
				case 3 :
					count+=(rd.nextInt(4)-2);
					break;
				default: 
					System.out.println("잘못 입력했습니다.");
					break;
			}
			
			System.out.println("count = " + count);
		} while(select!=0);
		sc.close();
	}

}
