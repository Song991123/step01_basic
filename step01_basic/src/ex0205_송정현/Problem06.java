package ex0205_송정현;
/**
 * 작성자 : 송정현 <br>
 * 작성일 : 26.02.25 <br>
 * 문제 : 로또번호 6개를 배열 방에서 중복되지 않게 만들어 출력하기
 * (1~45까지) 출력 시 내림차순으로 출력하게 한다.
 * 조건 : 중복체크 메소드
 * 		숫자 6개 배열방에 저장하는 메소드 : lotto[index] = 값
 * 		배열 방의 값을 내림차순으로 정렬하는 메소드
 * 		배열의 값을 화면에 출력하는 메소드
 * */

public class Problem06 {
	public static void main(String[] args) {
		lottoRandomNumberLogic lrn = new lottoRandomNumberLogic();
		lrn.printLottoNumbers();	
	}
}


/**
 * 랜덤 로또번호 출력 클래스
 * */
class lottoRandomNumberLogic{
	int lotto[] = new int[6];
	/**
	 * 숫자 6개 배열방에 저장하는 메소드
	 * */
	private void generateLottoNumbers(){
		int randomNo = 0;
		int count 	  = 1;
		while(count <= lotto.length ) {
			randomNo = (int)(Math.random() * 45 +1);
			
			if(isDuplicate(randomNo)) continue;
			
			lotto[count-1] = randomNo;
			count++;
		}
	}
	
	/**
	 * 중복체크 메소드
	 * @param random 생성된 랜덤 숫자
	 * */
	private boolean isDuplicate(int random){
		for(int number : lotto) {
			if(number == random) return true;
		}
		return false;
	}

	/**
	 * 배열 방의 값을 내림차순으로 정렬하는 메소드
	 * */
	private void sortDescending(){
		int temp = 0;
		for(int i = 0; i < lotto.length; i++) { // 0~6까지
			for(int j = 0; j < lotto.length - 1- i; j++) { // 0~6-i까지
				if(lotto[j] < lotto[j+1]) {
					temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 배열의 값을 화면에 출력하는 메소드
	 * */
	public void printLottoNumbers(){
		generateLottoNumbers();
		sortDescending();
		
		System.out.print("오늘의 로또 번호 : ");
		for(int number : lotto) {
			System.out.print(number + " ");
		}
	}
}