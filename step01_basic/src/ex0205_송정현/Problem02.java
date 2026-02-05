package ex0205_송정현;

/**
 * 작성자 : 송정현 <br>
 * 작성일 : 26.02.25 <br>
 * 문제 : 주어진 배열 항목에서 최대값을 출력하는 코드를 작성해보세요(for문 이용)
 * */
public class Problem02 {

	public static void main(String[] args) {
		int[] array = {1, 5, 3, 8, 2};
		
		int num = array[0];
		for(int i = 1; i <=4; i++) {
			if(num < array[i]) num = array[i];
		}
		System.out.println(num);

	}

}
