# Bubble Sort

# Algorithm

![Bubble%20Sort%204c1df446498441aba66fffdd4a718d6c.png](Bubble%20Sort%204c1df446498441aba66fffdd4a718d6c.png)

# 要求条件

- 정렬을 원하는 값을 입력 받을 수 있어야 한다. 다만 그 크기는 한정되지 않고 자유롭게 할 수 있도록 한다.
- 인접한 두 공간의 인덱스 i, i+1을 서로 비교, 교환 할 수 있어야 한다.
- +1 phase당 i++가 된다.
- 한 페이즈가 끝날 때마다 비교, 교환하는 인덱스 범위를 끝에서 부터 1씩 줄인다.

# Code

```java
package java09112020;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		// Define variables
		ArrayList<Integer> input = new ArrayList();
		ArrayList<Integer> output = new ArrayList();

		// Input Process
		input = input();

		// Sort Process (Bubble Sort)
		output = bubbleSort(input);
		
		// Print
		print(output);

	}// main method end

	// Input method
	public static ArrayList<Integer> input() {
		// Define variables
		ArrayList<Integer> arry = new ArrayList();
		Scanner sc = new Scanner(System.in);
		int i = 0;

		// Process
		while (true) {
			String str = sc.next();

			if (str.equals("/")) {
				break;
			} else {
				arry.add(Integer.parseInt(str));
				i++;
			}
		}

		return arry;
	} // Input method end

	// Bubble Sort method
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> input) {
		int endPoint = input.size()-1;
		
		for (int i = 0; i <= endPoint; i++) {
			for (int j = 0; j <= endPoint-i; j++) {
				if (j == endPoint-i) {
					continue;
				}
				
				if (input.get(j) > input.get(j + 1)) {
					int temp = 0;
					temp = input.get(j);
					input.set(j, input.get(j+1));
					input.set(j+1, temp);
				}
			}
		} // for end
		
		return input;
	} // Bubble Sort method end
	
	// Print Method
		public static void print(ArrayList<Integer> output) {
			for (int i=0; i<output.size(); i++) {
				System.out.print(output.get(i) + "\t");
			}
		}
}
```