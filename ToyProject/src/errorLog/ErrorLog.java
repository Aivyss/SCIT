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
		
		if (e instanceof Exception) {
			if (e instanceof RuntimeException) {
				num1 = (e instanceof AnnotationTypeMismatchException) ? 
						: (e instanceof ArithmeticException) ?
						: (e instanceof ArrayStoreException) ?
						: (e instanceof BufferOverflowException) ?
						: (e instanceof BufferUnderflowException) ?
						: (e instanceof CannotRedoException) ?
						: (e instanceof CannotUndoException) ?
						: (e instanceof ClassCastException) ? 
						: (e instanceof CMMException) ? 
						: (e instanceof ConcurrentModificationException)
						: (e instanceof NullPointerException) ? 
						: (e instanceof NegativeArraySizeException) ? 
						: (e instanceof IndexOutOfBoundsException) ? 
						: (e instanceof IllegalAccessException) ? 
						: (e instanceof IllegalMonitorStateException) ? 
						: (e instanceof CMMException)
						
			} else if (e instanceof InterruptedException) {
				IOException b;
			} else {
				
			}
		} else if (e instanceof Error) {
			
		} else {
			
		}
		
		
			
		return 0;
	}
}
