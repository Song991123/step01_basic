package ex0205.array;

public class ArgsExam {
	// String[] args는 실행 java ArgsExam 값 값 값 값 할 때 들어옴
	public static void main(String[] args) {
		System.out.println("====== 시작하기 ======");
		System.out.println("args = " + args);
		System.out.println("args.length : " + args.length);
		/*
		 * for(String a : args) { System.out.println(a); }
		 */
		
		// 만약 두 개의 숫자값이 전달되었다고 가정하고 합을 출력해라.
		System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
	}

}
