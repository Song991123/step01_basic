package ex0205_송정현;
/**
 * 작성자 : 송정현 <br>
 * 작성일 : 26.02.25 <br>
 * 문제 : 주어진 배열 항목의 전체 합과 평균을 구해 출력하는 코드를 작성해 보세요(중첩 for문 이용)
 * */
public class Problem03 {

	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		int totalCount = 0;
		
		for(int i = 0; i < array.length; i++) {
			totalCount += array[i].length;
			for(int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
			}
		}
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + (double)sum/totalCount);
		
		
	}

}
