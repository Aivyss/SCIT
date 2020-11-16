
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
import org.apache.logging.slf4j.Log4jLogger;
import org.apache.logging.slf4j.Log4jLoggerFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public String test() {
		//logger.debug("디버그");
		logger.info("인포");
		
		return "??";
		
	}

}
