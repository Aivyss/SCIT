package java09092020;

import java.util.Scanner;

public class Problem5 {
	public static void main(String[] args) {
		// Define variables
		int[] arry = new int[5];
		String str = "";
		Scanner sc = new Scanner(System.in);
		
		// Input Process
		for (int i=0; i<arry.length; i++) {
			System.out.print((i+1) + "번째 숫자 입력 : ");
			arry[i] = sc.nextInt();
		}
		
		// Process
		for (int i=0; i<arry.length; i++) {
			str += Integer.toString(arry[i]);
		}
		str  = reverseString(str);
		
		// Output
		System.out.println(str);
		
		
	} // main method end
	
	// Reverse method
    public static String reverseString(String s){
        return (new StringBuffer(s)).reverse().toString();
    }
}