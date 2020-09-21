package java09222020;

public class MergeSortMain {
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		
		ms.input();
		
		ms.splitter(ms.getInput());
		
		ms.mergeSort(ms.getSplitted());
		
		ms.print();
	}

}
