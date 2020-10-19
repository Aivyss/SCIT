package addressbook.ui;

import java.util.List;
import java.util.Scanner;

import addressbook.manager.AddressManager;
import addressbook.vo.AddressVO;

/**
 * 사용자 화면을 구성하고 키보드로부터의 입력을 담당하는 클래스
 */
public class AddressUI {
	/**
	 * 주소 정보 처리 기능을 담당하는 클래스의 객체
	 */
	AddressManager manager;
	/**
	 * 키보드 입력 기능의 객체
	 */
	Scanner scan;

	/**
	 * 기본 생성자 - 현재 객체 최초 생성시 AddressManager와 Scanner 클래스의 객체를 생성하여 사용한다.
	 */
	public AddressUI() {
		this.manager = new AddressManager();
		this.scan = new Scanner(System.in);
	}

	/**
	 * 메뉴 출력 화면 & 메뉴 번호 입력 - 끝
	 * 
	 * @return 사용자가 입력한 메뉴 번호
	 */
	public int menu() {
		int num = 0;
		System.out.println("[  주소록    ]");
		System.out.println("1. 새 주소 등록");
		System.out.println("2. 주소록 출력");
		System.out.println("3. 이름 검색");
		System.out.println("4. 그룹 검색");
		System.out.println("5. 주소 삭제");
		System.out.println("0. 프로그램 종료");

		System.out.print("번호선택: ");
		num = scan.nextInt();
		if (!(num >= 0 && num <= 5)) {
			System.out.println("[알림] 다시 입력하세요.");
		}

		scan.nextLine();
		return num;
	}

	/**
	 * 새 주소 정보 입력 화면 - 끝
	 */
	public void input() {
		System.out.print("등록할 이름: ");
		String str = scan.nextLine();
		AddressVO vo = new AddressVO();
		AddressVO search = manager.getAddress(str);

		if (search == null) {
			vo.setName(str);
			System.out.print("그룹: ");
			str = scan.nextLine();
			vo.setGroup(str);
			System.out.print("전화: ");
			str = scan.nextLine();
			vo.setPhone(str);
			System.out.print("주소: ");
			str = scan.nextLine();
			vo.setAddress(str);
			System.out.print("이메일: ");
			str = scan.nextLine();
			vo.setEmail(str);
			manager.addAddress(vo);
			System.out.print("[알림] 등록되었습니다.");
		} else {
			System.out.println("[알림] 이미 등록된 이름입니다.");
		}
	}

	/**
	 * 전체 정보 출력 화면 - 끝
	 */
	public void output() {
		if (manager.getList().size() <= 0) {
			System.out.println("[알림] 등록된 데이터가 없습니다.");
		} else {
			for (AddressVO vo : manager.getList()) {
				System.out.println(vo.toString());
			}
		}
	}

	/**
	 * 이름으로 주소 검색 화면 - 끝
	 */
	public void searchName() {
		System.out.print("검색할 이름: ");
		String name = scan.nextLine();
		AddressVO vo = manager.getAddress(name);
		if (vo == null || name.equals(vo.getName())) {
			System.out.println("[알림] 검색 결과가 없습니다.");
		} else {
			System.out.println(vo.toString());
		}

	}

	/**
	 * 그룹으로 주소 검색 - 끝
	 */
	public void searchGroup() {
		System.out.print("검색할 그룹: ");
		String group = scan.nextLine();
		List<AddressVO> groupSearch = manager.getGroupList(group);
		if (groupSearch.size() <= 0 || "".equals(group)) {
			System.out.println("[알림] 검색 결과가 없습니다.");
		} else {
			for (AddressVO vo : groupSearch) {
				System.out.println(vo.toString());
			}
		}

	}

	/**
	 * 이름으로 찾아서 주소 삭제 - 끝
	 */
	public void delete() {
		System.out.print("검색할 이름: ");
		String name = scan.nextLine();
		boolean flag = manager.removeAddress(name);

		if (flag) {
			System.out.println("[알림] 삭제되었습니다.");
		} else {
			System.out.println("[알림] 삭제할 데이터가 없습니다.");
		}
	}

	/**
	 * 프로그램 종료 시 마무리 작업
	 */
	public void end() {
		System.out.println("[알림] 프로그램을 종료합니다.");
	}
}