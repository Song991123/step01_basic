package ex0211.overriding;

//MethodOverridingExam.java
//이 class는 수정하지 마세요.
class SuperClass{
 	protected int intNumber;
 	protected String memberString="Sting in SuperClass";
 	
 	
	SuperClass(){
 		System.out.println("생성자 SuperClass()가 호출되었습니다.");
 	}
 	
	public void methodZero(){
 		System.out.println("SuperClass객체의 methodZero()메소드가 호출되었습니다.");		
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
	}
 	
 	protected void methodOwn(){
 		System.out.println("SuperClass객체의 methodOwn()메소드가 호출되었습니다.");
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 	}
 	
	int methodTwo(int i){
 		intNumber=i;
 		System.out.println("SuperClass객체의 methodTwo(int i)메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return intNumber;
 	}
 	
	protected String methodThree(int i, String s){
 		intNumber=i;
 		memberString=s;
 		System.out.println("SuperClass객체의 methodThree(int i, String s)메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return i+s;
 	}
 	
	public void methodFour(){
 		memberString="methodFour invokes methodOwn";
 		methodOwn();
 	}
}
//SubClass의 Error를 수정하고 Error의 이유를 주석으로 작성하세요.

/*overrriding의 기본조건
	리턴타입,메소드이름,인수 같아야한다
	modifier는 같거나 커야한다.
*/

class SubClass extends SuperClass{ 
	SubClass(){
		memberString = "SubClass의 생성자가 입력한 String";
 		System.out.println("생성자 SubClass()가 호출되었습니다.");
 	}
 	
	
	public void methodZero(){	 // 부모와 접근제한자가 다름. protected -> public으로 수정
	
		System.out.println("SubClass객체의 methodZero()메소드가 호출되었습니다.");
		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
	}
 	
	protected void methodOwn(){ // 부모와 접근제한자, 리턴타입이 다름. private -> protected / float -> void
		
		System.out.println("SubClass객체의 methodOwn()메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 	}
 	
	int methodTwo(int a){ // 부모와 접근제한자, 리턴타입이 다름. private -> 생략 / void -> int
	
 		intNumber=a;
 		System.out.println("SubClass객체의 methodTwo()메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
		return intNumber; 
 	}
 	String methodThree(String s, int k){ // 부모와 애초에 매개변수 위치 자체가 달라서 overriding이 아님. 오버로딩
		intNumber=k;
 		memberString=s;
 		System.out.println("SubClass객체의 methodThree()메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return memberString;
 	}
	
 	protected String methodThree( int k,String str){ // 부모와 접근제한자가 다름. 생략 -> protected
	
 		intNumber=k;
 		memberString=str;
 		System.out.println("SubClass객체의 methodThree()메소드가 호출되었습니다.");
 		System.out.println("intNumber="+intNumber+"\t"+"memberString="+memberString);
 		return memberString;
 	}
 	
	public void methodFour(){ // 부모와 리턴타입이 다름 double -> void
		System.out.println("SubClass의 public double methodFour()가 호출되었습니다.");
 		memberString="methodFour invokes methodOwn";
 		methodOwn();
 	}
}

//이 class도 수정하지 마세요.
class MethodOverridingExam{
	public static void main(String [] args){
		SuperClass sp = new SuperClass();
		System.out.println("**************************************");
		SubClass sb = new SubClass();		
		System.out.println("**************************************");
		
		
	}
}					
