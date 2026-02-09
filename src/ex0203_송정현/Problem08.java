package ex0203_송정현;

public class Problem08 {
	/*
	 * 5. 중첩 for문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x,y) 형태로 출력해보세요.
	 * 단, x 와 y는 10 이하의 자연수입니다.
	 * */
	public static void main(String[] args) {
		for( int x = 1; x <=10; x++) {
			for (int y = 1; y <= 10; y++) {
				
				int cal = (4*x) + (5*y);
				
				if(cal == 60) System.out.printf("(%d,%d)%n", x, y);
			}
		}
	}

}
