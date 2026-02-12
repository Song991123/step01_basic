package ex0212.superkeyword;

class Parent{
//	Parent(){
//		System.out.println(1);
//	}
	Parent(int i){
		System.out.println(2);
	}
	Parent(String s){
		System.out.println(3);
	}
}
///////////////////////////////////
class Child extends Parent{
	Child(){
		this(4);
		System.out.println(4);
	}
	Child(int i){
		this(true);
		System.out.println(5);
	}
	Child(boolean b){
		super("안녕");
		System.out.println(6);
	}
}

public class SuperConstructorExam {

	public static void main(String[] args) {
//		new Child(); // 1 4가 출력
//		new Child(5); // 1과 5가 출력
//		new Child(true); // 1과 6이 출력 
		/* 모든 자식 생성자 구현부 첫번째 줄에 super() 생략되어있음*/
		
		//만약, 부모 생성자가 하나도 없다면
//		new Child(); // 4가 출력
//		new Child(10); // 5가 출력
//		new Child(false); // 6이 출력 
		
		//만약, 부모의 기본 생성자를 지우고 다른 생성자 선언 시
		// -> 에러가 뜸. this로 다른 생성자에게 넘기거나, 있는 super 생성자를 이용하면 된다.
		new Child(); // 3 6 5 4가 출력

		
		
	}

}
