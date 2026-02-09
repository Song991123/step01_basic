package ex0205_송정현;

/**
 * 작성자 : 송정현 <br>
 * 작성일 : 26.02.25 <br>
 * 문제 : 주어진 배열 항목에서 최대값을 출력하는 코드를 작성해보세요(for문 이용)
 * */
public class Problem02 {

	public static void main(String[] args) {
		int[] array = {1, 5, 3, 8, 2};
		
		int maxValue = Integer.MIN_VALUE; // 값이 꼭 0일리 없을 수도 있으니, 제일 최솟값으로 세팅
		for(int i : array) {
			if(maxValue < i) maxValue = i;
		}
		
		System.out.println(maxValue);

	}

}
