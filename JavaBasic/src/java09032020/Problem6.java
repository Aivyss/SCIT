package java09032020;

import java.util.Scanner;

public class Problem6 {
	public static void main(String[] args) {
		// Define variables
		int price;
		int fiveman, oneman, fivesen, onesen, residue; 
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("상품가격을 입력하세요 : ");
		price = sc.nextInt();
		
		// Calc
		fiveman = price/50000;
		oneman = (price%50000)/10000;
		fivesen = ((price%50000)%10000)/5000;
		onesen = (((price%50000)%10000)%5000)/1000;
		residue = (((price%50000)%10000)%5000)%1000;
		
		// Output
		System.out.println(price + "원은 5만원권" + fiveman + "장, " + oneman + "장, " + fivesen + "장, " + onesen + "장, " + residue + "원입니다.");
		sc.close();
	}

}
