package ex0204.scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// 키보드 입력
		Scanner sc = new Scanner(System.in);
		
		// 키보드 입력은 숫자, 문자열, 문자열(공백존재)
		System.out.print("숫자 > ");
		int num        = sc.nextInt();
		
		System.out.print("문자열 > ");
		String st       = sc.next(); 			// 공백 없이 문자열
		sc.nextLine(); //nextLine이 \n을 받으면 끝나버리니까 의미없는 구문 넣음
		
		String stLine = sc.nextLine();

		// 출력 ==============================
		System.out.println("숫자 : " + num);
		System.out.println("문자열 : " + st);
		System.out.println("문자열(공백) : " + stLine);
		
	}

}
