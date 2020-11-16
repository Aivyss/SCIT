

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * 인생아 ... 이리 간단한 거슬...
 * @author hklei
 *
 */
public class Logger2 extends Logger {
	private boolean printOnOff;
	private String className;
	String timeFormat = "HH:mm:ss";
			
	/**
	 * 생성자
	 * @param clazz
	 * @param printOnOff
	 */
	public Logger2(Class<?> clazz) {
		super(clazz.getName());
		className = clazz.getName();
	}
	
	public void autoLog(boolean printOnOff, Throwable t, Object message) {
		String level = determineLevel(t);
		
		if(printOnOff) {
			autoLogPrint(level, t, message);
		} else {
			if (level.equals("fatal")) {
				fatal(message, t);

			}
		}
	}
	
	public void autoLogPrint(String level, Throwable t, Object message) {
		System.out.println(getCurrentTime() + className + level + message);
	}
	
	private String determineLevel(Throwable t) {
		Map<String, String> map = levelTable();
		
		String className = t.getClass().getName().substring(10);
		
		String resultLevel = map.get(className);
		
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
		
		return map;
	}

	
	
}
