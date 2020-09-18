package java09142020;

import java.math.BigDecimal;
import java.util.Scanner;

public class Integration {
	public static void main(String[] args) {
		String[] funcinfo = new String[4];

		// input Process
		Scanner sc = new Scanner(System.in);
		System.out.print("Slice size : ");
		funcinfo[0] = sc.nextLine();
		System.out.print("Start Point : ");
		funcinfo[1] = sc.nextLine();
		System.out.print("end Point : ");
		funcinfo[2] = sc.nextLine();
		System.out.print("Select Origin function : ");
		funcinfo[3] = sc.nextLine();

		// Calc process
		BigDecimal output = integCalc(funcinfo);

		// Print
		System.out.println(output.doubleValue());
	}

	public static BigDecimal integCalc(String[] funcinfo) {
		BigDecimal output = new BigDecimal("0");
		BigDecimal dxInput = new BigDecimal(funcinfo[0]);
		BigDecimal initial = new BigDecimal(funcinfo[1]);
		BigDecimal finish = new BigDecimal(funcinfo[2]);

		switch (Integer.parseInt(funcinfo[3])) {
		case 1:
			output = polynomial(dxInput, initial, finish);
			break;
		case 2:
			output = exponential(dxInput, initial, finish);
			break;
		}
		return output;
	}

	public static BigDecimal polynomial(BigDecimal dx, BigDecimal initial, BigDecimal finish) {
		// coefficient input
		Scanner sc = new Scanner(System.in);
		System.out.print("Input coefficinets : ");
		String coeffinput = sc.nextLine();

		// check the coefficients
		String[] coeffiTemp = coeffinput.split("-");
		BigDecimal[] coefficients = new BigDecimal[coeffiTemp.length];
		for (int i = 0; i < coeffiTemp.length; i++) {
			coefficients[i] = new BigDecimal(coeffiTemp[i]);
		}

		// initialization
		BigDecimal[] sum = new BigDecimal[coeffiTemp.length];
		BigDecimal[] ones = new BigDecimal[coeffiTemp.length];
		for (int i = 0; i < coeffiTemp.length; i++) {
			ones[i] = new BigDecimal("1");
			sum[i] = BigDecimal.ZERO;
		}

		// integration
		BigDecimal temp1 = new BigDecimal("1");
		BigDecimal temp2 = initial;
		sum[0] = coefficients[0];
		if (coefficients.length != 1) {
			for (int i = 1; i < coeffiTemp.length; i++) {
				initial = temp2;
				while ((initial.add(dx)).compareTo(finish) == -1) {
					for (int j = 1; j <= i; j++) { // x^n ?��
						temp1 = temp1.multiply(initial);
					}
					sum[i] = sum[i].add(temp1.multiply(dx));
					initial = initial.add(dx);
					temp1 = BigDecimal.ONE;
				} // while end
			} // for end
		}

		// multiply coefficients
		for (int i = 0; i < coeffiTemp.length; i++) {
			sum[i] = sum[i].multiply(coefficients[i]);
		}

		// Total sum
		BigDecimal totalSum = BigDecimal.ZERO;
		for (int i = 0; i < coeffiTemp.length; i++) {
			totalSum = totalSum.add(sum[i]);
		}

		return totalSum;
	}

	public static BigDecimal exponential(BigDecimal dx, BigDecimal initial, BigDecimal finish) {
		// coefficient input
		Scanner sc = new Scanner(System.in);
		System.out.print("Input coefficinets : ");
		String coeffinput = sc.nextLine();

		// check the coefficients
		String[] coeffiTemp = coeffinput.split("-");
		BigDecimal[] coefficients = new BigDecimal[coeffiTemp.length];
		for (int i = 0; i < coeffiTemp.length; i++) {
			coefficients[i] = new BigDecimal(coeffiTemp[i]);
		}

		// integration
		BigDecimal sum = new BigDecimal("0");
		while ((initial.add(dx)).compareTo(finish) == -1) {
			BigDecimal temp3 = new BigDecimal(Double.toString(Math.exp(coefficients[1].doubleValue()*initial.doubleValue())));
			
			sum = sum.add(temp3.multiply(dx));
			
			initial = initial.add(dx);
		}

		// multiply coefficient
		sum = coefficients[0].multiply(sum);
		return sum;
	}
}
