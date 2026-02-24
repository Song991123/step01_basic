package ex0224;

public class SyncronizedExam {

	public static void main(String[] args) {
		System.out.println("---메인 시작---");
		
		Bank bank = new Bank();
		CustomerThread th1 = new CustomerThread(bank, "입금자", true);
		CustomerThread th2 = new CustomerThread(bank, "출금자", false);
		
		th1.start();
		th2.start();
		
		System.out.println("---메인 종료---");
	}

}

/**
 * 여러 스레드가 공유할 객체
 * @param : state는 true이면 입금, false이면 출금
 * */
class Bank{
	int balance; // 잔액
	
	public Bank() {
	}
	/**
	 * 제한자 synchronized 는 특정 스레드 synchronized 블럭안에서 일을 다 마무리 할때까지
	     다른 스레드가 제어권을 뺏어가지 못하도록 하는것. synchronized 블럭안에 있는 스레드가
	     lock을 가지고 있다고 하고 블럭빠져나가면 잠금이 풀린다.
	     
	     wait() : 현재 runing중인 스레드를 중지상태로 만듦
	     notify(), notifyAll() : wait()에 의해 중지상태인 스레드를 runnable상태로 만듦
	     주의 : wait(),notify(), notifyAll()는 반드시 synchronized블럭안에서 사용한다.
	 * */
	public synchronized void balanceChange(String name, boolean state) { // 메소드 자체를 synchronized 하는 방법
		if(state) { //입금
			if(balance == 0) { // 돈이 없을 때만 입금이 가능하도록 임시 상황 설정
//				synchronized (this) { // 만약 메소드가 길 경우, 부분적으로만 synchronized 하고 싶을 경우
					System.out.print(name + "===> 현재 잔액 : " + balance + " / ");
					balance++;
					System.out.println(name + "===> 증가 후 현재 잔액 : " + balance);
//				}
			} else {
				System.out.println(name + "대기중");
				try{
					wait(); // 현재 스레드를 정지 상태로 옮긴다.
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}else { // 인출
			if(balance == 1) {
//				synchronized (this) {
					System.out.print(name + "===> 현재 잔액 : " + balance + " / ");
					balance--;
					System.out.println(name + "===> 감소 후 현재 잔액 : " + balance);
//				}
			} else {
				System.out.println(name + "대기중");
				try{
					wait(); // 현재 스레드를 정지 상태로 옮긴다.
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
		notifyAll(); // wait()에 의해 일시 정지 중인 스레드를 runable 상태로 만듬.
	} // 메소드 끝
}// 클래스 끝
/////////////////////////////////
/**
 * 입금 or 출금을 하게 된 스레드 객체
 */
class CustomerThread extends Thread{
//	Bank bank = new Bank(); // 여기서 생성하면 안됨. 왜냐하면 각각 만들어지므로 공유자원이 아니기 때문
	Bank bank;
	boolean state;
	
	public CustomerThread(Bank bank, String name, boolean state) {
		super(name);
		
		this.bank = bank;
		this.state = state;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			bank.balanceChange(super.getName(), state);
		}
		System.out.println(super.getName() + " 스레드 종료합니다.");
	}
}