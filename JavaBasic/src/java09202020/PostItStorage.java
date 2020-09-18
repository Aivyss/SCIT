package java09202020;

import java.util.ArrayList;

public class PostItStorage {
	private ArrayList<Object> storage = new ArrayList<Object>();
	
	public PostItStorage() {
		
	}
	
	// storage getter
	public ArrayList<Object> getStorage() {
		return storage;
	}
	
	// store process
	public void store(PostIt[] input) {
		for (int i=0; i<input.length; i++) {
			storage.add(input[i]);
			// storage.getStorage().get(i) --> PostIt instance
		}
	}
	
	// store process
	public void store(PostIt input) {
		storage.add(input);
	}
}
