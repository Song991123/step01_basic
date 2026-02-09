package ex0203_송정현;

public class Problem02 {
	/*4. 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 학생당 몇 개를 가질 수 있고,
	 * 최종적으로 몇 개가 남는지를 구하는 코드입니다.
	 * (#1)과 (#2)에 알맞은 코드를 작성하세요.
	 * */
	public static void main(String[] args) {
		int pencils    = 534;
		int students = 30;
		
		// 학생 한 명이 가지는 연필 수
		int pencilsPerStudents = pencils / students; // #1
		System.out.println(pencilsPerStudents);
		
		// 남은 연필 수
		int pencilsLeft = pencils % students; // #2
		System.out.println(pencilsLeft);
	}
}
