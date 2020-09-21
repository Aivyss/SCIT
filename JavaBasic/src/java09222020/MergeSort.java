package java09222020;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
	// Define Member variables
	ArrayList<Object> splitted = new ArrayList<Object>();
	ArrayList<Object> input = new ArrayList<Object>();
	ArrayList<Object> output = new ArrayList<Object>();

	// Input method
	public void input() {
		// Define variables
		ArrayList<Integer> container = new ArrayList<Integer>();
		ArrayList<Object> input = new ArrayList<Object>();
		Scanner sc = new Scanner(System.in);

		// Input Process
		while (true) {
			String str = sc.next();

			if (str.equals("/")) {
				break;
			} else {
				container.add(Integer.parseInt(str));
			}
		}

		int[] array = new int[container.size()];
		for (int j = 0; j < container.size(); j++) {
			array[j] = container.get(j);
		}

		input.add(array);

		this.input = input;
	}

	// splitter method
	public void splitter(ArrayList<Object> input) {
		int[] array = (int[]) input.get(0);
		for (int i = 0; i < array.length; i++) {
			int[] temp = new int[1];
			temp[0] = array[i];
			splitted.add(temp);
		}
	}

	// Merge Sort method
	public void mergeSort(ArrayList<Object> splitted) {
		ArrayList<Object> splittedAfter = new ArrayList<Object>();
		
		// Recursive method end check
		if (splitted.size() == 1) {
			this.output = splitted; //  splittedAfter <--(n-th Recursive)-- splitted
			return;
		}
		
		// Merging Process
		while (splitted.size() >= 2) {
			int i = 0;
			int j = 0;
			int k = 0;

			int[] zero = (int[]) splitted.get(0);
			int[] one = (int[]) splitted.get(1);
			int[] integration = new int[zero.length + one.length];
			
			while (i < zero.length || j < one.length) {
				if (i >= zero.length) {
					integration[k] = one[j];
					k++;
					j++;
				} else if (j >= one.length) {
					integration[k] = zero[i];
					k++;
					i++;
				} else {
					if (zero[i] < one[j]) {
						integration[k] = zero[i];
						i++;
						k++;
					} else {
						integration[k] = one[j];
						j++;
						k++;
					}
				}
			}
			
			// Reduced Process
			splittedAfter.add(integration);
			splitted.remove(0);
			splitted.remove(0);
		}

		if (splitted.size() == 1) {
			splittedAfter.add((int[]) splitted.get(0));
		}

		mergeSort(splittedAfter); // Recursive call (repeat again)
	}

	// Print Method
	public void print() {
		int[] sortedArray = (int[]) output.get(0);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i] + "\t");
		}
	}

	// Getter
	public ArrayList<Object> getInput() {
		return input;
	}

	public ArrayList<Object> getOutput() {
		return output;
	}

	public ArrayList<Object> getSplitted() {
		return splitted;
	}
}