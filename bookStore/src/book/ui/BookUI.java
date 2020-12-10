package book.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import book.mgr.BookManager;
import book.vo.BookVO;

/**
 * ���� ���� ����� �������̽�
 */
public class BookUI {

	/**
	 * ���� ���� ó�� ����� ����ϴ� Ŭ������ ��ü
	 */
	BookManager mgr;
	/**
	 * Ű���� �Է� ����� ��ü
	 */
	Scanner scan;
	
	/**
	 * �⺻ ������ - ���� ��ü ���� ������ BookDAO�� Scanner Ŭ������ ��ü�� �����Ͽ� ����Ѵ�.
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
						System.out.println("[�˸�] ���α׷��� �����մϴ�.");
						flag = false;
						break;
					default:
						System.out.println("[�˸�] �ٽ� �Է��ϼ���.");
						break;
				}
			} catch (Exception e) {
				// " ���ڰ� �ƴ� �����͸� �Է� �޾��� ����� ó���� ���� �ʴ´�. " �̹Ƿ� ��� ó���� ���� �ʾҽ��ϴ�.
			}
		} // while end
	}
	
	/**
	 * �޴� ��� ȭ�� & �޴� ��ȣ �Է�
	 * @return ����ڰ� �Է��� �޴� ��ȣ
	 */
	public int printMenu() {
		System.out.println("[ ���� ���� ]");
		System.out.println("1. �������� ���");
		System.out.println("2. ��ü��� ���");
		System.out.println("3. �������� ����");
		System.out.println("4. �������� ����");
		System.out.println("5. �˻�");
		System.out.println("6. ���ǻ纰 �˻�");
		System.out.println("0. ���α׷� ����");
		System.out.print("* ��ȣ����: ");
		int selector = inputInteger();
		
		return selector;
	}

	/**
	 * �� �������� ��� ȭ��
	 */
	public void input() {
		String title, author, publisher;
		int price;
		
		System.out.print("����: ");
		title = scan.nextLine();
		System.out.print("����: ");
		author = scan.nextLine();
		System.out.print("���ǻ�: ");
		publisher = scan.nextLine();
		System.out.print("����: ");
		price = inputInteger();
		BookVO vo = new BookVO(title, author, publisher, price);
		
		// �Է�ó�� �� �б⸦ ���� �˸��޼��� ���
		System.out.println((mgr.insertBook(vo)) ? "[�˸�] ����Ǿ����ϴ�." : "[�˸�] ���� �����Ͽ����ϴ�.");
	}
	
	/**
	 * ��ü ������� ��� ȭ��
	 */
	public void output() {
		System.out.println("��ȣ\t����\t����\t���ǻ�\t����\t�����");
		System.out.println("===================================================");
		for (BookVO book : mgr.listAll()) {
			System.out.println(book.toString());
		}
	}
	
	/**
	 * ��ȣ�� ���� ���� ȭ��
	 */
	public void delete() {
		System.out.print("������ ��ȣ: ");
		int bnum = inputInteger();
		
		// ����ó�� �� �б⸦ ���� �˸��޼��� ���
		System.out.println((mgr.deleteBook(bnum)) ? "[�˸�] �����Ǿ����ϴ�." : "[�˸�] ������ �����Ͱ� �����ϴ�.");
	}
	
	/**
	 * �������� ���� ȭ��
	 */
	public void update() {
		System.out.print("������ ������ȣ: ");
		int bnum = inputInteger();
		BookVO book = mgr.getBook(bnum);
		
		if (book != null) {
			System.out.println("* ���� ����");
			System.out.println("��ȣ: " + book.getBnum());
			System.out.println("����: " + book.getTitle());
			System.out.println("����: " + book.getAuthor());
			System.out.println("���ǻ�: " + book.getPublisher());
			System.out.println("����: " + book.getPrice());
			System.out.println("===============================");
			System.out.println("* ������ ����");
			System.out.print("����: ");
			book.setTitle(scan.nextLine());
			System.out.print("����: ");
			book.setAuthor(scan.nextLine());
			System.out.print("���ǻ�: ");
			book.setPublisher(scan.nextLine());
			System.out.print("����: ");
			book.setPrice(inputInteger());
			
			// ����ó�� �� �б⸦ ���� �˸��޼��� ���
			System.out.println((mgr.updateBook(book)) ? "[�˸�] �����Ǿ����ϴ�." : "[�˸�] ���� �����Ͽ����ϴ�.");
		} else {
			System.out.println("[�˸�] ������ �����Ͱ� �����ϴ�.");
		}
			
	}
	
	
	/**
	 * �˻� ȭ��
	 */
	public void search() {
		System.out.print("�˻��� ����: ");
		String text = scan.nextLine();
		ArrayList<BookVO> list = mgr.searchBook(text);
		
		if (list !=null && !list.isEmpty()) {
			System.out.println("��ȣ\t����\t����\t���ǻ�\t����\t�����");
			System.out.println("========================================");
			for (BookVO book : list) {
				System.out.println(book.toString());
			}
		} else {
			System.out.println("[�˸�] �˻� ����� �����ϴ�.");
		}
	}
	
	/**
	 * ���ǻ纰 �˻� ȭ��
	 */
	public void search2() {
		ArrayList<BookVO> list = mgr.searchPublisher();
		
		if (list!=null && !list.isEmpty()) {
			for (BookVO book : list) {
				System.out.println("���ǻ�: " + book.getPublisher() + "\t�ּҰ���:" + book.getPrice());
			}
		} else {
			System.out.println("[�˸�] �˻� ����� �����ϴ�.");
		}
	}
	
	/**
	 * ��ǲ ��Ƽ�� �޼ҵ�
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
