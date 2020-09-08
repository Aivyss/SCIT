package java09082020;

import java.util.Scanner;

public class OXQuiz {
	public static void main(String[] args) {
		// Define variables 1
		int number;
		int score = 1;
		Scanner sc = new Scanner(System.in);
		
		// Input Process 1
		number = sc.nextInt();
		
		// Define variables 2
		String[] str = new String[number];
		char[][] ch = new char[number][80];
		int[] sum = new int[number];
		String test ="";

		// Input OX
		for (int i=0; i<number; i++) {
			str[i]=sc.next();
			sc.nextLine();
		}
		
		// Transform to character
		for (int i=0; i<number; i++) {
			test = str[i];
			char[] testchar = test.toCharArray();
			
			for (int j=0; j<testchar.length; j++) {
				ch[i][j] = testchar[j];
			}
		}
		
		// Calculate score
		for (int i=0; i<number; i++) {
			for (int j=0; j<80; j++) {
				if (ch[i][j] == 'O') {
					sum[i] +=score;
					score++;
				} else {
					score = 1;
				}
			}
		}
		
		// Output
		for (int i=0; i<number; i++) {
			System.out.println(sum[i]);
		}
		
		sc.close();
	}
}
