package java09222020;

public class CounterMain {
	public static void main(String[] args) {
		// Define instances
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		
		// Member variables
		System.out.println("c1.serialNumber: " + c1.serialNumber);
		System.out.println("c2.serialNumber: " + c2.serialNumber);
		System.out.println("c3.serialNumber: " + c3.serialNumber);
		
		// Static variable (=Class variable)
		System.out.println("Counter.counter: " + Counter.counter);
		System.out.println("c1.counter: " + c1.counter);
	}

}
