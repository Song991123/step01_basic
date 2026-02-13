package ex0213.shop;

import java.util.Random;

public class ShopMain {

	public static void main(String[] args) {
		ShoppingMall sm = new ShoppingMall();
				
		int count = 1;
		Random random = new Random();
		while(count <= 10) {
			int randomNo = random.nextInt(55) + 1;
			
			System.out.println("나이 = " + randomNo);
			try{
				sm.checkAge(randomNo);
			}catch(UnderAgeAccessException e) {
				System.out.println(e.getMessage());
			}
			count++;
		}
		System.out.println("예외 발생 수 = " + UnderAgeAccessException.exceptionCount);
	}

}
