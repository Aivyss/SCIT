package postIt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
			
			// the number of Post-It
			bw.write(Integer.toString(storage.size()));
			bw.write("\n");
			
			// Post-It write process
			for (int i = 0; i < storage.size(); i++) {
				PostIt temp = (PostIt) storage.get(i);
				
				// Write Basic Post-It Information
				bw.write("<Title>" + "\n");
				bw.write(temp.getTitle() + "\n");
				bw.write("<Content>" + "\n");
				bw.write(temp.getContent() + "\n");
				
				// Write Tags 
				bw.write("<Tags>" + "\n");
				ArrayList<String> tempTags = temp.getTags();
				bw.write(Integer.toString(tempTags.size()));
				for (int j = 0; j < tempTags.size(); j++) {
					bw.write(tempTags.get(j) + "\n");
				}
				
				// Write date
				bw.write("<Create date>" + "\n");
				bw.write(temp.getDate() + "\n");
				
				// Write To-do information
				bw.write("<To do>" + "\n");
				if (temp.isToDoOnOFF()) {
					bw.write("T" + "\n");
				} else {
					bw.write("F" + "\n");
				}
				ArrayList<Boolean> tempToDoBox = temp.getToDoBox();
				ArrayList<String> tempToDoContent = temp.getToDoContent();
				bw.write(tempToDoBox.size());
				for (int j=0; j<temp.getToDoBox().size(); j++) {
					if (tempToDoBox.get(j)) {
						bw.write("T" + "\n");
					} else {
						bw.write("F" + "\n");
					}
				}
				for (int j=0; j<temp.getToDoBox().size(); j++) {
					bw.write(tempToDoContent.get(i));
				}
				
				// Write pin status
				bw.write("<Pin>" + "\n");
				if (temp.isPin()) {
					bw.write("T" + "\n");
				} else {
					bw.write("F" + "\n");
				}
				
				// Write alert status
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
	}// file writer method end
	
	// readFile method
	public void readFile(String pathName) {
		File file = new File(pathName);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			PostIt pi = new PostIt();
			String oneLine = "";
			
			// Size check
			oneLine = br.readLine();
			int size = Integer.parseInt(oneLine);
			
			// read process
			for (int i=1; i<=size; i++) {
				
				// title read
				br.readLine();
				oneLine = br.readLine();
				pi.setTitle(oneLine);

				// content read
				br.readLine();
				oneLine = br.readLine();
				pi.setContent(oneLine);
				
				// tag read
				br.readLine();
				int numTags = Integer.parseInt(br.readLine());
				ArrayList<String> tempTags = new ArrayList<String>();
				for (int j=0; j<numTags; j++) {
					tempTags.add(br.readLine());
				}
				pi.setTags(tempTags);
				
				// created data read
				br.readLine();
				oneLine = br.readLine();
				pi.setDate(oneLine);

				// To-do read
				br.readLine(); // <To do>
				br.readLine(); // ON - OFF
				if ("T".equals(oneLine)) {
					pi.setToDoOnOFF(true);
				} else {
					pi.setToDoOnOFF(false);
				}
				
				oneLine = br.readLine(); // To-do size read
				ArrayList<Boolean> toDoBox = new ArrayList<Boolean>();
				ArrayList<String> toDoContent = new ArrayList<String>();
				for (int j=0; j<Integer.parseInt(oneLine); j++) {
					oneLine = br.readLine();
					if ("T".equals(oneLine)) {
						toDoBox.add(true);
					} else {
						toDoBox.add(false);
					}
				}
				for (int j=0; j<Integer.parseInt(oneLine); j++) {
					oneLine = br.readLine();
					toDoContent.add(oneLine);
				}
				pi.setToDoBox(toDoBox);
				pi.setToDoContent(toDoContent);
				
				// Pin read
				br.readLine();
				oneLine = br.readLine();
				if ("T".equals(oneLine)) {
					pi.setPin(true);
				} else {
					pi.setPin(false);
				}
				
				// Alert 
				br.readLine();
				oneLine = br.readLine();
				if ("F".equals(oneLine)) {
					pi.setAlertOnOff(false);
					oneLine = br.readLine();
					pi.setAlertDate(oneLine);
				} else {
					pi.setAlertOnOff(true);
					oneLine = br.readLine();
					pi.setAlertDate(oneLine);
				}
				
				store(pi);
				// Reset container
				pi = new PostIt();
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} // finally end
	}
}
