/*
 * Farhrenheit to Celcious (Round 3)
 */
package java08272020;

import java.util.Scanner;

public class CelciousFahrenheit {

	public static void main(String[] args) {
		// Define variables
		double celc;
		double fah;
		Scanner sc = new Scanner(System.in);
		
		// Input 
		System.out.print("화씨 온도 값을 입력하세요.");
		fah = sc.nextDouble();
		
		// Calculation
		celc = calc(fah);
		celc = ((int)celc) + round3(calc(fah));
		
		// Output
		System.out.println(celc);
		
		// Close
		sc.close();
	}
	
	// Calculation method
	public static double calc(double fah) {
		double celc;
		celc = (fah-32)*(5.0/9);
		
		return celc;
	}
	
	// Round function
	public static double round3(double number) {
		// Define variables
		double num1, num2, num3;
		
		// Process
		number = number - (int)number;
		num1 = (int)(number*10);
		num2 = (int)(number*100) - num1*10;
		num3 = (int)(number*1000)- num1*100 - num2*10;
		
		if (num3>=5)
			number = num1/10.0 + (1+num2)/100.0;
		else
			number = num1/10.0 + num2/100.0;
		
		// Return
		return number;
	}
}
