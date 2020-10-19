package addressbook.ui;

/**
 * 개인 정보를 입력받아 저장하는 주소 관리 프로그램의 최초 실행 부분
 */
public class AddressMain {

	public static void main(String[] args) {
		//AddressUI 객체를 생성하여 프로그램의 흐름을 구성
		AddressUI ui = new AddressUI();
		
		while (true) {
			int num = ui.menu();
			
			if (num == 1) {
				ui.input();
			} else if (num == 2) {
				ui.output();
			} else if (num == 3) {
				ui.searchName();
			} else if (num == 4) {
				ui.searchGroup();
			} else if (num == 5) {
				ui.delete();
			} else if (num == 0) {
				ui.end();
				break;
			}
		}
	}
}