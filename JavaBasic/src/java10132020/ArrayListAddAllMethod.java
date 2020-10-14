/**
 * <!--ArrayList Method--!>
 * .addAll(Collection c) method
 */
package java10132020;

import java.util.ArrayList;

public class ArrayListAddAllMethod {

	public static void main(String[] args) {
		ArrayList<Integer> inte1 = new ArrayList<>();
		ArrayList<Integer> inte2 = new ArrayList<>();
		
		for (int i=0; i<100; i++) {
			inte1.add(i);
		}
		
		inte2.addAll(inte1);
		
		for (int i=0; i<inte2.size(); i++) {
			System.out.println(inte2.get(i));
		}
	}

}
