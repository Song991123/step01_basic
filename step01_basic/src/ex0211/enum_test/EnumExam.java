package ex0211.enum_test;

public class EnumExam {

	public static void main(String[] args) {
//		Grade g = Grade.BASIC;
		
//		switch(g) {
//			case BASIC -> System.out.println("일반 고객");
//			case SILVER -> System.out.println("우수 고객");
//			case GOLD -> System.out.println("최우수 고객");
//		}
		
		Grade g = Grade.BASIC;
		System.out.println(g.getCode());
		System.out.println(g.getName());
	}

}
