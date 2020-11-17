package user.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import user.mgr.UserManager;
import user.vo.User;

/**
 * 회원 관리 프로그램의 사용자 화면
 */
public class UserUI {
	private UserManager mgr = new UserManager();
	private Scanner sc = new Scanner(System.in); 	//키보드로부터 입력받기 위한 클래스의 객체
	
	/**
	 * 생성자. 메뉴화면을 띄우고 사용자의 입력을 받는다.
	 * */
	public UserUI() {
		try {
			while (true) {
				printMainMenu();
				int selector = inputInteger();
				
				if (selector == 1) {
					insert();
				} else if (selector == 2) {
					list();
				} else if (selector == 9) {
					System.out.println("[알림] 프로그램 종료");
					break;
				} else {
					System.out.println("[에러] 다시 입력하세요.");
				} 
			}
		} catch (InputMismatchException e) {
			System.out.println("[에러] 다시 입력하세요.");
		}
	}
	

	
	/**
	 * 메인 메뉴를 출력한다.
	 * */
	public void printMainMenu(){
		System.out.println("[ 회원 관리 ]");
		System.out.println("1. 회원정보 등록");
		System.out.println("2. 전체 회원 목록");
		System.out.println("9. 프로그램 종료");
		System.out.print("* 메뉴 번호를 선택하세요 > ");	
	}
	
	/**
	 * 회원정보 등록
	 */
	void insert() {
		HashMap<String, Object> info = new HashMap<>();
		User user = new User();
		System.out.print("ID: ");
		String id = sc.nextLine();
		String name = null;
		String gender = null;
		user.setId(id);
		user = mgr.searchUser(id);
		
		if (user == null) {
			info.put("id", id);
			System.out.print("이름: ");
			name = sc.nextLine();
			info.put("name", name);
			System.out.print("성별(남:M 여:F 입력): ");
			gender = inputGender();
			info.put("gender", gender);
			System.out.print("추가 정보를 입력?: ");
			boolean flag = inputBoolean();
			
			if (flag) {
				System.out.print("전화번호: ");
				info.put("phone", sc.nextLine());
				System.out.print("주소: ");
				info.put("address", sc.nextLine());
				
				user = new User(info);
			} else {
				user = new User(id, name, gender);
			}
			
			if(mgr.insertUser(user)) {
				System.out.println("회원 정보를 입력하였습니다.");
			} else {
				System.out.println("[에러] 회원가입 실패");
			}
		} else {
			System.out.println("[에러] 이미 있는 회원입니다.");
		}
	}
	
	/**
	 * 전체 회원 목록
	 */
	void list() {
		ArrayList<User> list = mgr.listUser();
		
		if (list == null) {
			System.out.println("[에러] 회원이 없습니다.");
		} else {
			System.out.println("아이디\t이름\t성별\t전화번호\t주소");
			
			for (User vo : list) {
				System.out.println(vo.toString());
			}
		}

	}

	private int inputInteger() {
		int num = 0;
		
		try {
			num = sc.nextInt();
		} catch (InputMismatchException e) {
			throw e;
		} finally {
			sc.nextLine();
		}
		
		return num;
	}
	
	private String inputGender() {
		String gender = sc.nextLine().toUpperCase();
		
		if (!(gender.equals("M") || gender.equals("F"))) {
			throw new InputMismatchException();
		} 
		
		return gender;
	}
	
	private boolean inputBoolean() {
		String temp = null;
		boolean flag = false;
		
		temp = sc.nextLine().toUpperCase();
		
		if(temp.equals("Y")) {
			flag = true;
		} else if (temp.equals("N")) {
			flag = false;
		} else {
			throw new InputMismatchException();
		}
		
		return flag;
	}

}
