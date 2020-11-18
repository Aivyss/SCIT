package test.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import board.mgr.BoardManager;
import board.vo.Board;

/**
 * 게시판 프로그램의 사용자 화면
 */
public class BoardUI {
	private BoardManager mgr = new BoardManager();
	private Scanner sc = new Scanner(System.in); 	//키보드로부터 입력받기 위한 클래스의 객체
	
	/**
	 * 생성자. 메뉴화면을 띄우고 사용자의 입력을 받는다.
	 * */
	public BoardUI() {
		while (true) {
			try {
				printMainMenu();
				int selector = inputInteger();
				
				if (selector == 1) {
					insert();
				} else if (selector == 2) {
					list();
				} else if (selector == 3) {
					read();
				} else if (selector == 4) {
					delete();
				} else if (selector == 5) {
					search();
				} else if (selector == 9) {
					System.out.println("");
					break;
				} else {
					InputMismatchException ie = new InputMismatchException();
					throw ie;
				}
			} catch (InputMismatchException ie) {
				System.out.println("[에러] 번호를 다시 선택하세요.");
			} 
		}
		
	}

	
	/**
	 * 메인 메뉴를 출력한다.
	 * */
	private void printMainMenu(){
		System.out.println("[게시판 연습]");
		System.out.println("1. 글 쓰기");
		System.out.println("2. 글 전체 목록");
		System.out.println("3. 글 읽기");
		System.out.println("4. 글 삭제");
		System.out.println("5. 글 검색");
		System.out.println("9. 프로그램 종료");
		System.out.print("* 메뉴 번호를 선택하세요 > ");
	}
	
	
	/**
	 * 글쓰기
	 */
	void insert() {
		String name, title, content, print;
		
		System.out.print("이름: ");
		name = sc.nextLine();
		System.out.print("제목: ");
		title = sc.nextLine();
		System.out.print("내용: ");
		content = sc.nextLine();
		
		Board vo = new Board(name, title, content);
		print = (mgr.insertBoard(vo)) ? "저장되었습니다." : "저장 실패하였습니다.";
		System.out.println(print);
	}
	
	
	
	
	/**
	 * 전체 글 목록
	 */
	void list() {
		List<Board> list = mgr.listBoard();
		if (list != null) {
			for (Board board : list) {
				System.out.println("번호:" + board.getBoardnum() + "\t작성자:" + board.getName() + "\t제목:" + board.getTitle());
			}
		} else {
			System.out.println("글이 없습니다.");
		}
	}
	
	
	
	
	
	/**
	 * 글 1개 읽기
	 */
	void read() {
		System.out.print("* 읽을 글 번호: ");
		int boardnum= inputInteger();
		
		Board searched = mgr.readBoard(boardnum);
		if (searched!=null) {
			System.out.println("번호: " + searched.getBoardnum());
			System.out.println("작성자: " + searched.getName());
			System.out.println("조회수: " + searched.getHits() );
			System.out.println("작성날짜: " + searched.getIndate() );
			System.out.println("제목: " + searched.getTitle());
			System.out.println("내용: " + searched.getContent());
		} else {
			System.out.println("해당 번호의 글이 없습니다.");
		}
	}

	

	/**
	 * 글 1개 삭제
	 */
	void delete() {
		System.out.print("* 읽을 글 번호: ");
		int boardnum= inputInteger();
		
		String result = (mgr.deleteBoard(boardnum)) ? "삭제되었습니다." : "해당 번호의 글이 없습니다.";
		System.out.println(result);
	}
	
	/**
	 * 검색
	 */
	void search() {
		System.out.print("제목을 입력해주세요 > ");
		String word = sc.nextLine();
		
		List<Board> list = mgr.searchBoard(word);
		
		if(list != null) {
			for (Board b : list) {
				System.out.println("번호:" + b.getBoardnum() + "\t작성자:" + b.getName()+ "\t제목:" + b.getTitle());
			}
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
		
	}
	
	
	
	
	public int inputInteger() {
		int num = 100;
		
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			throw e;
		} finally {
			sc.nextLine();
		}
		
		return num;
	}

}
