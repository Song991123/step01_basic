package ex0205_송정현;

/**
 * 작성자 : 송정현 <br>
 * 작성일 : 26.02.25 <br>
 * 문제 : 다음은 배열 길이를 출력하는 코드입니다. 실행 결과를 작성해보세요.
 * */
public class Problem01 {
	
	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		System.out.println(array.length);       // 3
		System.out.println(array[2].length);  // 5
	}

}
