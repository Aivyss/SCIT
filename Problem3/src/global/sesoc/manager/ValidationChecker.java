package global.sesoc.manager;

import java.util.List;

import global.sesoc.vo.Toy;
/**
 * 이 클래스는 벨리데이션을 체크하는 기능을 수행하는 클래스이다.
 * @author Aivyss
 *
 */
public class ValidationChecker {
	/**
	 * toyList validation check
	 * 
	 * @return boolean
	 */
	public static boolean listValidation(List list) {
		boolean flag = false;

		if (list != null) {
			if (!list.isEmpty()) {
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * VO validation check
	 * 
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
