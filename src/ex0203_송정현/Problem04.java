package ex0203_송정현;

public class Problem04 {
	/*
	 * 6. 다음 코드는 사다리꼴의 넓이를 구하는 코드입니다. 정확히 소수자릿수가 나올 수 있도록 (#1)에
	 * 알맞은 코드를 작성하세요.
	 * */
	public static void main(String[] args) {
		int lengthTop       = 5;
		int lenghTBottom = 10;
		int height             = 7;
		double area          = ((double)lengthTop + (double)lenghTBottom)/2 * height; // (#1)
		System.out.println(area);
	}
}
