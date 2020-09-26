package postIt;

import java.util.ArrayList;

public class PostItToDoCollector {
	PostItStorage storage = new PostItStorage();
	ArrayList<Object> pis = new ArrayList<Object>();
	ArrayList<Integer> index = new ArrayList<Integer>();
	
	public PostItToDoCollector() {
		for (int i=0; i<storage.getStorage().size(); i++) {
			PostIt pi = new PostIt();
			pi = (PostIt) storage.getStorage().get(i);
			
			if (pi.isToDoOnOFF()) {
				pis.add(pi);
				index.add(i);
			}
		}
	}
	
	// View all Post-It to have To-Do
	public void viewAllToDo() {
		for (int i=0; i<pis.size(); i++) {
			PostIt pi = new PostIt();
			pi = (PostIt) pis.get(i);
			pi.postItView();
		}
	}
	// ToDo correction method
	public void correctToDo() {
		System.out.println("=======[Post-It list to have To do]=======");
		for (int i=0; i<index.size(); i++) {
			System.out.print(index.get(i) + "\t");
		}
		System.out.println("==========================================");
		storage.correctPostIt();
	}
}
