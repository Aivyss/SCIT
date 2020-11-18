
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * 인생아 ... 이리 간단한 거슬...
 * @author Aivyss(H.K. Leigh)
 *
 */
public class Logger2 extends Logger {
	private static Logger2 logger2;
	private boolean printOnOff;
	private static String className;
	private String timeFormat = "HH:mm:ss";
	
	protected Logger2(String name) {
		super(name);
		super.repository = Logger.getLogger(name).getLoggerRepository();
		parent = Logger.getLogger(name).getRootLogger();
		className = name;
	}
	
	public static Logger2 getLogger2(Class<?> clazz) {
		className = clazz.getName();
		logger2 = new Logger2(className);
		return logger2;
	}
	
	public void autoLog(boolean printOnOff, Throwable t, Object ...message) {
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement beforeStack = stacks[1];
		String level = determineLevel(t);
		
		if(printOnOff) {
			autoLogPrint(level, t, beforeStack.getLineNumber());
		} else {
			if (level.equals("fatal")) {
				super.fatal(message, t);
			}
		}
	}
	
	public void autoLogPrint(String level, Throwable t, Object ...message) {
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement beforeStack = stacks[1];
		
		System.out.println(getCurrentTime() + className + level + message);
	}
	
	private String determineLevel(Throwable t) {
		Map<String, String> map = levelTable();
		String throwablesName = t.getClass().getName().substring(10);
		String resultLevel = map.get(throwablesName);
		
		if(level == null) {
			resultLevel = "fatal";
		}
		
		
		return resultLevel;
	}
	
	private String getCurrentTime() {
		return new SimpleDateFormat(timeFormat).format(System.currentTimeMillis());
	}
	
	private Map<String, String> levelTable() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Exception", "fatal");
		map.put("NullPointException", "debug");
		
		
		return map;
	}
	
}
