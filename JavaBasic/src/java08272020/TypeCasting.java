/*
 * Type casting basic
 */
package java08272020;

public class TypeCasting {

	public static void main(String[] args) {
		int i = 10;
		short s = 20;
		char c = 'A';
		double d;
		byte b;
		
		d = i;
		b = (byte)s;
		
		System.out.println(i);
		System.out.println(s);
		System.out.println((int)c);
		System.out.println(d);
		System.out.println(b);

	}

}
