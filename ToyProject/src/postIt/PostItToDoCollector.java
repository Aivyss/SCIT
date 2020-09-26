package postIt;

import java.util.ArrayList;

public class PostItToDoCollector {
	PostItStorage storage = new PostItStorage();
	ArrayList<Object> pis = new ArrayList<Object>();
	
	// loadToDo method
	public ArrayList<Object> loadToDo() {
		for (int i=0; i<storage.getStorage().size(); i++) {
			PostIt pi = new PostIt();
			pi = (PostIt) storage.getStorage().get(i);
			
			if (pi.isToDoOnOFF()) {
				pis.add(pi);
			}
		}
		return pis;
	}
	
	// View all Post-It to have To-Do
	public void viewToDo() {
		for (int i=0; i<pis.size(); i++) {
			PostIt pi = new PostIt();
			pi = (PostIt) pis.get(i);
			pi.postItView();
		}
	}
}
