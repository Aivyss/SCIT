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
