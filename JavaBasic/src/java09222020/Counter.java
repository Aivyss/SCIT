package java09222020;

public class Counter {
	public int serialNumber;
	public static int counter = 0;
	
	// Constructor
	public Counter() {
		counter++;
		serialNumber = counter;
	}

}
