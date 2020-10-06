package java10062020;

public class Problem2 {

	public static void main(String[] args) {
		String score = "100, 31, 53, 83";
		String[] array = score.split(", ");
		
		int sum = 0;
		for (int i=0; i<array.length; i++) {
			sum += Integer.parseInt(array[i]);
		}
		System.out.println("sum = " + sum);
		System.out.println("avg = " + 1.0*sum/array.length);
		
	}

}
