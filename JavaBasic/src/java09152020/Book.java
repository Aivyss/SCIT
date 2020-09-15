package java09152020;

public class Book {
	// Member variables
	String title; 
	int page;
	int price;
	
	//--------------------------------------------------------------------------------
	
	// get Method (title)
	public String getTitle() { // 다른 클래스에서 이 메소드를 사용 시 변수 반환.
		return title;
	}
	
	// set Method (title)
	public void setTitle(String bookTitle) { // 다른 클래스에서 이 메소드를 이용해 변수 입력
		title = bookTitle;
	}
	
	//--------------------------------------------------------------------------------
	
	// get Method (price)
	public int getPrice() { 
		return price;
	}
	
	// set Method (price)
	public void setPrice(int bookPrice) { 
		price = bookPrice;
	}
	
	//--------------------------------------------------------------------------------
	
	// get Method (page)
	public int getPage() { 		
		return page;
	}

	// set Method (page)
	public void setPage(int bookPage) { 
		page = bookPage;
	}
	
	//--------------------------------------------------------------------------------
	
	// Print book informations Method
	public void printBookInfo() {
		System.out.println("Title : " + title + "\nPage : " + page + "\nPrice : " + price);
	}
}