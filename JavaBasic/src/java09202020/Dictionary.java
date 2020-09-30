package java09202020;

import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	public static void main(String[] args) {
		// Define variables
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		String[] input = new String[testCase];
		ArrayList<Object> list = new ArrayList<Object>();
		String[] output = new String[testCase];

		// Input Process, String --> char[] --> int[] (in ArrayList)
		sc.nextLine();
		for (int i = 0; i < testCase; i++) {
			String temp = sc.nextLine();
			input[i] = temp;
			char[] charTemp = temp.toCharArray();
			int[] intTemp = new int[charTemp.length];

			for (int j = 0; j < charTemp.length; j++) {
				intTemp[j] = (int) charTemp[j];
			}
			list.add(intTemp);
		}

		// Sort
		for (int i = 0; i < list.size(); i++) {
			int[] listTemp = (int[]) list.get(i);

			for (int j = 0; j < listTemp.length; j++) {
				for (int k = 1; k < listTemp.length - j; k++) {
					if (listTemp[k - 1] > listTemp[k]) {
						int tempInt;
						tempInt = listTemp[k - 1];
						listTemp[k - 1] = listTemp[k];
						listTemp[k] = tempInt;
					}
				}
			} // sort end
			list.set(i, listTemp);
		} // for end

		// int[] (in ArrayList) -> char[] -> String[]
		for (int i = 0; i < list.size(); i++) {
			int[] tempIntArray = (int[]) list.get(i);
			char[] tempChar = new char[tempIntArray.length];

			for (int j = 0; j < tempIntArray.length; j++) {
				tempChar[j] = (char) tempIntArray[j];
			}
			list.set(i, tempChar);
			output[i] = String.valueOf(tempChar);
		}

		// Output
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
//*********************************************************
		ArrayList<Object> sort = new ArrayList<Object>();
		for (int i=0; i<input.length; i++) {
			sort.add(input[i].toCharArray());
		}
		
		for (int i=0; i<sort.size(); i++) { // testCase
			char[] temp = (char[]) sort.get(i);
			int range = 1;
			for (int j=temp.length-1; j>=j-range; j--) {
				
			}
		}

		sc.close();
	}

}
