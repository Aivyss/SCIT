package java09112020;

import java.util.Scanner;

public class Gomoku {
	public static void main(String[] args) {
		// Define variables
		int[][] arry = new int[19][19];
		String player1= "Player 1";
		String player2 = "Playter 2";
		int count = 0;
		
		while(true) {
			int[][] copy = new int[19][19];
			String temp ="";
			String turn ="";
			count++;
			
			// Check whose turn
			if (count%2 != 0) {
				arry = input(player1, arry);
				turn = player1;
			} else {
				arry = input(player2, arry);
				turn = player2;
			}
			
			// Display
			display(arry);
			
			// Check the winner
			temp = winCheck(arry);
			if (temp.equals("")) {
				continue;
			} else {
				System.out.println(temp + " wins !");
				if (turn.equals("Player 1")){
					System.out.println((count/2+1) + "round");
				} else {
					System.out.println(count/2 + "round");
				}
				break;
			}
			
		} // while end
	} // main method end
	
	// Input Process
	public static int[][] input(String player, int[][] array) {
		// Define variables
		int i;
		int j;
		Scanner sc = new Scanner(System.in);
		
		// Process
		if (player.equals("Player 1")) {// Player 1's turn
			while(true) {
				System.out.print(player + "\'s turn : ");
				i = sc.nextInt();
				j = sc.nextInt();
				
				// duplicate check
				if (array[i][j] != 0) {
					continue;
				} else {
					array[i][j] = 3; // Using Prime Number 
					break;
				}
			}
		} else { // Player 2's turn
			while(true) {
				System.out.print(player + "\'s turn : ");
				i = sc.nextInt()-1;
				j = sc.nextInt()-1;
				
				// duplicate check
				if (array[i][j] !=0) {
					continue;
				} else {
					array[i][j] = 5; // Using Prime Number
					break;
				}
			}
		}
		
		return array;
	}
	
	// Winner check method
	public static String winCheck(int[][] arry) {
		int[][] testarry = new int[19+4][19+4];
		String winner = "";
		
		// Redistribute
		for (int i=0; i<arry.length-2; i++) {
			for (int j=0; j<arry.length-2; j++) {
				testarry[i+2][j+2] = arry[i][j];;
			}
		}
		
		// Not boundary
		for (int i=0; i<testarry.length; i++) {
			for (int j=0; j<testarry.length; j++) {
				int leftTopRightDownSum = 0;
				int rightTopLeftDownSum = 0;
				int verticalSum = 0;
				int horizenSum = 0;
				
				if (testarry[i][j] == 0) {
					continue;
				}
				
				leftTopRightDownSum = testarry[i+2][j+2] + testarry[i+1][j+1] + testarry[i-1][j-1] + testarry[i-2][j-2];
				rightTopLeftDownSum = testarry[i-2][j+2] + testarry[i-1][j+1] + testarry[i+1][j-1] + testarry[i+2][j-2];
				verticalSum = testarry[i+2][j] + testarry[i+1][j] + testarry[i-1][j] + testarry[i-2][j];
				horizenSum = testarry[i][j+2] + testarry[i][j+1] + testarry[i][j-1] + testarry[i][j-2];
				
				if (leftTopRightDownSum == 12 || rightTopLeftDownSum == 12 || verticalSum == 12 || horizenSum == 12 ) {
					winner = "Player 1";
				} else if (leftTopRightDownSum == 20 || rightTopLeftDownSum == 20 || verticalSum == 20 || horizenSum == 20) {
					winner = "Player 2";
				}			
			}
		} // for end
		
		return winner; 
	} // Winner check method end
	
	// Display method
	public static void display(int[][] arry) {
		for (int i=0; i<30; i++) {
			System.out.println(); // clean Console
		}
		
		for (int i=0; i<arry.length; i++) {
			for (int j=0; j<arry.length; j++) {
				if (arry[i][j] == 0) {
					System.out.print("□");
				} else if (arry[i][j] == 3) {
					System.out.print("▼");
				} else if (arry[i][j] == 5) {
					System.out.print("▲");
				}
			}
			System.out.println();
		} // for end
	}
}
