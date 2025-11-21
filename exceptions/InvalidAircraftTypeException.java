package exceptions;

public class InvalidAircraftTypeException extends Exception{
	public InvalidAircraftTypeException(String msg) {
		super(msg);
	}
}