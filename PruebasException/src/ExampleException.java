import exception.CustomException;
import util.GenerateExceptionUtil;

public class ExampleException {

	private static void exampleCustomException() {
		System.out.println("***ANTES CustomException**");
		
			try {
				GenerateExceptionUtil.INSTANCE.generateCustomException();
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("***DESPUES CustomException**");
	}
	
	private static void exampleCustomRuntimeException() {
		System.out.println("***ANTES CustomRuntimeException**");

		GenerateExceptionUtil.INSTANCE.generateCustomRuntimeException();
		
		System.out.println("***DESPUES CustomRuntimeException**");
	}
	
	private static void exampleCustomRuntimeExceptionWithCatch() {
		System.out.println("***ANTES CustomRuntimeException With Catch**");
		try {
			GenerateExceptionUtil.INSTANCE.generateCustomRuntimeException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***DESPUES CustomRuntimeException With Catch**");
	}
	
	public static void main(String[] args) {
		//exampleCustomException();
		//System.out.println("***********************");
		//exampleCustomRuntimeException();
		//System.out.println("***********************");
		//exampleCustomRuntimeExceptionWithCatch();
	}

}
