/**
 * <!--ArrayList Method--!>
 * .toArray() --> return Object[] type
 * .toArray(T[] type) --> return T[] type
 */
package java10132020;

import java.util.ArrayList;

public class ArrayListToArrayMethod {

	public static void main(String[] args) {
		ArrayList<Integer> inte1 = new ArrayList<>();
		
		for (int i=0; i<100; i++) {
			inte1.add(i);
		}
		
		Object[] arr1 = inte1.toArray(); // useless
		
		Integer[] arr2 = new Integer[inte1.size()];
		arr2 = inte1.toArray(arr2);
	
		
		for (int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]==i);
		}
	}

}
