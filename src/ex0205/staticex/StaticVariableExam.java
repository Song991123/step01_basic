package ex0205.staticex;

class Test{
	int a; 			//전역변수 0
	static int b ;  //static 전역변수 0
	
	public void aa() {
//		System.out.println(a);
//		System.out.println(this.a);
//		
//		System.out.println(b);
//		System.out.println(this.b);
//		System.out.println(Test.b);
	}
	public void bb() {
		//메소드 호출
		aa();
		this.aa();
	}
	//static 메소드는 static만 접근 가능하고 this사용불가
	public static void cc() {
//		System.out.println(a);
//		System.out.println(this.a);
		
		System.out.println(b);
//		System.out.println(this.b);
		System.out.println(Test.b);
	}
	public static void dd() {
		
	}
}

public class StaticVariableExam {
	static {
		System.out.println("난 메인보다 먼저 실행돼요");
	}
	
	public static void main(String[] args) {
		System.out.println("-----메인시작-----");
		// 객체 생성
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		
		System.out.println("--- non-static 접근 ---");
		System.out.println("t1 = " + t1.a);
		System.out.println("t2 = " + t2.a);
		System.out.println("t3 = " + t3.a);
		
		System.out.println("--- 변경 후 non-static 접근 ---");
		t1.a = 1;
		t2.b = 50;
		System.out.println("t1 = " + t1.a);
		System.out.println("t2 = " + t2.a);
		System.out.println("t3 = " + t3.a);
		
		
		System.out.println("--- static 접근 ---");
		System.out.println("t = " + Test.b);
		
	}

}
