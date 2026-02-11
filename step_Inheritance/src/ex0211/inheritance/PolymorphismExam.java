package ex0211.inheritance;
/**
 * 부모 자식간의 promotion, casting을 하는 예제 
 **/
class CarCenter{
	// 매개변수를 이용한 다형성 -> 접근범위 제약이 있을 시 Car타입 부분만 접근가능.
	public void engineer(Car cd){ // cd =c;
		System.out.println("cd 주소 = " + cd);

		//		System.out.println("cd.i = " cd.i); // 부모타입으로는 자식부분 접근 불가
		// 접근 가능하도록 부모타입을 자식타입으로 형변환(ObjectDownCasting)
		// 근데 ObjectDownCasting을 하면 밑에와 같은 예외 가능성이 일어날 가능성이 있어, instanceof를 해줄 것
		if(cd instanceof EfSonata) {
			System.out.println("------------------------");
			EfSonata efs = (EfSonata)cd; // ClassCastException 예외 가능성
			System.out.println("efs 주소 = " + efs);
			System.out.println(efs.i);
			System.out.println("------------------------");
		}
		
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		
		CarCenter cc=new CarCenter();
		// Car의 자식 객체들 생성
		EfSonata ef=new EfSonata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();
		
		Car c= new Car();
		
		cc.engineer(c);  //
		cc.engineer(ef); //
		cc.engineer(ca); //
		cc.engineer(ex); //
		
		
	
	}
}
