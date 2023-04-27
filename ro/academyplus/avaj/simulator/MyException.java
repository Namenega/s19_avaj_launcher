package ro.academyplus.avaj.simulator;

/**
 * The class "MyException" extends the built-in "Exception" class in Java and
 * allows for the creation of custom exceptions with a specified error message.
 */
public class MyException extends Exception {
	public MyException(String errorMessage) {
		super(errorMessage);
	}
}
