package global.sesoc.manager;

import java.util.List;

/**
 * 이 클래스는 벨리데이션을 체크하는 기능을 수행하는 클래스이다.
 * @author Aivyss
 *
 */
public class ValidationChecker {
	/**
	 * 리스트 객체의 벨리데이션을 체크하는 기능을 수행하는 메소드이다.
	 * 리스트 객체가 null이거나 size가 0일 경우 false를 return.
	 * 리스트 객체의 사이즈가 1 이상이면 true를 return.
	 * @return boolean
	 */
	public static boolean listValidation(List list) {
		boolean flag = false;
		
		if (list !=null) {
			if(!list.isEmpty()) {
				flag= true;
			}
		}
		return flag;
	}

	/**
	 * 객체의 밸리데이션을 체크하는 기능을 수행하는 메소드이다.
	 * 객체가 null이면 return false.
	 * 객체가 hull이 아니면 return true.
	 * @return boolean
	 */
	public static boolean voValidation(Object obj) {
		boolean flag = false;

		if (obj != null) {
			flag = true;
		}

		return flag;
	}
}
