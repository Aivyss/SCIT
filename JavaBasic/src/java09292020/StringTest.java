package java09292020;

public class StringTest {

	public static void main(String[] args) {
		// .charAt()
		String str = new String("가나다라마바");
		for (int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
		//.compareTo()
		String str1 = new String("A");
		String str2 = new String("B");
		String str3 = new String("A");
		// str1 < str2 so, -1
		System.out.println(str1.compareTo(str2));	
		// if str1 > str2 then, +1 
		System.out.println(str2.compareTo(str1));
		// if str1 == str2 then, 0
		System.out.println(str3.compareTo(str1));
		
		// .concat()
		String str4 = new String("A");
		String str5 = new String("B");
		System.out.println(str4.concat(str5));
		// concat method simplifier
		System.out.println(str4+str5);
		
		// .contains()
		String str6 = new String("Hello, World");
		boolean flag1 = str6.contains("el");
		System.out.println(flag1);
		
		// .equalsIgnoreCase()
		String str7 = "Hello";
		String str8 = "hello";
		boolean flag2 = str7.equalsIgnoreCase(str8);
		System.out.println(flag2);
		
		// .indexOf()
		
		int indexOf = str7.indexOf('o'); //String str7 = "Hello";
		System.out.println(indexOf);
		
		// .lastIndexOf
		int lastIndexOf = str7.lastIndexOf('l'); // //String str7 = "Hello";
		int lastIndexOf2 = str7.lastIndexOf("l");
		System.out.println(lastIndexOf);
		System.out.println(lastIndexOf2);
		
		// .isEmpty()
		String str9 = "";
		String str10 = " ";
		System.out.println(str9.isEmpty());
		System.out.println(str10.isEmpty());
		
		// .substring(int start) .substring(int start, int end)
		String str11 = "Hello World";
		String str12 = str11.substring(4);
		System.out.println(str12);
		String str13 = str11.substring(4, 7); // 4포함 7 미포함
		System.out.println(str13);
	}

}
