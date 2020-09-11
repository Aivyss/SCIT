# Average Problem

## Problem

대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

## Input

첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

## Output

각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.

## Example Input 1

```
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

```

## Example Output 1

```
40.000%
57.143%
33.333%
66.667%
55.556%
```

# Code

```java
package java09012020;

import java.util.Scanner;

public class AverageProblem {
	public static void main (String[] args) {
		// Define variables
		int caseNumber;
		Scanner sc = new Scanner(System.in);
		
		// Input and Define Array
		caseNumber = sc.nextInt();
		int[] sum = new int[caseNumber];
		int[] count = new int[caseNumber];
		int[] studentNumber = new int[caseNumber];
		
		for(int i = 0; i<caseNumber; i++) {
			studentNumber[i] = sc.nextInt();
			int[] student = new int[studentNumber[i]];
			
			for (int j=0; j<studentNumber[i]; j++) {
				student[j]=sc.nextInt();
				sum[i]+=student[j];
				if (j==studentNumber[i]-1) {
					for (int k=0; k<studentNumber[i]; k++) {
						if (student[k]>sum[i]/studentNumber[i])
						count[i]+=1;
					}
				}
			}
		}
		
		// Output
		for (int i = 0; i<caseNumber; i++) {
			System.out.println((100.0*count[i])/(1.0*studentNumber[i])+"%");
		}
		sc.close();
	}
}
```