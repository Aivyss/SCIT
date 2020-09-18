package postIt;

import java.util.ArrayList;

public class PostItTagCollector {
	private ArrayList<String> tags = new ArrayList<String>();
	private ArrayList<Object> group = new ArrayList<Object>();
	private PostItStorage storage = new PostItStorage();

	// Constructor
	public PostItTagCollector(PostItStorage storage) {
		this.storage = storage;
	}

	public void tagView(String tag) {
		PostIt[] postIt = new PostIt[storage.getStorage().size()];
		for (int i=0; i<storage.getStorage().size(); i++) {
			postIt[i] = (PostIt) storage.getStorage().get(i);
		}

		for (int j = 0; j < postIt.length; j++) {
			for (int k = 0; k < postIt[j].getTag().size(); k++) {
				if (postIt[j].getTag().get(k).equals(tag)) {
					postIt[j].postItView();
				}
			}
		}
	} // tagView method end
}
