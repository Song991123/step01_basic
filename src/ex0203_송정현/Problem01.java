package ex0203_송정현;

import java.util.Scanner;

//1. 성적표 기능을 만들 클래스를 선언하고 메인 메소드를 작성한다. ==============
public class Problem01 {
	public static void main(String[] args) {
		
		// 2. 메인메소드안에서 하는 일 ================
		
		//     ㄴ본인 이름(String)을 저장할 변수 선언
		final String NAME = "정현";
		
		//	변수 선언 -------------------------
		int[] subject = new int[3];
		
		int         sum      = 0;
		double  average = 0.0;
		char      grade    = 'F'; 
		
		
		// ㄴ국어, 영어, 수학 점수는 45 ~ 100사이의 난수를 발생해서 저장
		for(int i = 0; i < 3; i++) {
			subject[i] = (int)(Math.random()*56+45);
			sum += subject[i];
		}
		
		average = (sum / 3.0);
		
		// ============= IF문 =============
//		if(average >= 90)          grade = 'A';
//		else if(average >= 80)   grade = 'B';
//		else if(average >= 70)   grade = 'C';
//		else if(average >= 60)   grade = 'D';
//		else 								grade = 'F';
		

		
		// ============= SWITCH문 =============
		grade = switch((int)average /10) {
			case 10,9 -> 'A';
			case 8      -> 'B';
			case 7      -> 'C';
			case 6      -> 'D';
			default     -> 'F';
		};
		
		// 출력 ========================
		System.out.println("결과 : " + NAME + "님 성적표");
		System.out.println("국어 : " + subject[0]);
		System.out.println("영어 : " + subject[1]);
		System.out.println("수학 : " + subject[2]);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (int)(average / 0.01) *0.01);
		System.out.println("학점 : " + grade);
	}

}
