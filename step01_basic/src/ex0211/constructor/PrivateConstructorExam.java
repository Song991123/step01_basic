package ex0211.constructor;

class Test{
	
	// 자기 자신 생성하는 static 멤버필드
	private static Test test = new Test();
	
	// 외부에서 접근 못하게 생성자 막음
	private Test() {}
	
	/**
	 * 객체를 직접 생성해서 리턴해주는 메소드 제공
	 * */
	public static Test getInstance() {
		return test;
	}
}

public class PrivateConstructorExam {

	public static void main(String[] args) {
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		
		if(t1 == t2) System.out.println("같은 객체입니다.");
	}

}
