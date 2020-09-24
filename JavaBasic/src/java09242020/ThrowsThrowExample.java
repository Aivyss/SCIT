package java09242020;

public class ThrowsThrowExample {

	public static void main(String[] args) {
		try {
			summary();
		} catch (Exception e) {
			e.printStackTrace(); // print line number of error.
		}

	} // main method end
	
	public static int divide (int n, int m) throws Exception {
		return n/m;
	} // divide method end
	
	public static void summary() throws Exception {
		try {
			System.out.println("calc result : " + divide(10, 0));
		} catch (Exception e) {
			throw new Exception(" Calc error");
		}
	} // summary method end

}
