package java09282020;

public class Main {

	public static void main(String[] args) {
		String name1 = "Deep Work";
		String name2 = new String("Justice");
		String test = "Deep Work";
		BookTestCalss book1 = new BookTestCalss();
		BookTestCalss book2 = new BookTestCalss();
		BookTestCalss book3 = book1;
		book1.setName(name1);
		book2.setName(name2);
		
		// Object 클래스로부터 상속받은 메서드
		// 두 객체의 주소가 일치하는지 확인함.
		boolean flag1 = book1.equals(book1);
		boolean flag2 = book1.equals(book3);
		System.out.println(flag1);
		System.out.println(flag2);
		
		// String.equals()는 주소비교가 아니다. 값을 비교한다.
		System.out.println(test.equals(name1));
		// 이것은 주소 비교
		System.out.println(test == name1);
	}

}
