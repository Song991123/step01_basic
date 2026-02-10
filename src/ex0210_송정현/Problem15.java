package ex0210_송정현;
/**
 * 문제15 : login() 메소드를 호출할 때에는 매개값으로 id와 password를 제공하고, logout() 메소드는 id만 매개값으로 제공하려고 합니다.
 * 다음 조건과 예제 코드를 보고 MemberService 클래스에서 login(), logout() 메소드를 선언해보세요.
 * */
public class Problem15 {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		}
		else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
}


class MemberService {
	
	/**
	 * login
	 * @param id 아이디
	 * @param password 비밀번호
	 * @return 로그인 성공여부
	 * */
	public boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}
		return false;
	}
	
	/**
	 * logout
	 * @param id
	 * */
	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}
