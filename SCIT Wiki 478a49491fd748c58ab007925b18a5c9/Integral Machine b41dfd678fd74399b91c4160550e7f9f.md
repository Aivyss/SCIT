# Integral Machine

## Source code

[https://github.com/Aivyss/SCIT/tree/master/ToyProject/src/integral](https://github.com/Aivyss/SCIT/tree/master/ToyProject/src/integral)

![Integral%20Machine%20b41dfd678fd74399b91c4160550e7f9f/Untitled.png](Integral%20Machine%20b41dfd678fd74399b91c4160550e7f9f/Untitled.png)

## 요구조건

- 구회의 크기를 결정짓는 dx 변수를 사용자로부터 받는다. (작을 수록 정적분 게산값의 정확도가 높아짐)
- 일반적인 다항식 함수와 지수함수를 구현 (추후 함수 추가하여 확장 가능)하고 사용자가 선택할 수 있도록 한다.
- 일반적인 함수에 대해서 정적분 값을 구하려 하므로 당연히 계수값을 사용자로부터  받는다.
- 정적분 값을 구하기 위해서 범위를 결정 짓는 시작점과 끝점을 사용자로부터 받는다.
- 결과값의 정확도를 위하여 BigDecimal 객체를 이용한다

## Code

```java
package integral;

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
					for (int j = 1; j <= i; j++) { // x^n ?占쏙옙
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
```