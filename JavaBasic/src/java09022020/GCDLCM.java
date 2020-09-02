package java09022020;

import java.util.Scanner;

public class GCDLCM {
	public static void main(String[] args) {
		// Define variables
		int input1, input2;
		int gcd;
		int lcm;
		Scanner sc =  new Scanner(System.in);
		
		// Input Process
		input1 = sc.nextInt();
		input2 = sc.nextInt();
		
		// GCD
		gcd = gCD(input1, input2);
		lcm = lCM(input1, input2);
		
		// Print
		System.out.println(gcd);
		System.out.println(lcm);
		
		sc.close();
	}
	
	// Greatest Common Divisor
	public static int gCD(int input1,int input2) {
		int gcd=0;
		int incrementRange;
		
		if (input1<input2)
			incrementRange = input1;
		else
			incrementRange = input2;
		
		for (int i=1; i<=incrementRange; i++) {
			if ((input1%i==0) && (input2%i==0))
				gcd = i;
		}
		
		return gcd;
	}
	
	// Least Common Multiple
	public static int lCM(int input1, int input2) {
		int lCM = 0;
		if (input1<input2) {
			for (int i=input1*input2; i>=input2; i--) {
				if ((i%input1==0) && (i%input2==0)) {
					lCM = i;
				}
			}
		} else {
			for (int i=input1*input2; i>=input1; i--) {
				if ((i%input1==0) && (i%input2==0)) {
					lCM = i;
				}
			}
		}
		return lCM;
	}
}
