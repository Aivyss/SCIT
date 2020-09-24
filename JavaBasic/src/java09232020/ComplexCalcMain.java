package java09232020;

import java.math.BigDecimal;
import java.util.Scanner;

public class ComplexCalcMain {

	public static void main(String[] args) {
		// Define variables
		int[] arry1 = new int[2];
		int[] arry2 = new int[2];
		
		// Input Process
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<arry1.length; i++) {
			arry1[i] = sc.nextInt();
		}
		for (int i=0; i<arry1.length; i++) {
			arry2[i] = sc.nextInt();
		}
		
		// Change int to BigDecimal
		BigDecimal[] value1 = new BigDecimal[2];
		BigDecimal[] value2 = new BigDecimal[2];
		value1[0] = new BigDecimal(Double.toString(arry1[0]));
		value1[1] = new BigDecimal(Double.toString(arry1[1]));
		value2[0] = new BigDecimal(Double.toString(arry2[0]));
		value2[1] = new BigDecimal(Double.toString(arry2[1]));
		
		BigDecimal[] output = ComplexCalc.log(value1, value2);
		System.out.println(output[0].doubleValue());
		System.out.println(output[1].doubleValue());
		sc.close();
		
	}

}
