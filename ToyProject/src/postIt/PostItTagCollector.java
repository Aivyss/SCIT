package postIt;

import java.util.ArrayList;

public class PostItTagCollector {
	private PostItStorage storage = new PostItStorage();
	private ArrayList<Integer> index = new ArrayList<Integer>();

	// Constructor
	public PostItTagCollector(PostItStorage storage) {
		this.storage = storage;
	}

	public void tagView(String tag) {
		PostIt[] postIt = new PostIt[storage.getStorage().size()];
		for (int i=0; i<storage.getStorage().size(); i++) {
			postIt[i] = storage.getStorage().get(i);
		}

		for (int j = 0; j < postIt.length; j++) {
			for (int k = 0; k < postIt[j].getTag().size(); k++) {
				if (postIt[j].getTag().get(k).equals(tag)) {
					index.add(j);
					postIt[j].postItView();
				}
			}
		}
	} // tagView method end
}
