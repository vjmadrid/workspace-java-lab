package util;

import exception.CustomException;
import exception.CustomRuntimeException;

public enum GenerateExceptionUtil {

	INSTANCE;
	
	public void generateCustomException() throws CustomException {
		throw new CustomException("CUSTOM EXCEPTION");
	}
	
	public void generateCustomRuntimeException() {
		throw new CustomRuntimeException("CUSTOM RUNTIME EXCEPTION");
	}
	
}
