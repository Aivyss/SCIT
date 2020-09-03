package java09032020;

import java.util.Scanner;

public class Problem19 {
	public static void main(String[] args) {
		// Define variables
		int i, j, k;
		int temp;
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		System.out.print("1번 째 정수 입력 : ");
		i = sc.nextInt();
		System.out.print("2번 째 정수 입력 : ");
		j = sc.nextInt();
		System.out.print("3번 째 정수 입력 : ");
		k = sc.nextInt();
		
		// Process
		if (i>j) {
			temp=i;
			i=j;
			j=temp;
		}
		if (i>k) {
			temp=i;
			i=k;
			k=temp;
		}
		if (j>k) {
			temp=j;
			j=k;
			k=temp;
		}
		System.out.println(i + " " + j + " " + k);
		sc.close();
	}
}
