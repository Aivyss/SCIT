package java10062020;

public class Truck extends Vehicle {
	// Member variables
	protected double maxLoad; // 최대적재량
	
	// Constructor
	public Truck(int wheel, int seat, double maxLoad, double weight) { 
		// this.numberOfSeat = seat;
		super.numberOfSeat = seat;
		super.numberOfWheel = wheel;
		this.maxLoad = maxLoad;
		this.weight = weight;
	}
	
	// load Method
	public void load() {
		
	}
}
