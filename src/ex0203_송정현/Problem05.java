package ex0203_송정현;

public class Problem05 {
	/*
	 * 7. 다음 코드는 비교 연산자와 논리 연산자의 복합 연산식입니다. 연산식의 출력 결과를 괄호() 속에 넣으세요.
	 * **/
	public static void main(String[] args) {
		int x = 10;
		int y = 5;
		
		System.out.println( (x > 7) && (y<=5));  // (true)  7보다 크므로 true, y가 5 이하이므로 true. 둘다 true이므로 true
		System.out.println( (x%3 == 2) || (y%2 !=1)); // (false) x를 3으로 나눈 나머지는 1으로 false, y를 2로 나눈 나머지는 1이므로 false. 둘 다 false이므로 false
	}
}
