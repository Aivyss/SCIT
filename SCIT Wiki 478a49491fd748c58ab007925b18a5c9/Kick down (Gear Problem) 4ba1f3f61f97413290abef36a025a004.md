# Kick down (Gear Problem)

## Source code

[https://github.com/Aivyss/SCIT/blob/master/JavaBasic/src/java09172020/GearProblem.java](https://github.com/Aivyss/SCIT/blob/master/JavaBasic/src/java09172020/GearProblem.java)

## Problem

세계적으로 유명한 엄지민 자동차 회사는 효율적인 킥다운 장치를 만들어달라는 의뢰를 받았다. 킥다운이란 자동차에서 낮은 기어로 바꾸는 장치를 의미한다. 연구 끝에 효율적인 킥다운 장치는 '이'와 '홈'이 불규칙하게 배열되어 있는 기어로 만들어져야 한다는 것을 알았다.

![https://www.acmicpc.net/upload/201003/p1p1p1.JPG](https://www.acmicpc.net/upload/201003/p1p1p1.JPG)

![https://www.acmicpc.net/upload/201003/p2p2p2.JPG](https://www.acmicpc.net/upload/201003/p2p2p2.JPG)

첫 번째 그림과 같이 두 기어 파트가 서로 마주보고 있게 된다. 튀어나온 것이 기어의 이, 들어간 곳이 홈이다. 그리고 이들을 두 번째 그림과 같이 서로 맞물리게 끼우는 것으로 킥다운 장치를 만들 수 있다. 하지만 문제는 맞물리게 하였을 때 가로 너비가 짧을수록 효율적인 킥다운 장치가 된다. 때문에 문제는 두 기어가 주어졌을 때 맞물리게 하는 가장 짧은 가로 너비를 구하는 것이다.

## Input

첫 줄에는 첫 번째 기어 파트를 나타내는 1과 2로 구성된 문자열이 주어진다. 두 번째 줄에는 마찬가지로 두 번째 기어 파트를 나타내는 1, 2로 구성된 문자열이 주어진다. 여기서 1은 홈을, 2는 이를 의미한다. 길이 <= 100

## Output

첫 줄에 만들 수 있는 가장 짧은 가로 너비를 출력한다.

## Example input 1

```
2112112112
2212112

```

## Example output 1

```
10
```

## Code

```java
package java09172020;

import java.util.ArrayList;
import java.util.Scanner;

public class GearProblem {
	public static void main(String[] args) {
		// Input Process
		Scanner sc = new Scanner(System.in);
		String input1;
		String input2;
		input1 = sc.next();
		sc.nextLine();
		input2 = sc.nextLine();

		// Optimization
		String[] splited1 = spliter(input1);
		String[] splited2 = spliter(input2);

		// Measure length Process
		ArrayList<Object> container = measureLength(splited1, splited2);

		// Print
		int[][] set = (int[][]) container.get(1);
		int length = (int) container.get(0);
		for (int i = 0; i < set[0].length; i++) { // test Scan finish view
			System.out.print(set[0][i] + " ");
		}
		System.out.println();
		for (int i = 0; i < set[0].length; i++) { // test Scan finish view
			System.out.print(set[1][i] + " ");
		}
		System.out.println();
		System.out.println(length);

		sc.close();
	} // main method end

	// String spliter method
	public static String[] spliter(String input) {
		String[] splited = input.split("");

		return splited;
	}

	// Optimization
	public static ArrayList<Object> measureLength(String[] splited1, String[] splited2) {
		int fullLength = splited1.length + splited2.length;
		int[][] set = new int[2][fullLength + splited1.length];
		int[] inifi = new int[4];
		int temp = set[0].length;

		// Distribute
		for (int i = 0; i < splited1.length; i++) {
			set[0][i] = Integer.parseInt(splited1[i]);
		}
		for (int i = splited1.length; i < (fullLength + splited1.length); i++) {
			if ((i - splited1.length) > splited2.length - 1) {
				break;
			}
			set[1][i] = Integer.parseInt(splited2[i - splited1.length]);
		}

		// Check the condition
		int length = fullLength + splited1.length;
		while (true) {
			// Check starting points and end points
			inifi = startEnd(inifi, set);

			// Measure length
			boolean check = true;

			for (int j = 0; j < set[0].length; j++) {
				if (set[0][j] == 2 && set[1][j] == 2) {
					check = false;
				}
			}

			if (check) {
				//temp = (inifi[0]<=inifi[2]) ? (inifi[1]>inifi[3]) ? inifi[1] - inifi[0] + 1 : inifi[3] - inifi[0] + 1 : (inifi[1]>inifi[3]) ? inifi[1] - inifi[2] + 1 : inifi[3] - inifi[2] + 1;
											  
				if (inifi[0] <= inifi[2]) { // [0] < [2]
					if (inifi[1] > inifi[3]) {
						temp = inifi[1] - inifi[0] + 1;
					} else {
						temp = inifi[3] - inifi[0] + 1;
					}
				} else { // [0] > [2]
					if (inifi[1] > inifi[3]) {
						temp = inifi[1] - inifi[2] + 1;
					} else {
						temp = inifi[3] - inifi[2] + 1;
					}
				}

				if (temp < length) {
					length = temp;
				}
			}

			// scan breaker
			if (set[0][set[0].length - 1] != 0) {
				break;
			}

			// Movement
			for (int j = set[0].length - 1; j >= 1; j--) {
				set[0][j] = set[0][j - 1];
				if (j == 1) {
					set[0][0] = 0;
				}
			}
		} // while end

		ArrayList<Object> container = new ArrayList();
		container.add(length);
		container.add(set);

		return container;
	} // measureLength method end

	public static int[] startEnd(int[] inifi, int[][] set) {
		for (int j = 0; j < set[0].length; j++) {
			if (set[0][j] != 0) { // start
				inifi[0] = j;
				break;
			}
		}
		for (int j = set[0].length - 1; j >= 0; j--) {
			if (set[0][j] != 0) { // end
				inifi[1] = j;
				break;
			}
		}
		for (int j = 0; j < set[0].length; j++) {
			if (set[1][j] != 0) { // start
				inifi[2] = j;
				break;
			}
		}
		for (int j = set[0].length - 1; j >= 0; j--) {
			if (set[1][j] != 0) { // end
				inifi[3] = j;
				break;
			}
		}
		return inifi;
	} // startEnd method end
}
```