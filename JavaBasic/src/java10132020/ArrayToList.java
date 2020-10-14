/**
 * <!-- Generic --!>
 * Array Data type --> ArrayList 
 */

package java10132020;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList<T> {
	
	public T[] listToArray(T[] arry, List<T> list) {
		for (int i=0; i<arry.length; i++) {
			arry[i] = list.get(i);
		}
		
		return arry;
	}

	public List<T> arrayToList(T[] arry) {
		ArrayList<T> list = new ArrayList<>();

		for (int i = 0; i < arry.length; i++) {
			list.add(arry[i]);
		}

		return list;
	}

}
