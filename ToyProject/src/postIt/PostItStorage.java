package postIt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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

			for (int i = 0; i < storage.size(); i++) {
				PostIt temp = (PostIt) storage.get(i);
				bw.write("<Title>" + "\n");
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
	}// file writer method end
	
	public void readPostIts(String pathName) {
		File file = new File(pathName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr); 
			PostIt pi = new PostIt();
			String oneLine = "";
			
			oneLine = br.readLine();
			if (oneLine.equals("<Title>")) {
				oneLine = br.readLine();
				pi.setTitle(oneLine);
			}
			if (oneLine.equals("<Content>")) {
				oneLine = br.readLine();
				pi.setContent(oneLine);
			}
			if (oneLine.equals("<Create date>")) {
				oneLine = br.readLine();
				pi.setDate(oneLine);
			}
			if (oneLine.equals("<To do>")) {
				oneLine = br.readLine();
				if (oneLine.equals("T")) {
					pi.setToDoOnOFF(true);
				} else {
					pi.setToDoOnOFF(false);
				}
				
				oneLine = br.readLine();
				if (oneLine.equals("T")) {
					pi.setToDo(true);
				} else {
					pi.setToDo(false);
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} 

