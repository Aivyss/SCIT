/**
 * List interface
 * converter method
 * for each
 */
package java10132020;

import java.util.ArrayList;
import java.util.List;

public class GenericExampleWithArrayList {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		ArrayToList<Integer> converter = new ArrayToList<>();
		Integer[] inte1 = new Integer[100];
		
		for (int i=0; i < inte1.length; i++) {
			inte1[i] = i;
		}

		for (int i = 0; i < 100; i++) {
			list1.add(i);
		}
		
		// Array --> List
		List<Integer> list2 = converter.arrayToList(inte1);
		System.out.println(list2.size());
		for (Integer a : list2) {
			System.out.println(a);
		}
		System.out.println("=========================");
		
		// List --> Array
		Integer[] inte2 = new Integer[list2.size()];
		inte2 = converter.listToArray(inte2, list2);
		System.out.println(inte2.length);
		for(int i : inte2) {
			System.out.println(i);
		}
		
		System.out.println(list2 instanceof Object);
		System.out.println(list2 instanceof List);	
		System.out.println(list2 instanceof ArrayList);
	}

}
