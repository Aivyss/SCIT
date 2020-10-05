package java10052020;

public class ElapsedTimeCheck {

	public static void main(String[] args) {
		String str = "";
		StringBuffer buf = new StringBuffer();
		
		// String Class 
		long start = System.currentTimeMillis(); // start time check
		for (int i=0; i<100000; i ++) {
			str += "a";
		}
		long end = System.currentTimeMillis(); // end Time check
		System.out.println(end-start);
		
		// StringBuffer Class
		start = System.currentTimeMillis(); // start time check
		for (int i=0; i<100000; i ++) {
			buf.append("a");
		}
		end = System.currentTimeMillis(); // end Time check
		System.out.println(end-start);
	}

}
