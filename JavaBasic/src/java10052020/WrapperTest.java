package java10052020;

public class WrapperTest {

	public static void main(String[] args) {
		byte b = 2;
		int in = 257;
		Byte bObject = new Byte(b);
		Integer intObject = new Integer(257);
		System.out.println(bObject);
		System.out.println(intObject);
		
		byte bb = bObject.byteValue();
		int inint = intObject.intValue();
		System.out.println(bb);
		System.out.println(inint);
		
		System.out.println(Integer.parseInt("10") + 5);
	}

}
