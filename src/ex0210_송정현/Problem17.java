package ex0210_송정현;
/**
 * 문제17 : 16번 문제에서는 Printer 객체를 생성하고 println() 메소드를 호출했습니다. 이번에는 Printer 객체를 생성하지 않고도 다음과 같이 호출할 수 있도록 Printer 클래스를 수정해보세요.
 * */
public class Problem17 {

	public static void main(String[] args) {
		Printer2.println(10);
		Printer2.println(true);
		Printer2.println(5.7);
		Printer2.println("홍길동");

	}

}

/**
 * 각각 println은 매개변수가 value(int, boolean, double, String)이 있음.
 * */
class Printer2{
	
	public static void println(int value) {
		System.out.println(value);
	}
	
	public static void println(boolean value) {
		System.out.println(value);
	}
	
	public static void println(double value) {
		System.out.println(value);
	}
	public static void println(String value) {
		System.out.println(value);
	}
}
