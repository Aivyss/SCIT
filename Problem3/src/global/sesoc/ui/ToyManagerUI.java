package global.sesoc.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import global.sesoc.manager.ToyManagerMgr;
import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

/**
 * 사용자 인터페이스
 */
public class ToyManagerUI {
	Scanner input = new Scanner(System.in);
	ToyManagerMgr manager = new ToyManagerMgr();

	/**
	 * 생성자
	 */
	public ToyManagerUI() {
		int mNum = 0;

		while (true) {
			try {
				this.mainMenu();
				mNum = this.inputInteger();
				if (mNum == 1) {
					this.insertToy();
				} else if (mNum == 2) {
					this.searchToy();
				} else if (mNum == 3) {
					this.deleteToy();
				} else if (mNum == 4) {
					this.searchForPrice();
				} else if (mNum == 5) {
					this.groupSearch();
				} else if( mNum == 6) {
					this.updateToy();
				} else if (mNum == 9) {
					System.out.println("[알림] 프로그램을 종료합니다.");
					break;
				}
			} catch (InputMismatchException e) {
				e = new InputMismatchException("[에러] 잘못 입력하셨습니다!! 다시 입력하세요.");
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 주메뉴를 화면에 출력한다.
	 */
	public void mainMenu() {
		System.out.println("===== Toy Manager =====");
		System.out.println("1. 장난감 등록");
		System.out.println("2. 장난감 검색");
		System.out.println("3. 장난감 삭제");
		System.out.println("4. 가격대 검색");
		System.out.println("5. 장난감 정보 출력");
		System.out.println("6. 장난감 가격 수정");
		System.out.println("9. 종료");
		System.out.println("========================");
		System.out.print("[ 메뉴 선택 ]");
	}

	/**
	 * 장난감 추가를 위해 메뉴를 호출하고 해당 메뉴에 대한 선택을 입력받은 후 Toy 객체를 생성하는 makeToy() 메서드를 호출 한 후
	 * 리턴된 Toy 객체를 List에 삽입한다.
	 */
	public void insertToy() throws InputMismatchException {
		while (true) {
			this.insertMenu();
			int toyType = this.inputInteger();
			
			if (toyType != 9 && (toyType >= 1 && toyType <= 3)) {
				Toy toy = this.makeToy(toyType);
				
				if (toy != null) {
					manager.insertToy(toy);
					System.out.println("[알림] 등록 성공");
				} else {
					System.out.println("[알림] 등록 실패");
				}
				
				break;
			} else if (toyType == 9) {
				System.out.println("[알림] 상위 메뉴로 이동합니다.");
				break;
			} else {
				System.out.println("[에러] 다시 입력하세요.");
			}
		}
	}

	/**
	 * 장난감 객체를 등록하기 위한 메뉴를 화면에 출력
	 */
	public void insertMenu() {
		System.out.println("===== 장난감 등록 메뉴 =====");
		System.out.println("1. 자전거");
		System.out.println("2. 드론");
		System.out.println("3. 게임기");
		System.out.println("9. 상위메뉴");
		System.out.print("[ 장난감 선택 ]");
	}

	/**
	 * 장난감 객체를 저장하기 위해 Toy 객체를 생성한다. 장난감의 종류에 따라 자전거(1. 도로용, 2. 산악용), 드론(날개 갯수),
	 * 게임기(휴대가능 여부)를 입력받는다.
	 * 
	 * @param toyType 장난감 종류
	 * @return 생성된 장난감 객체
	 */
	public Toy makeToy(int toyType) throws InputMismatchException {
		List<Object> toyInfo = new ArrayList<>();

		System.out.print("> 고유번호: ");
		String serialNum = inputString();
		Toy toy = manager.searchToy(serialNum);

		if (toy == null) {
			toyInfo.add(serialNum);
			System.out.print("> 이름: ");
			toyInfo.add(inputString());
			System.out.print("> 가격: ");
			toyInfo.add(inputInteger());
			if (toyType == 1) {
				System.out.print("> 자전거 종류(1.도로용, 2.산악용): ");
				int bicycleType = this.inputInteger();

				if (bicycleType == 1 || bicycleType == 2) {
					String type = "";

					if (bicycleType == 1) {
						type = "도로용";
					} else {
						type = "산악용";
					}

					toyInfo.add(type);
				} else {
					InputMismatchException e = new InputMismatchException();
					throw e;
				}

				toy = new Bicycle(toyInfo);
			} else if (toyType == 2) {
				System.out.print("> 날개 수: ");
				toyInfo.add(this.inputInteger());

				toy = new Drone(toyInfo);
			} else if (toyType == 3) {
				System.out.print("> 휴대용 (Y/N): ");
				toyInfo.add(this.inputBoolean());

				toy = new GameConsole(toyInfo);
			} else if (toyType == 9) {
				System.out.println("[알림] 상단 메뉴로 돌아갑니다.");
			} else {
				InputMismatchException e = new InputMismatchException();
				throw e;
			}
		}

		return toy; // 시리얼 중복이 없으면 객체가 만들어지고 아니면 null을 반환.
	}

	/**
	 * 고유번호에 해당하는 장난감을 검색하여 화면에 출력한다. 검색이 되지 않을 경우 메시지 출력
	 */
	public void searchToy() throws InputMismatchException {
		System.out.print("> 장난감 고유번호: ");
		String serialNum = this.inputString();
		Toy toy = manager.searchToy(serialNum);

		if (toy != null) {
			System.out.println(toy);
		} else {
			System.out.println("[알림] 검색결과가 없습니다.");
		}
	}

	/**
	 * 특정 분류에 해당하는 장난감의 정보를 출력하는 메소드 검색이 되지 않을 경우 메세지 출력
	 */
	public void groupSearch() throws InputMismatchException {
		this.printMenu();
		int selector = this.inputInteger();
		List<Toy> searchedList = null;

		if (selector >= 1 && selector <= 4) {
			searchedList = manager.groupSearch(selector);
			this.printToyInfo(searchedList);
		} else if (selector == 9) {
			System.out.println("[알림] 상위 메뉴로 이동합니다.");
		} else {
			System.out.println("[알림] 다시 입력하세요.");
			this.groupSearch();
		}
	}

	/**
	 * 장난감의 시리얼번호를 입력받아 해당하는 장난감 정보를 삭제한다.
	 */
	public void deleteToy() throws InputMismatchException {
		System.out.print("> 장난감 고유번호: ");
		String serialNum = this.inputString();
		boolean flag = manager.deleteToy(serialNum);

		if (flag) {
			System.out.println("[알림] 정상적으로 삭제되었습니다.");
		} else {
			System.out.println("[알림] 삭제할 정보가 없습니다.");
		}
	}

	/**
	 * 장난감의 제품번호를 입력받아 해당하는 장난감 가격을 수정한다.
	 */
	public void updateToy() throws InputMismatchException {
		System.out.print("> 장난감 고유번호: ");
		String serialNum = this.inputString();
		Toy searchedVO = manager.searchToy(serialNum);

		if (searchedVO != null) {
			System.out.print("[수정할 가격]");
			int newPrice = this.inputInteger();
			searchedVO.setPrice(newPrice);
			
			manager.updateToy(searchedVO);
			System.out.println("[알림] 가격 수정이 완료되었습니다.");
		} else {
			System.out.println("[알림] 수정할 정보가 없습니다.");
		}
	}

	/**
	 * 가격대 검색 최소 가격과 최대 가격을 입력받아 해당하는 가격 범위 내의 모든 장난감을 검색해서 출력
	 */
	public void searchForPrice() throws InputMismatchException {
		int minPrice;
		int maxPrice;

		System.out.print("> 최소가격 : ");
		minPrice = this.inputInteger();
		System.out.print("> 최대가격 : ");
		maxPrice = this.inputInteger();
		List<Toy> searchedList = manager.toyListForPrice(minPrice, maxPrice);

		this.printToyInfo(searchedList);
	}

	/**
	 * 장난감 정보를 화면에 출력 장난감 정보를 출력하고 난 후 검색한 장난감의 개수 출력 검색이 되지 않을 경우 등록된 장난감이 없다는 메시지
	 * 출력
	 */
	public void printToyInfo(List<Toy> list) {
		boolean listIsNullOrEmpty = false;
		
		if (list == null || list.isEmpty()) {
			listIsNullOrEmpty = true;
		}
		
		if (!listIsNullOrEmpty) {
			int index = 0;
			
			for (Toy vo : list) {
				index++;
				System.out.println(vo);
			}
			
			System.out.println("총 " + index + "개의 제품이 검색되었습니다.");
		} else {
			System.out.println("[알림] 검색 결과가 없습니다.");
		}
	}

	/**
	 * 장난감 정보 출력 서브 메서드
	 */
	public void printMenu() {
		System.out.println("===== 장난감 정보 출력 =====");
		System.out.println("1. 전체 출력");
		System.out.println("2. 자전거 정보 출력");
		System.out.println("3. 드론 정보 출력");
		System.out.println("4. 게임 콘솔 정보 출력");
		System.out.println("9. 상위 메뉴");
		System.out.print("[ 선택 ]");
	}

	/**
	 * Input Integer method
	 * 
	 * @return integer type
	 */
	public int inputInteger() {
		int num = 0;

		try {
			num = input.nextInt();
		} catch (InputMismatchException e) {
			throw e;
		} finally {
			input.nextLine();
		}

		return num;
	}

	/**
	 * Input boolean method
	 * 
	 * @return boolean type
	 */
	public boolean inputBoolean() {
		boolean flag = false;
		String flagTemp = null;

		try {
			flagTemp = input.nextLine();
		} catch (InputMismatchException e) {
			throw e;
		} finally {
			if (flagTemp.equals("Y")) {
				flag = true;
			} else if (flagTemp.equals("N")) {
				flag = false;
			} else {
				InputMismatchException e = new InputMismatchException();
				throw e;
			}
		}

		return flag;
	}

	/**
	 * inputString method
	 * 
	 * @return String
	 */
	public String inputString() {
		String str = null;

		try {
			str = input.nextLine();
		} catch (InputMismatchException e) {
			throw e;
		}

		return str;
	}
}