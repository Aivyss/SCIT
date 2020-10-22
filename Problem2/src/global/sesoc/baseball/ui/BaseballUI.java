package global.sesoc.baseball.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import global.sesoc.baseball.manager.BaseballManager;
import global.sesoc.baseball.vo.Batter;
import global.sesoc.baseball.vo.Pitcher;
import global.sesoc.baseball.vo.Player;

/**
 * 사용자 인터페이스
 */
public class BaseballUI {
	private Scanner input = new Scanner(System.in);
	private BaseballManager manager = new BaseballManager();

	/**
	 * 생성자
	 */
	public BaseballUI()  {
		int menuNum = -1;

		// 프로그램 종료시까지 무한 반복
		while (true) {
			this.printMainMenu();
			try {
				menuNum = this.inputInteger();
				if (menuNum == 1) {
					this.add();
				} else if (menuNum == 2) {
					this.delete();
				} else if (menuNum == 3) {
					this.update();
				} else if (menuNum == 4) {
					this.search();
				} else if (menuNum == 0) {
					this.exit();
					break;
				} else {
					System.out.println("[오류] 다시 선택하세요.");
					System.out.println("=======[구분선]=======");
				}
			} catch (InputMismatchException e) {
				e = new InputMismatchException("[오류] 입력형식이 잘못되었습니다");
				System.out.println(e.getMessage());
			} 		
		}
	}

	/**
	 * 메인 메뉴 출력
	 */
	public void printMainMenu() {
		System.out.println("[  야구 선수 정보 관리   ]");
		System.out.println("1. 선수 정보 입력");
		System.out.println("2. 선수 정보 삭제");
		System.out.println("3. 선수 정보 수정");
		System.out.println("4. 검색");
		System.out.println("0. 프로그램 종료");
		System.out.print("** 번호 선택 >");
	}

	/**
	 * 선수 정보 입력
	 */
	public void add() throws InputMismatchException {
		System.out.print("선수 고유 번호 > ");
		String id = this.inputString();

		if (manager.searchId(id) != null) {
			System.out.println("[알림] 이미 존재하는 번호입니다.");
		} else {
			// 선수 포지션 선택화면 출력
			System.out.println("[  선수 등록  ]");
			System.out.println("1. 투수");
			System.out.println("2. 타자");
			System.out.print("** 선수 구분 선택 > ");
			int selector = this.inputInteger();
			
			// 변수 정의
			List<Object> playerInfo = new ArrayList<>();		
			Player vo = null;
			
			playerInfo.add(id);
			System.out.print("선수 이름 > ");
			playerInfo.add(this.inputString());
			System.out.print("소속팀 > ");
			playerInfo.add(this.inputString());
			System.out.print("연봉 > ");
			playerInfo.add(this.inputInteger());
			System.out.print("WAR > ");
			playerInfo.add(this.inputDouble());
			
			if (selector == 1) {
				System.out.print("평균 자책 > ");
				playerInfo.add(this.inputDouble());
				System.out.print("이닝 > ");
				playerInfo.add(this.inputInteger());
				System.out.print("승 > ");
				playerInfo.add(this.inputInteger());
				System.out.print("패 > ");
				playerInfo.add(this.inputInteger());
				System.out.print("세이브 > ");
				playerInfo.add(this.inputInteger());
				System.out.print("홀드 > ");
				playerInfo.add(input.nextInt());
				
				vo = new Pitcher(playerInfo);
				manager.insertPlayer(vo);
				System.out.println("[정보] 저장되었습니다.");
			} else if (selector == 2) {
				System.out.print("타율 > ");
				playerInfo.add(this.inputDouble());
				System.out.print("타수 > ");
				playerInfo.add(this.inputInteger());
				System.out.print("타점 > ");
				playerInfo.add(this.inputInteger());
				System.out.print("득점 > ");
				playerInfo.add(this.inputInteger());
				
				vo = new Batter(playerInfo);
				manager.insertPlayer(vo);
				System.out.println("[정보] 저장되었습니다.");
			}
		}
	}

	/**
	 * 선수 정보 삭제
	 */
	public void delete() throws InputMismatchException {
		System.out.print("** 삭제할 선수 번호 > ");
		String id = this.inputString();
		boolean flag = manager.deletePlayer(id);

		if (flag) {
			System.out.println("[정보] 삭제되었습니다.");
		} else {
			System.out.println("[정보] 삭제 대상이 존재하지 않습니다.");
		}
	}

	/**
	 * 선수 정보 수정
	 */
	public void update() throws InputMismatchException {
		System.out.print("** 수정할 선수 번호 > ");
		String id = this.inputString();
		Player vo = manager.searchId(id);

		if (vo == null || "".equals(vo.getId())) {
			System.out.println("[오류] 해당 번호의 선수 정보가 없습니다.");
		} else {
			System.out.print("수정할 선수 연봉 > ");
			vo.setSalary(input.nextInt());
			manager.updatePlayer(vo);
		}
	}

	/**
	 * 선수 정보 검색
	 */
	public void search() throws InputMismatchException {
		int selector = -1;
		System.out.println("[\t검색\t]");
		System.out.println("1. 전체");
		System.out.println("2. 투수");
		System.out.println("3. 타자");
		System.out.println("4. 베스트 플레이어");
		System.out.println("5. 연봉 검색");
		System.out.print("** 메뉴 선택 > ");
		selector = this.inputInteger();
		
		List<Player> list = null;
//		if (selector == 1) {
//			list = manager.playerListForType(1);
//		} else if (selector == 2) {
//			list = manager.playerListForType(2);
//		} else if (selector == 3) {
//			list = manager.playerListForType(3);
		if(selector >=1 && selector<=3) {
			list = manager.playerListForType(selector);
			
			
		} else if (selector == 4) {
			list= manager.bestPlayers();
		} else if (selector == 5) {
			System.out.print("최저 연봉: ");
			int minSalary = input.nextInt();
			System.out.print("최고 연봉: ");
			int maxSalary = input.nextInt();
			list = manager.playerListForSalary(minSalary, maxSalary);
		}
		this.print(list);
	}

	/**
	 * 목록 출력
	 * @param list
	 */
	public void print(List<Player> list) {		
		if (list == null || list.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for (Player vo : list) {
				System.out.println(vo);
			}
			System.out.println("총 " + list.size() + "건의 검색 결과가 있습니다.");
		}
	}
	/**
	 * input 메서드
	 * @return int type
	 */
	public int inputInteger() {
		int integer = -1;
		
		try {
			integer = input.nextInt();
			input.nextLine();
		} catch (InputMismatchException e) {
			input.nextLine();
			throw e;
		}
		
		return integer;
	}
	
	/**
	 * Input 메서드
	 * @return String type
	 */
	public String inputString() {
		String str = "";
		
		try {
			str = input.nextLine();
		} catch (InputMismatchException e) {
			throw e;
		}
		
		return str;
	}
	/**
	 * Input 메서드
	 * @return double type
	 */
	public double inputDouble() {
		double dub = -1;
		
		try {
			dub = input.nextDouble();
			input.nextLine();
		} catch (InputMismatchException e) {
			input.nextLine();
			throw e;
		}
		
		return dub;
	}
	
	/**
	 * 프로그램 종료
	 */
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

}
