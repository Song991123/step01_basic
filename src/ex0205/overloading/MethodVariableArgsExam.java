package ex0205.overloading;

class Test{
	public void aa(int... i) { //매개값을 0개이상 허용. 배열처럼 사용
		System.out.println("aa 호출");
		System.out.println(i);
		
		
		for(int a : i) {
			System.out.print(a + " ");
		}
		System.out.println();
		System.out.println("----------------------");
	}
	
	public void bb(int i,String name) {
		
	}
}

////////////////////////////////////////////
public class MethodVariableArgsExam {

	public static void main(String[] args) {
		// 메소드 호출
		Test t = new Test();
		t.aa(3);
		t.aa(3,4,6);
		t.aa();
		t.aa(2,4,6,7,8,9);
		
		/////////////////////////////
		t.bb(4, "aaa");
		
	}
}
