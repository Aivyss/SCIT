package java09062020;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
	public static void main(String[] args) {
		startBaseBallGame(baseBallSort());
	}

	// input random values and sort method
	public static int[] baseBallSort() {
		// Define array
		int[] arry = new int[3];

		// Define random values & Multiple checking
		Random rd = new Random();
		for (int i = 0; i < arry.length; i++) {
			arry[i] = rd.nextInt(9); // 0 ~ 9
			for (int j = 0; j < arry.length; j++) {
				if (i == j) {
				} else {
					while (arry[i] == arry[j]) {
						arry[i] = rd.nextInt(9); // 0 ~ 9
						j = 0;
					}
				}
			}
		}

		// Sort Process
		int temp = 0;
		for (int i = 0; i < arry.length; i++) {
			for (int j = i; j < arry.length; j++) {
				if (arry[i] >= arry[j]) {
					temp = arry[i];
					arry[i] = arry[j];
					arry[j] = temp;
				}
			}
		}
		return arry;
	}

	public static void startBaseBallGame(int[] random) {
		// Define variables
		Scanner sc = new Scanner(System.in);
		int[] arry = new int[3];
		int strike = 0;
		int ball = 0;

		// Process
		while (true) {
			// Input Process
			System.out.print("생각한 세 정수값을 입력하세요 : ");
			for (int i = 0; i < arry.length; i++) {
				arry[i] = sc.nextInt();
			}

			// Score Process
			for (int i = 0; i < arry.length; i++) {
				for (int j = 0; j < random.length; j++) {
					if (i == j && arry[i] == random[j]) {
						strike++;
					} else if (i != j && arry[i] == random[j]) {
						ball++;
					}
				}
			}
			if (strike == 3) {
				System.out.println("정답입니다. 게임을 종료합니다.");
				break;
			} else {
				System.out.println("Strike = " + strike + ", Ball " + ball);
				ball = 0;
				strike = 0;
			}
		}
		sc.close();
	}
}
