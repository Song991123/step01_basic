package ex0205_송정현;

import java.util.Scanner;
/**
 * 작성자 : 송정현 <br>
 * 작성일 : 26.02.25 <br>
 * 문제 : 학생들의 점수를 분석하는 프로그램을 만들려고 합니다. 키보드로부터 학생 수와 각 학생들의 점수를 입력받고, 
 * while문과 Scanner의 nextLine() 메소드를 이용해서 최고 점수 및 평균 점수를 출력하는 코드를 작성해 보세요.
 * */
public class Problem04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int studentCount = 0;
		int scores[] = null;
		
		
		while(true) {
			System.out.println("------------------------------------");
			System.out.println("1. 학생 수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("------------------------------------");
			System.out.print("\n선택 > ");
			
			switch(Integer.parseInt(sc.nextLine())) {
				// 학생 수를 입력한다.
				case 1 -> {
					System.out.print("학생 수 > ");
					studentCount = Integer.parseInt(sc.nextLine()); // 원래는 nextInt로도 되지만, 조건이 nextLine이므로
					scores = new int[studentCount];
				}
				// 학생들의 점수를 입력한다.
				case 2 ->{
					// 예외처리 ------------------------
					// 학생수 입력안됨
					if(studentCount == 0) {
						System.out.println("학생 수가 입력되지 않았습니다. 학생 수를 입력해주세요.");
						continue;
					}
					// ----------------------------------
					for(int i = 0; i < scores.length; i++) {
						System.out.print("scores[" + i + "]: ");
						// 점수를 입력하지 않고 사용자가 엔터를 쳤다
						String inputScore = sc.nextLine();
						// 예외처리 --------------------
						if(inputScore.trim().isEmpty()) {
							System.out.println("점수가 입력되지 않았습니다. 다시 입력해주세요.");
							i--;
							continue;
						}
						// -------------------------------
						scores[i] = Integer.parseInt(inputScore);
					}
					
				}
				// 학생들의 점수 리스트를 출력한다.
				case 3 ->{
					// 예외처리 ------------------------
					// 학생수 입력안됨 -> 애초에 데이터가 존재할리 없음.
					if(studentCount == 0) {
						System.out.println("모든 데이터가 입력되지 않았습니다. 차례대로 데이터를 입력해주세요.");
						continue;
					}
					
					// ----------------------------------
					for(int i = 0; i < scores.length; i++) {
						System.out.println("scores[" + i + "]: " + scores[i]);
					}
				}
				// 분석한다.
				case 4 ->{
					
					// 예외처리 ------------------------
					// 학생수 입력안됨 -> 애초에 데이터가 존재할리 없음.
					if(studentCount == 0) {
						System.out.println("모든 데이터가 입력되지 않았습니다. 차례대로 데이터를 입력해주세요.");
						continue;
					}
					
					// 학생 데이터가 전부 0임
					boolean AllZeroScore = true;
					for(int value : scores) {
						if(value != 0) {
							AllZeroScore = false;
						}
					}
					if(AllZeroScore) {
						System.out.println("학생들의 점수가 입력되지 않았습니다. 점수를 입력해주시기 바랍니다.");
						continue;
					}
					// ------------------------
					
					int maxScore = 0;
					int totalScore = 0;
					
					for(int value : scores) {
						if(value > maxScore) maxScore = value;
						totalScore += value;
					}
					System.out.println("최고 점수: " + maxScore);
					System.out.printf("평균 점수: %.1f%n" ,(double)totalScore/scores.length);
				}
				
				// 프로그램을 종료한다. 
				case 5 ->{
					System.out.println("프로그램 종료");
					sc.close();
					return;
				}
				// 잘못된 걸 입력 시
				default -> { System.out.println("잘못 입력하셨습니다. 메뉴에 있는 숫자를 입력해주세요.");}
			}
		}
	}

}
