package ex0204_송정현;

import java.util.Scanner;

public class GradeCalculator {
	/*
	 * 아래 요구사항을 바탕으로 성적 프로그램을 작성하라 ver.2
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GradeLogic gl = new GradeLogic();
		
		// 성적 프로그램이 계속 반복된다.
		while(true) {
			// 1. 성적표구하기     2. 종료 라는 메뉴를 만든다.
			System.out.println("1. 성적표구하기     2. 종료");
			// 그리고 그 메뉴에 따라 기능을 실행한다.
			
			// 성적 구하기 ------------------------
			switch(sc.nextInt()) {
				case 1 -> {
						// 공백없애기
						sc.nextLine();
						
						// 값 입력
						System.out.print("이름을 입력해주세요(공백가능) : ");
						String studentName = sc.nextLine();
						System.out.print("국어점수 : ");
						int korScore = sc.nextInt();
						System.out.print("영어점수 : ");
						int engScore = sc.nextInt();
						System.out.print("수학점수 : ");
						int mathScore = sc.nextInt();
						
						// 성적 정보 출력
						gl.printStudentGrade(studentName, korScore, engScore, mathScore);
					}
				// 종료 ----------------------------
				case 2 -> {
					System.out.println("프로그램이 종료됩니다.");
					sc.close();
					return;
				}
			}
		}
		
	}

}

/***
 * 성적구하는 기능 담당 클래스 
 */
class GradeLogic{
	/**
     * 국어, 영어, 수학 점수를 인수로 받아 총점을 계산하여 리턴하는 메소드 (private)
     *
     * @param korScore 국어 점수
     * @param engScore 영어 점수
     * @param mathScore 수학 점수
     * @return 총점
     */
	private int getTotalScore(int korScore, int engScore, int mathScore) {
		int sum = korScore + engScore + mathScore;
		return sum;
	}
	/**
     * 총점과 과목 수를 인수로 받아 평균을 계산하여 리턴하는 메소드 (private)
     *
     * @param total 총점
     * @param subjectCount 과목 수
     * @return 평균
     */
	private double getAverage(int total, int subjectCount) {
		double average = total / (double)subjectCount;
		return average;
	}
	
    /**
     * 평균을 인수로 받아 등급을 구하여 등급을 리턴해주는 메소드
     *
     * @param average 평균 점수
     * @return 학점 등급 (A~F)
     */
	private char getGrade(int average) {
		char grade = switch((int)average /10) {
			case 10,9 -> 'A';
			case 8      -> 'B';
			case 7      -> 'C';
			case 6      -> 'D';
			default     -> 'F';
		};
		return grade;
	}
	
	/**
     * 이름, 국어, 영어, 수학 점수를 인수로 받아
     * 총점, 평균, 등급을 계산하고 콘솔에 출력하는 메소드
     * 이미 정의된 getTotalScore, getAverage, getGrade 메소드를 호출하여 사용
     *
     * @param studentName 학생 이름
     * @param korScore 국어 점수
     * @param engScore 영어 점수
     * @param mathScore 수학 점수
     */
	public void printStudentGrade(String studentName, int korScore, int engScore, int mathScore) {
		// 지역변수 선언 ==================
		int 		total 	 = this.getTotalScore(korScore, engScore, mathScore);
		double average  = this.getAverage(total, 3);
		char 		grade 	 = this.getGrade((int)average);
		
		// 출력 ========================
		System.out.println("결과 : " + studentName + "님 성적표");
		System.out.println("국어 : " + korScore);
		System.out.println("영어 : " + engScore);
		System.out.println("수학 : " + mathScore);
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (int)(average / 0.01) *0.01);
		System.out.println("학점 : " + grade);
	}
}
