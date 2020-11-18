import java.util.InputMismatchException;

import org.apache.log4j.Logger;

public class Main {

	public static void main(String[] args) {
		Logger2 logger = Logger2.getLogger2(Main.class);
		
		try {
			InputMismatchException ie = new InputMismatchException();
			logger.log(false, "info", ie, "테스트1", "테스트2");
			throw ie;
		} catch (Exception e) {
			logger.log(false, e, "테스트3", "테스트4");
		}
	}

}
