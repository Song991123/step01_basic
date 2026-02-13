package ex0213.shop;

public class UnderAgeAccessException extends Exception {
	public static int exceptionCount = 0;
	public UnderAgeAccessException() {
		super("애들은 가라");
		exceptionCount++;
	}
	
	public UnderAgeAccessException(String message) {
		super(message);
		exceptionCount++;
	}
	
}
