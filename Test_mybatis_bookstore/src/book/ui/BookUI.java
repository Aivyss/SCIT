package book.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import book.mgr.BookManager;
import book.vo.BookVO;

/**
 * 서점 관리 사용자 인터페이스
 */
public class BookUI {

	/**
	 * 도서 정보 처리 기능을 담당하는 클래스의 객체
	 */
	BookManager mgr;
	/**
	 * 키보드 입력 기능의 객체
	 */
	Scanner scan;
	
	/**
	 * 기본 생성자 - 현재 객체 최초 생성시 BookDAO와 Scanner 클래스의 객체를 생성하여 사용한다.
	 */
	public BookUI() {
		mgr = new BookManager();
		scan = new Scanner(System.in);
		boolean flag = true;
		
		while (flag) {
			try {
				int selector = printMenu();
				
				switch(selector) {
					case 1:
						input();
						break;
					case 2:
						output();
						break;
					case 3:
						delete();
						break;
					case 4:
						update();
						break;
					case 5:
						search();
						break;
					case 6:
						search2();
						break;
					case 0:
						System.out.println("[알림] 프로그램을 종료합니다.");
						flag = false;
						break;
					default:
						System.out.println("[알림] 다시 입력하세요.");
						break;
				}
			} catch (Exception e) {
				// " 숫자가 아닌 데이터를 입력 받았을 경우의 처리는 하지 않는다. " 이므로 어떠한 처리를 하지 않았습니다.
			}
		} // while end
	}
	
	/**
	 * 메뉴 출력 화면 & 메뉴 번호 입력
	 * @return 사용자가 입력한 메뉴 번호
	 */
	public int printMenu() {
		System.out.println("[ 서점 관리 ]");
		System.out.println("1. 도서정보 등록");
		System.out.println("2. 전체목록 출력");
		System.out.println("3. 도서정보 삭제");
		System.out.println("4. 도서정보 수정");
		System.out.println("5. 검색");
		System.out.println("6. 출판사별 검색");
		System.out.println("0. 프로그램 종료");
		System.out.print("* 번호선택: ");
		int selector = inputInteger();
		
		return selector;
	}

	/**
	 * 새 도서정보 등록 화면
	 */
	public void input() {
		String title, author, publisher;
		int price;
		
		System.out.print("제목: ");
		title = scan.nextLine();
		System.out.print("저자: ");
		author = scan.nextLine();
		System.out.print("출판사: ");
		publisher = scan.nextLine();
		System.out.print("가격: ");
		price = inputInteger();
		BookVO vo = new BookVO(title, author, publisher, price);
		
		// 입력처리 및 분기를 통한 알림메세지 출력
		System.out.println((mgr.insertBook(vo)) ? "[알림] 저장되었습니다." : "[알림] 저장 실패하였습니다.");
	}
	
	/**
	 * 전체 도서목록 출력 화면
	 */
	public void output() {
		System.out.println("번호\t제목\t저자\t출판사\t가격\t등록일");
		System.out.println("===================================================");
		for (BookVO book : mgr.listAll()) {
			System.out.println(book.toString());
		}
	}
	
	/**
	 * 번호로 정보 삭제 화면
	 */
	public void delete() {
		System.out.print("삭제할 번호: ");
		int bnum = inputInteger();
		
		// 삭제처리 및 분기를 통한 알림메세지 출력
		System.out.println((mgr.deleteBook(bnum)) ? "[알림] 삭제되었습니다." : "[알림] 삭제할 데이터가 없습니다.");
	}
	
	/**
	 * 도서정보 수정 화면
	 */
	public void update() {
		System.out.print("수정할 도서번호: ");
		int bnum = inputInteger();
		BookVO book = mgr.getBook(bnum);
		
		if (book != null) {
			System.out.println("* 기존 정보");
			System.out.println("번호: " + book.getBnum());
			System.out.println("제목: " + book.getTitle());
			System.out.println("저자: " + book.getAuthor());
			System.out.println("출판사: " + book.getPublisher());
			System.out.println("가격: " + book.getPrice());
			System.out.println("===============================");
			System.out.println("* 수정할 정보");
			System.out.print("제목: ");
			book.setTitle(scan.nextLine());
			System.out.print("저자: ");
			book.setAuthor(scan.nextLine());
			System.out.print("출판사: ");
			book.setPublisher(scan.nextLine());
			System.out.print("가격: ");
			book.setPrice(inputInteger());
			
			// 수정처리 및 분기를 통한 알림메세지 출력
			System.out.println((mgr.updateBook(book)) ? "[알림] 수정되었습니다." : "[알림] 수정 실패하였습니다.");
		} else {
			System.out.println("[알림] 수정할 데이터가 없습니다.");
		}
			
	}
	
	
	/**
	 * 검색 화면
	 */
	public void search() {
		System.out.print("검색할 제목: ");
		String text = scan.nextLine();
		ArrayList<BookVO> list = mgr.searchBook(text);
		
		if (list !=null && !list.isEmpty()) {
			System.out.println("번호\t제목\t저자\t출판사\t가격\t등록일");
			System.out.println("========================================");
			for (BookVO book : list) {
				System.out.println(book.toString());
			}
		} else {
			System.out.println("[알림] 검색 결과가 없습니다.");
		}
	}
	
	/**
	 * 출판사별 검색 화면
	 */
	public void search2() {
		ArrayList<BookVO> list = mgr.searchPublisher();
		
		if (list!=null && !list.isEmpty()) {
			for (BookVO book : list) {
				System.out.println("출판사: " + book.getPublisher() + "\t최소가격:" + book.getPrice());
			}
		} else {
			System.out.println("[알림] 검색 결과가 없습니다.");
		}
	}
	
	/**
	 * 인풋 인티저 메소드
	 * @return integer
	 */
	private int inputInteger() {
		int num = 0;
		
		try {
			num = scan.nextInt();
		} catch (InputMismatchException e) {
			throw e;
		} finally {
			scan.nextLine();
		}
		
		return num;
	}
}
