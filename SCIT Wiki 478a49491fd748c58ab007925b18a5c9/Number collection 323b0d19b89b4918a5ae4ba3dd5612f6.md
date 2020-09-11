# Number collection

## Problem

세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.

예를 들어 A = 150, B = 266, C = 427 이라면

A × B × C = 150 × 266 × 427 = 17037300 이 되고,

계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.

## Input

첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 같거나 크고, 1,000보다 작은 자연수이다.

## Output

첫째 줄에는 A×B×C의 결과에 0 이 몇 번 쓰였는지 출력한다. 마찬가지로 둘째 줄부터 열 번째 줄까지 A×B×C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.

## Example Input 1

```
150
266
427

```

## Example Output 1

```
3
1
0
2
0
0
0
2
0
0
```

# Code (solve)

```java
/*
 * https://www.acmicpc.net/problem/2577
 * 세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * 예를 들어 A = 150, B = 266, C = 427 이라면 
 * A × B × C = 150 × 266 × 427 = 17037300 이 되고, 
 * 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 */
package java09072020;

import java.util.Scanner;

public class BakjunProblem1 {
	public static void main(String[] args) {
		// Define variables
		int[] arry = new int[10];
		int input = 0;
		int multiple = 1;
		int test;
		Scanner sc = new Scanner(System.in);

		// Input variables and calculation
		for (int i = 0; i < 3; i++) {
			input = sc.nextInt();
			multiple *= input;
			input = multiple; // return origin value
		}

		// Counting
		while (multiple != 0) {
			test = multiple / 10;
			
			for (int i=0; i<arry.length; i++) {
				if (i == multiple - 10 * test) {
					arry[i]++;
				}
			}
			multiple = test;
		}
		
		System.out.println("=========");
		System.out.println(input);
		for (int i=0; i<arry.length; i++) {
			System.out.println(arry[i]);
		}
		
		sc.close();
	}
}
```