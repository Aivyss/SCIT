package java09082020;

public class ConcatPractice {
	public static void main(String[] args) {
		// Define variables
		String[] str = new String[3];
		
		// String default value == null
		// delete null values
		str[0] = "abc";
		str[1] = "def";
		str[2] = "ghi";
		
		// Adding Process, concat method
		for (int i=0; i<str.length; i++) {
			str[i] = str[i].concat("-adding");
			System.out.println(str[i]);
		}
	}
}
