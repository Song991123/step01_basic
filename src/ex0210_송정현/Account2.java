package ex0210_송정현;

public class Account2 {
	private String accountNo; // 계좌번호
	private String accountOwner; // 계좌주인
	private int		 balance; // 계좌금액
	
	/**
	 * Account2 생성자
	 * @param accountNo 계좌번호
	 * @param accountOwner 계좌주인
	 * @param balance 계좌금액
	 * */
	public Account2(String accountNo, String accountOwner, int balance) {
		this.accountNo 		  = accountNo;
		this.accountOwner = accountOwner;
		this.balance		      = balance;
	}
	
	
	// GETTER ===================
	public String getAccountNo() {
		return accountNo;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public int getBalance() {
		return balance;
	}
	
	// SETTER ===================
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
