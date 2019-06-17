package exception;

// Unchecked Exception – Extends java.lang.RuntimeException, for unrecoverable condition, like programming errors, no need try-catch, runtime error.
//If the client cannot do anything to recover from the exception, make it an unchecked exception. To create a custom unchecked exception, extends java.lang.RuntimeException
public class CustomRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -2480638199437451605L;

	public CustomRuntimeException(String message) {
		super(message);
	}
}
