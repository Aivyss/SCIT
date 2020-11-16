package errorLog;

import java.io.IOException;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Date;

public class ErrorLog {
	Throwable e;
	Date dateNow = new Date(System.currentTimeMillis());
	String path ="";
	int errorLine;
	
	public int detectErrorType(Throwable e) {
		this.e = e;
		int num1 = -1;
		int num2 = -1;
		

		
		
			
		return 0;
	}
}
