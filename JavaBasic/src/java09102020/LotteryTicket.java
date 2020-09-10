package java09102020;

import java.util.Random;
import java.util.Scanner;

public class LotteryTicket {
	public static void main(String[] args) {
		// Define variables
		int numRange = 45;
		int select = 6;
		int[] winNum = new int[select];
		int[] oMR = new int[select];
		int rank;
		
		// Input Process
		System.out.print("input six numbers : ");
		oMR = input(oMR);
		
		// Generate Winning Number
		winNum = genWinNum(winNum, numRange);
		System.out.print("Winning Number : ");
		for (int i=0; i<winNum.length ;i++) {
			System.out.print(winNum[i] + "\t");
		}
		// Check the rank
		rank = checkRank(oMR, winNum);
		
		// Output
		System.out.println();
		System.out.println(rank + "rank");
		
		
	} // main method end
	
	// Input Process method
	public static int[] input(int[] oMR) {
		// Define variables
		int arraySize = oMR.length;
		Scanner sc = new Scanner(System.in);
		
		// Input
		for (int i=0; i<arraySize; i++) {
			oMR[i] = sc.nextInt();
		}
		
		sc.close();
		
		return oMR;
	}
	
	// Generate Winning Number Method
	public static int[] genWinNum(int[] winNum, int numRange) {
		// Define variables
		Random rd = new Random();
		int arraySize = winNum.length;
		
		// Generate numbers without duplication
		for (int i=arraySize-1; i>=0; i--) {
			winNum[i] = rd.nextInt(numRange)+1;
			for (int j=i+1; j<arraySize ; j++) {
				if (winNum[i] == winNum[j]) {
					i++;
					break;
				}
			}
		}
		return winNum;
	}
	
	// Check method
	public static int checkRank(int[] oMR, int[] winNum) {
		// Define variables
		int rank = 6;
		int count = 0;
		int arraySize = oMR.length;
		
		// Counting Process
		for (int i=0; i<arraySize; i++) {
			for (int j=0; j<arraySize; j++) {
				if (oMR[i] == winNum[j]) {
					count ++;
					break;
				}
			}
		} // for end
		
		// Define rank
		while (count != 0) {
			count--;
			rank--;
		}
		return rank;
	}
}
