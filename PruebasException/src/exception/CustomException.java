package exception;

// Checked Exception – Extends java.lang.Exception, for recoverable condition, try-catch the exception explicitly, compile error.
// without losing the root cause from which they occurred.
//https://stackify.com/specify-handle-exceptions-java/
public class CustomException extends Exception {

	private static final long serialVersionUID = 3026393903863754932L;

	public CustomException(String message) {
		super(message);
	}
	
}
