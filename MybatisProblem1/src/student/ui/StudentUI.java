//사용자 화면
package student.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import student.mgr.StudentManager;
import student.vo.Student;

public class StudentUI {
	Scanner scan = new Scanner(System.in);
	StudentManager mgr = new StudentManager();

	public StudentUI() {
		try {
			boolean flag = true;
			
			while (flag) {
				menuPrint();
				int m = inputInteger();

				switch (m) {
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
				case 0:
					System.out.println("프로그램을 종료합니다.");
					flag = false;
					break;
				default:
					System.out.println("다시 선택하세요.");
				}
			}
		} catch (InputMismatchException e) {
			e = new InputMismatchException("[에러] 잘못 입력하셨습니다.");
			System.out.println(e.getMessage());
		}
	}

	// 메뉴 출력
	public void menuPrint() {
		System.out.println();
		System.out.println("[ 학생 성적 관리 ]");
		System.out.println("1. 입력");
		System.out.println("2. 전체 출력");
		System.out.println("3. 삭제");
		System.out.println("4. 수정");
		System.out.println("5. 검색");
		System.out.println("0. 종료");
		System.out.print("선택 > ");
	}

	// 입력
	public void input() {
		String id, name;
		int k, e, m;
		boolean n;

		System.out.println("[ 성적 입력 ]");
		System.out.print("학번 : ");
		id = scan.nextLine();
		System.out.print("이름 : ");
		name = scan.nextLine();
		System.out.print("국어 점수 : ");
		k = inputInteger();
		System.out.print("영어 점수 : ");
		e = inputInteger();
		System.out.print("수학 점수 : ");
		m = inputInteger();

		Student s = new Student(id, name, k, e, m);
		n = mgr.insert(s);

		if (!n) {
			System.out.println("[에러] 저장 실패");
		} else {
			System.out.println("[알림] 저장되었습니다.");
		}
	}

	// 전체 출력
	public void output() {
		List<Student> list = mgr.selectAll();

		System.out.println("[ 전체 학생 정보 ]");
		System.out.println("학번\t이름\t국어\t영어\t수학\t평균");

		if (list == null || list.size() == 0) {
			System.out.println("* 저장된 데이터가 없습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		}
	}

	// 삭제
	public void delete() {
		String id;
		boolean n;

		System.out.println("[ 삭제 ]");
		System.out.print("삭제할 학번 : ");
		id = scan.nextLine();

		n = mgr.delete(id);

		if (!n) {
			System.out.println("* 해당되는 학번이 없습니다.");
		} else {
			System.out.println("* " + 1 + "건이 삭제되었습니다.");
		}
	}

	// 수정
	public void update() {
		String id, name;
		int k, e, m;
		boolean n;

		System.out.println("[ 수정 ]");
		System.out.print("수정할 학번 : ");
		id = scan.nextLine();
		System.out.print("이름 : ");
		name = scan.nextLine();
		System.out.print("국어 점수 : ");
		k = scan.nextInt();
		System.out.print("영어 점수 : ");
		e = scan.nextInt();
		System.out.print("수학 점수 : ");
		m = scan.nextInt();

		Student s = new Student(id, name, k, e, m);
		n = mgr.update(s);

		if (!n) {
			System.out.println("* 수정 실패");
		} else {
			System.out.println("* 수정되었습니다.");
		}
	}

	// 이름으로 검색
	public void search() {
		List<Student> list;
		String name;

		System.out.println("[ 검색 ]");
		System.out.print("검색할 이름 : ");
		name = scan.nextLine();

		list = mgr.selectName(name);

		if (list == null || list.size() == 0) {
			System.out.println("* 저장된 데이터가 없습니다.");
		} else {
			System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}

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
