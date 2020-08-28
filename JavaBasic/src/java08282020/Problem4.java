package java08282020;

import java.util.Scanner;

public class Problem4 {
	public static void main(String[] args) {
		// Define variables
		int i, j, k;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("값을 차례대로 입력하시오.");
		i = sc.nextInt();
		j = sc.nextInt();
		k = sc.nextInt();
		
		// Output Process
		if (k==1)
			System.out.println(i+j); 
		else if (k==2)
			System.out.println(i-j);
		else if (k==3)
			System.out.println(i*j);
		else if (k==4)
			System.out.println(1.0*i/j);	
		
		sc.close();
	}
}
