package java09202020;

import java.util.ArrayList;

public class AllCase {
	public ArrayList<Object>caseFinder(ArrayList<Object> input, int length) {
		ArrayList<Object> caseset = new ArrayList<Object>();
		ArrayList<Object> output = new ArrayList<Object>();
		int[] array = (int[]) input.get(0);
		if (array.length == 1) {
			caseset.add(array);
			return caseset;
		}
		
		int pick = array[0];
		int[] unpick = new int[array.length-1];
		for (int i=1; i<array.length; i++) {
			unpick[i-1] = array[i];
		}
		
		// Process
		int[] resultArray = new int[array.length];
		
		

		return caseset;
	}
}
