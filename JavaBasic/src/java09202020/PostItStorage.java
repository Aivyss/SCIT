package java09202020;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PostItStorage {
	private ArrayList<Object> storage = new ArrayList<Object>();

	public PostItStorage() {

	}

	// storage getter (from ArrayList)
	public ArrayList<Object> getStorage() {
		return storage;
	}

	// store process (in ArrayList)
	public void store(PostIt[] input) {
		for (int i = 0; i < input.length; i++) {
			storage.add(input[i]);
			// storage.getStorage().get(i) --> PostIt instance
		}
	}

	// store process (in ArrayList)
	public void store(PostIt input) {
		storage.add(input);
	}

	// Write Process (ArrayList -> files)
	public void writeFile(String pathName) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(pathName);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < storage.size(); i++) {
				PostIt temp = (PostIt) storage.get(i);
				bw.write("<Title>" + i + "\n");
				bw.write(temp.getTitle() + "\n");
				
				bw.write("<Content>" + "\n");
				bw.write(temp.getContent() + "\n");
				
				bw.write("<Tags>" + "\n");
				ArrayList<String> tempTags = temp.getTags();
				for (int j = 0; j < tempTags.size(); j++) {
					bw.write(tempTags.get(j) + "\n");
				}
				
				bw.write("<Create date>" + "\n");
				bw.write(temp.getDate() + "\n");
				
				bw.write("<To do>" + "\n");
				if (temp.isToDoOnOFF()) {
					bw.write("T" + "\n");
				} else {
					bw.write("F" + "\n");
				}
				if (temp.isToDo()) {
					bw.write("T" + "\n");
				} else {
					bw.write("F" + "\n");
				}

				bw.write("<Pin>" + "\n");
				if (temp.isPin()) {
					bw.write("T" + "\n");
				} else {
					bw.write("F" + "\n");
				}

				bw.write("<Alert>" + "\n");
				if (temp.isAlertOnOff()) {
					bw.write("T" + "\n");
				} else {
					bw.write("F" + "\n");
				}
				bw.write(temp.getAlertDate() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // finally end
	}
} // file writer method end

