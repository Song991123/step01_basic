package ex0203제어문;

public class SwitchExam01 {

	public static void main(String[] args) {
		
		
		// 1. 1~12사이의 난수를 발생한다.
		int month = (int)(Math.random()*12+1);

		// 2. 그 난수는 월이라고 생각하고, 월에 해당하는 마지막 일수를 출력한다.
		int endDay = 31;
		
		System.out.println("========== SWITCH ==========");
		
		// 기존 switch 
		/*
		 * switch(month) { case 2 : endDay = 28; break; case 4: case 6: case 9: case 11:
		 * endDay = 30; break; }
		 */
		
		// v14이후 switch 
		/*
		 * switch(month) { case 2 : endDay = 28; break; case 4,6,9,11 :
		 * endDay = 30; break; }
		 */
		
		// java 21 최신버젼
		endDay = switch(month) {
			case 2 -> 28;
			case 4,6,9,11 -> {
				System.out.println("yield 테스트");
				yield 30;
			}
			default -> 31;
		};
		
		
		/*
		 * System.out.println("========== IF ==========");
		 * 
		 * if(month == 2) endDay = 28; else if(month == 4 || month == 6 || month == 9 ||
		 * month == 11 ) endDay = 30;
		 */
		
		
		System.out.println(month + "월은 " + endDay + "일까지 있습니다.");
	}

}
