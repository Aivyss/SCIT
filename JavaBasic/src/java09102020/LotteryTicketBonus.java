package java09102020;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LotteryTicketBonus {
	public static void main(String[] args) {
		// Define variables
		int numRange = 45;
		int select = 6;
		int winBonus;
		int inputBonus;
		int[] winNum = new int[select];
		int[] oMR = new int[select];
		int rank;
		ArrayList<Object> arrayList = new ArrayList<Object>();

		// Input Process
		System.out.print("input six numbers : ");
		arrayList = input(oMR);
		oMR = (int[]) arrayList.get(0);
		inputBonus = (int) arrayList.get(1);

		// Generate Winning Number
		arrayList = genWinNum(winNum, numRange);
		winNum = (int[]) arrayList.get(0);
		winBonus = (int) arrayList.get(1);
		System.out.print("Winning Number + Bonus Number: ");
		for (int i = 0; i < winNum.length; i++) {
			System.out.print(winNum[i] + "\t");
		}
		System.out.print(winBonus);

		// Check the rank
		rank = checkRank(oMR, winNum, inputBonus, winBonus);

		// Output
		System.out.println();
		System.out.println(rank + "rank");
	} // main method end

	// Input Process method
	public static ArrayList<Object> input(int[] oMR) {
		// Define variables
		int inputBonus;
		int arraySize = oMR.length;
		Scanner sc = new Scanner(System.in);

		// Input
		for (int i = 0; i < arraySize; i++) {
			oMR[i] = sc.nextInt();
		}
		inputBonus = sc.nextInt();

		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(oMR);
		arrayList.add(inputBonus);
		
		sc.close();

		return arrayList;
	}

	// Generate Winning Number Method
	public static ArrayList<Object> genWinNum(int[] winNum, int numRange) {
		// Define variables
		Random rd = new Random();
		int arraySize = winNum.length;
		int winBonus = 0;

		// Generate numbers without duplication
		for (int i = arraySize - 1; i >= 0; i--) {
			winNum[i] = rd.nextInt(numRange) + 1;
			for (int j = i + 1; j < arraySize; j++) {
				if (winNum[i] == winNum[j]) {
					i++;
					break;
				}
			}
		}

		// Generate Bonus number
		winBonus = rd.nextInt(numRange) + 1;
		for (int i = 0; i < arraySize; i++) {
			if (winBonus == winNum[i]) {
				winBonus = rd.nextInt(numRange) + 1;
				i = 0;
			}
		}

		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(winNum);
		arrayList.add(winBonus);

		return arrayList;
	}

	// Check method
	public static int checkRank(int[] oMR, int[] winNum, int inputBonus, int winBonus) {
		// Define variables
		int rank = 5;
		int count = 0;
		int arraySize = oMR.length;

		// Counting Process
		for (int i = 0; i < arraySize; i++) {
			for (int j = 0; j < arraySize; j++) {
				if (oMR[i] == winNum[j]) {
					count++;
					break;
				}
			}
		} // for end

		// Define rank
		switch (count) {
			case 6:
				rank = 1;
				break;
			case 5:
				if (inputBonus == winBonus) {
					rank = 2;
				} else {
					rank = 3;
				}
				break;
			case 4:
				rank = 4;
				break;
			case 3:
				rank = 5;
				break;
			default:
				rank = 0;
				break;
		}

		return rank;
	}
}
