package java10062020;

public class Problem1 {

	public static void main(String[] args) {
		String str = "lee sun sin";
		if(str.contains("sun")) {
			str = str.replace("sun", "soon");
			
			// way 1
			System.out.println("성: "+ str.split(" ")[0]);
			System.out.println("이름: "+ str.split(" ")[1] + " " + str.split(" ")[2]);
			
			// way 2
			System.out.println("성: " + str.substring(0, 3));
			System.out.println("이름: " + str.substring(4, 12));
		}
	}

}
