package java08312020;

import java.util.Scanner;

public class Problem8 {

	public static void main(String[] args) {
		// Define variables
		int i,j;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("두 값을 차례대로 입력: ");
		i = sc.nextInt();
		j = sc.nextInt();
		
		// Process
		if (j<i) 
			System.out.println("Wrong values");
		else {
			for (int k=i; k<=j; k++) {
				if (k%2!=0)
					sum = sum + k;
			}
			
			// Output
			System.out.println(sum);
		}
		
		sc.close();
	}
}
