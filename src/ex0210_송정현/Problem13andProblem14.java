/**
 * 작성일 260210
 * */
package ex0210_송정현;

public class Problem13andProblem14 {
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong"); 
	}
}
/**
 * 문제13 : 현실세계 회원을 Member 클래스로 모델링하려고 합니다. 
 * 회원의 데이터로는 이름, 아이디, 패스워드, 나이가 있습니다.
 * 이 데이터들을 가지는 Member 클래스를 선언해보세요.
 * <br><br>
 * 회원이 가지는 데이터<br>
 * - name     : String  (이름)<br>
 * - id       : String  (아이디)<br>
 * - password : String  (패스워드)<br>
 * - age      : int     (나이)
 * */
class Member{
	String name;
	String id;
	String password;
	int      age;
	
	/**
	 * 문제 14 : 13번 문제에서 작성한 Member 클래스에 생성자를 추가하려고 합니다.
	 * 다음과 같이 name 필드와 id 필드를 외부에서 받은 값으로 초기화하도록 생성자를 선언해보세요.
	 * <br>
	 * 입력값 : Member user1 = new Member("홍길동", "hong"); 
	 * */
	public Member(String name, String id) {
		this.name = name;
		this.id		= id;
	}
}