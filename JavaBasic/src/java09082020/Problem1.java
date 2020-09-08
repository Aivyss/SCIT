package java09082020;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		//Define variables
		int[] intArry = new int[10];
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<intArry.length; i++) {
			System.out.print((i+1) + "번째 데이터 =>");
			intArry[i]=sc.nextInt();
		}
		System.out.println("****입력된 데이터 목록");
		for (int i=0; i<intArry.length; i++) {
			System.out.println(intArry[i]);
		}
		sc.close();
	}
}
