package ex0210_송정현;
/**
 * 문제19 : 은행 계좌 객체인 Account 객체는 잔고(balance) 필드를 가지고 있습니다.
 * balance 필드는 음수값이 될 수 없고, 최대 백만 원까지만 저장할 수 있습니다.
 * 외부에서 balance 필드를 마음대로 변경 못하고, 0<= balance <= 1,000,000 범위의 값만 가질 수 있도록 Account 클래스를 작성해보세요.
 * */
public class Problem19 {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000
		
		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000
		
		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000
		
		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 300000

	}

}
/**
 * 조건 1. Setter, Getter 이용
 * */
class Account{
	/**
	 * 조건 2. 0과 1,000,000은 MIN_BALANCE, MAX_BALANCE 상수를 선언해 이용
	 * */
	// 상수 필드 ====================
	private int MIN_BALANCE  = 0;
	private int MAX_BALANCE = 1000000;
	
	// 필드 =======================
	private int balance;

	
	public int getBalance() {
		return balance;
	}

	/**
	 * 조건 3. Setter의 매개값이 음수이거나 백만 원 초과 시 현재 balance 값을 유지
	 * */
	public void setBalance(int balance) {
		if(balance < MIN_BALANCE || balance > MAX_BALANCE) return;
		this.balance = balance;
	}
	
	
}
