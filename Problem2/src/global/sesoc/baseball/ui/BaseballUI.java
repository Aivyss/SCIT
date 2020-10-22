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
	Scanner input = new Scanner(System.in);
	BaseballManager manager = new BaseballManager();

	/**
	 * 생성자
	 */
	public BaseballUI()  {
		int menuNum = -1;

		// 프로그램 종료시까지 무한 반복
		while (true) {
			this.printMainMenu();
			try {
				menuNum = input.nextInt();
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
			} finally {
				input.nextLine(); // 엔터제거
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
		try {
			System.out.print("선수 고유 번호 > ");
			String id = input.nextLine();

			if (manager.searchId(id) != null) {
				System.out.println("[알림] 이미 존재하는 번호입니다.");
			} else {
				// 선수 포지션 선택화면 출력
				System.out.println("[  선수 등록  ]");
				System.out.println("1. 투수");
				System.out.println("2. 타자");
				System.out.print("** 선수 구분 선택 > ");
				int selector = input.nextInt();
				input.nextLine(); // 엔터 처리용	
				
				// 변수 정의
				List<Object> playerInfo = new ArrayList<>();		
				Player vo = null;
				
				playerInfo.add(id);
				System.out.print("선수 이름 > ");
				playerInfo.add(input.nextLine());
				System.out.print("소속팀 > ");
				playerInfo.add(input.nextLine());
				System.out.print("연봉 > ");
				playerInfo.add(input.nextInt());
				System.out.print("WAR > ");
				playerInfo.add(input.nextDouble());
				
				if (selector == 1) {
					System.out.print("평균 자책 > ");
					playerInfo.add(input.nextDouble());
					System.out.print("이닝 > ");
					playerInfo.add(input.nextInt());
					System.out.print("승 > ");
					playerInfo.add(input.nextInt());
					System.out.print("패 > ");
					playerInfo.add(input.nextInt());
					System.out.print("세이브 > ");
					playerInfo.add(input.nextInt());
					System.out.print("홀드 > ");
					playerInfo.add(input.nextInt());
					
					vo = new Pitcher(playerInfo);
					manager.insertPlayer(vo);
					System.out.println("[정보] 저장되었습니다.");
				} else if (selector == 2) {
					System.out.print("타율 > ");
					playerInfo.add(input.nextDouble());
					System.out.print("타수 > ");
					playerInfo.add(input.nextInt());
					System.out.print("타점 > ");
					playerInfo.add(input.nextInt());
					System.out.print("득점 > ");
					playerInfo.add(input.nextInt());
					
					vo = new Batter(playerInfo);
					manager.insertPlayer(vo);
					System.out.println("[정보] 저장되었습니다.");
				}
			}
		} catch (InputMismatchException e) {
			throw e;
		}
	}

	/**
	 * 선수 정보 삭제
	 */
	public void delete() throws InputMismatchException {
		try {
			System.out.print("** 삭제할 선수 번호 > ");
			String id = input.nextLine();
			boolean flag = manager.deletePlayer(id);

			if (flag) {
				System.out.println("[정보] 삭제되었습니다.");
			} else {
				System.out.println("[정보] 삭제 대상이 존재하지 않습니다.");
			}
		} catch (InputMismatchException e) {
			throw e;
		}
	}

	/**
	 * 선수 정보 수정
	 */
	public void update() throws InputMismatchException {
		try {
			System.out.print("** 수정할 선수 번호 > ");
			String id = input.nextLine();
			Player vo = manager.searchId(id);

			if (vo == null || "".equals(vo.getId())) {
				System.out.println("[오류] 해당 번호의 선수 정보가 없습니다.");
			} else {
				System.out.print("수정할 선수 연봉 > ");
				vo.setSalary(input.nextInt());
				manager.updatePlayer(vo);
			}
		} catch (InputMismatchException e) {
			throw e;
		}
	}

	/**
	 * 선수 정보 검색
	 */
	public void search() throws InputMismatchException {
		try {
			int selector = -1;
			System.out.println("[\t검색\t]");
			System.out.println("1. 전체");
			System.out.println("2. 투수");
			System.out.println("3. 타자");
			System.out.println("4. 베스트 플레이어");
			System.out.println("5. 연봉 검색");
			System.out.print("** 메뉴 선택 > ");
			selector = input.nextInt();
			input.nextLine(); // 엔터제거
			
			List<Player> list = null;
//			if (selector == 1) {
//				list = manager.playerListForType(1);
//			} else if (selector == 2) {
//				list = manager.playerListForType(2);
//			} else if (selector == 3) {
//				list = manager.playerListForType(3);
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
		} catch (InputMismatchException e) {
			throw e;
		}
	}

	/**
	 * 목록 출력
	 * @param list
	 */
	public void print(List<Player> list) {
		int index = 0;
		
		if (list == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			if (list.isEmpty()) {
				index = 0;
			} else {
				for (Player vo : list) {
					index++;
					System.out.println(vo);
				}
			}
			System.out.println("총 " + index + "건의 검색 결과가 있습니다.");
		}
	}

	/**
	 * 프로그램 종료
	 */
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

}
