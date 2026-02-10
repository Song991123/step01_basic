package ex0210_송정현;

import java.util.Scanner;

public class BankApplication {


	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankLogic bankLogic = new BankLogic();
		
		while(true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------------------");
			
			System.out.print("선택 > ");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo){
				case 1->{
					bankLogic.createAccount();
				}
				case 2->{
					bankLogic.searchAllAccount();
				}
				case 3->{
					bankLogic.deposit();
				}
				case 4->{
					bankLogic.withdraw();
				}
				case 5->{
					System.out.println("프로그램 종료");
					sc.close();
					return;
				}
			}//switch 종료

		} // while 종료
		
	} // main 종료
	

	
	
}

class BankLogic{
	private Account2[] acArray = new Account2[100];
	private Scanner sc = new Scanner(System.in);
	
	//////////////////////////////////////////////////
	/// METHOD /////////////////////////////////
	////////////////////////////////////////////////
	
	public void createAccount() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		
		System.out.print("계좌번호: ");
		String accountNo = sc.nextLine();
		
		System.out.print("계좌주: ");
		String accountOwner = sc.nextLine();
		
		System.out.print("초기입금액: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account2 ac = new Account2(accountNo, accountOwner, money);
		for(int i = 0; i < acArray.length; i++) {
			if(acArray[i] == null) {
				acArray[i] = ac;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}
	
	public void searchAllAccount() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");
		
		for(Account2 a : acArray) {
			if(a == null) break;
			System.out.println(a.getAccountNo() + "ㅤ" + a.getAccountOwner() + "ㅤ" + a.getBalance());
		}
	}
	
	public void deposit() {
		System.out.println("----------");
		System.out.println("예금");
		System.out.println("----------");
		
		System.out.print("계좌번호: ");
		String accountNo = sc.nextLine();
		
		System.out.print("예금액: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account2 ac = findAccount(accountNo);
		if(ac == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다");
			return;
		}
		ac.setBalance(ac.getBalance() + money);
		System.out.println("결과: 예금이 성공되었습니다.");
		
	}
	
	public void withdraw() {
		System.out.println("----------");
		System.out.println("출금");
		System.out.println("----------");
		
		System.out.print("계좌번호: ");
		String accountNo = sc.nextLine();
		
		System.out.print("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
		
		Account2 ac = findAccount(accountNo);
		if(ac == null) {
			System.out.println("결과: 계좌가 존재하지 않습니다");
			return;
		}
		ac.setBalance(ac.getBalance() - money);
		System.out.println("결과: 출금이 성공되었습니다.");
	}
	
	/**
	 * 부분검색
	 * @param accountNo 계좌번호
	 * */
	public Account2 findAccount(String accountNo) {
		for(Account2 a: acArray) {
			if(a == null) return null;
			if(a.getAccountNo().equals(accountNo)) return a;
		}
		return null;
	}
}

