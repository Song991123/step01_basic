package ex0210_송정현;
/**
 * 문제16 : println() 메소드는 매개값을 콘솔에 출력합니다. println() 메소드의 매개값으로는 int, boolean, doule, String 타입 값을 줄 수 있습니다.
 * 다음 조건과 에제 코드를 보고 Printer 클래스에서 println() 메소드를 오버로딩하여 선언해보세요.
 * */
public class Problem16 {
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
}
/**
 * 각각 println은 매개변수가 value(int, boolean, double, String)이 있음.
 * */
class Printer{
	
	public void println(int value) {
		System.out.println(value);
	}
	
	public void println(boolean value) {
		System.out.println(value);
	}
	
	public void println(double value) {
		System.out.println(value);
	}
	public void println(String value) {
		System.out.println(value);
	}
}