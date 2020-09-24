package java09242020;

public class ErrorTest2 {

	public static void main(String[] args) {
		try {
			int a = 10;
			int b = 0;
			System.out.println("Start");
			System.out.println(a / b);
			int[] arry = null;
			arry[0] = 1;
			System.out.println("End");
		} catch (ArithmeticException aE) {
			System.out.println(" Arithmetic exception : " + aE.getMessage());
		} catch (NullPointerException nPE) {
			System.out.println(" Null Pointer Exception : " + nPE.getMessage());
		} catch (Exception e) {
			System.out.println(" All Exception L " + e.getMessage());
		}
	}
}
