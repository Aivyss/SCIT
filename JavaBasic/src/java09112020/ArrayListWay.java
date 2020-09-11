package java09112020;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListWay {
	public static void main(String[] args) {
		 /* 
		  * <Object> You can input class or others type.
		  * <Integer> You can input int type.
		  * <Double> You can input double type.
		  * <String> You can input String type.
		  */
		ArrayList<Object> aLObject = new ArrayList(); 		// 1
		ArrayList<Object> aLObjectTest = new ArrayList();
		ArrayList<Integer> aLInt = new ArrayList(); 		// 2
		ArrayList<Double> aLDouble = new ArrayList(); 		// 3
		ArrayList<String> aLString = new ArrayList(); 		// 4
		Scanner sc = new Scanner(System.in);
		
		int[][] array = new int[5][4];
		int[][] outputArray;
		int integer = 5;
		int integerAdd = 6;
		double realNum = 3.14;
		String str = "ABCD";
		
		// Input variables to ArrayList classname.add(variables);
		aLObject.add(array);								// 1
		aLObject.add(integer);								// 1
		aLObject.add(aLObjectTest); 						// 1
		aLObject.add(sc);									// 1
		
		aLInt.add(integer);									// 2
		
		aLDouble.add(realNum);								// 3
		
		aLString.add(str);									// 4
		
		// Output Process: classname.get(index);
		outputArray = (int[][]) aLObject.get(0);
		System.out.println(outputArray[3][3]);				// 1
		System.out.println((int) aLObject.get(1));			// 1
		System.out.println(aLInt.get(0));					// 2
		System.out.println(aLDouble.get(0));				// 3
		System.out.println(aLString.get(0));				// 4
		
		// Array List size
		System.out.println(aLObject.size());
		
		// Set values
		aLInt.set(0, integerAdd);
		System.out.println(aLInt.get(0));
		System.out.println(aLInt.size());
	}
}
