package java09152020;

public class BookMain {
	public static void main(String[] args) {
		// Generate Objects
		Book ngsk = new Book();
		Book book2 = new Book();
		
		// Object Method Usage
		ngsk.setTitle("人間失格");
		ngsk.setPrice(15000);
		ngsk.setPage(160);
		
		book2.setTitle("君の名前は");
		book2.setPrice(9000);
		book2.setPage(235);
		
		ngsk.printBookInfo();
		book2.printBookInfo();
		
		System.out.println(ngsk.getTitle());
		System.out.println(ngsk.getPrice());
		System.out.println(ngsk.getPage());
		
		System.out.println(book2.getTitle());
		System.out.println(book2.getPrice());
		System.out.println(book2.getPage());
	}
}

