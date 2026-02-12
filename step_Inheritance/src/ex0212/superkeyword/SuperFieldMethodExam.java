package ex0212.superkeyword;

class Animal{
	int age = 5;
	String bodyColor;
	
	public void sound() {
		System.out.println("super의 sound call...");
	}
	public void eat() {
		System.out.println("super의 eat call...");
	}
}
///////////////////////////////////////////
class Cat extends Animal{
	int age 	= 10;
	int weight;
	
	@Override
	public void sound() {
		System.out.println("cat의 sound call...");
	}

	public void run() {
		System.out.println("cat의 run call...");
	}
	
	public void test() {
		System.out.println("********* 필드  test *********");
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(super.age);
		System.out.println("----------------");
		System.out.println(bodyColor);
		System.out.println(this.bodyColor);
		System.out.println(super.bodyColor);
		System.out.println("----------------");
		System.out.println(weight);
		System.out.println(this.weight);
//		System.out.println(super.weight); // 이거는 안됨.
		System.out.println("----------------");
		
		System.out.println("********* 메소드 *********");
		sound();
		this.sound();
		super.sound();
		System.out.println("----------------");
		eat();
		this.eat();
		super.eat();
		System.out.println("----------------");
		run();
		this.run();
//		super.run(); // 이건 안됨
		System.out.println("----------------");
		
	}
}


public class SuperFieldMethodExam {

	public static void main(String[] args) {
//		new Cat().test();
		
		System.out.println("--외부에서 객체 생성새 접근 --");
		Cat cat = new Cat();
		System.out.println(cat.age);
		System.out.println(cat.bodyColor);
		System.out.println(cat.weight);
		
		cat.sound();
		cat.eat();
		cat.run();
		
		System.out.println("===================");
		Animal an = new Cat(); // 다형성, Animal 부분만 접근이 가능
		System.out.println(an.age);
		System.out.println(an.bodyColor);
//		System.out.println(an.weight); // Animal에 weight가 없으므로.
		an.sound();
		
		an.eat();
//		an.run(); // Animal에 run 없음
		
		System.out.println("an = " + an);
		
		//an으로 접근 할 수 없는 자식 부분 접근을 위해 
		// ObjectDownCasting이 필요함
		if(an instanceof Cat) {
			Cat c = (Cat)an;
			System.out.println(c.weight);
			c.run();
		}
		
		/**
		 * Animal 안에 cat 객체가 없으므로 안되는 항목
		 * */
		System.out.println("----------------");
		Animal  a = new Animal();
		if(a instanceof Cat) {
			Cat	 cc	= (Cat)a; // 실행 도중 ClassCastingException 발생함. a안에 cat이 없어서
			
		}
		System.out.println(" ******************* ");
	}

}
