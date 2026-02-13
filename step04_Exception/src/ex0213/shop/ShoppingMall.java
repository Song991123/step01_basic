package ex0213.shop;

public class ShoppingMall {
	public void checkAge(int age) throws UnderAgeAccessException{
		if(age < 18) throw new UnderAgeAccessException();
		System.out.println("입장하신걸 환영합니다.");
	}
}
