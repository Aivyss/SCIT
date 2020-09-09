/*
 * https://www.acmicpc.net/problem/2798
 */
package java09092020;

import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		// Define variables
		int numberOfCard;
		int solution;
		int max = 0;
		int[] card;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		numberOfCard = sc.nextInt();
		solution = sc.nextInt();
		card = new int[numberOfCard];
		
		// Input values to array.
		for (int i=0; i<card.length; i++) {
			card[i] = sc.nextInt();
		}
		
		 // Check the Blackjack
		max = blackJack(card, solution);
		
		//Output
		System.out.println(max);
		
		sc.close();
	} // main method end
	
	// Check the BlackJack method
	public static int blackJack(int[] card, int solution) {
		int sum = 0;
		int max = 0;
		for (int i=0; i<card.length; i++) {
			for (int j=0; j<card.length; j++) {
				if (i == j) {
					continue;
				} else {
					for (int k=0; k<card.length; k++) {
						if (i == k || j == k) {
							continue;
						} else {
							sum = card[i] + card[j] + card[k];
						}
						
						if (sum <= solution) {
							if (max < sum) {
								max = sum;
							}
						}
					} // for 3 end	
				}
			}// for 2 end
		} // for 1 end 
		return max;
	}
}
