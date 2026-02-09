package ex0206.array.goods;

/**
  요청 결과를 출력할 view
*/
public class EndView{
   /**
     성공여부 메시지를 출력하는 메소드 
   */
   public static void printMessage(String message){
      System.out.println(message+"\n");
   }

   /**
     전체검색 결과를 출력하는 메소드
   */
   public static void printSelectAll(Goods [] arr){//service에 있는 주소가 전달되었다.
		System.out.println("*******상품 LIST (" + GoodsService.count + ")개 ************");
		for(int i = 0; i < GoodsService.count; i++) {
			System.out.printf(" %s | ", arr[i].getCode());
			System.out.printf(" %s | ", arr[i].getName());
			System.out.printf(" %s | ", arr[i].getPrice());
			System.out.printf("%s%n", arr[i].getExplain());
		}
		System.out.println();

   }

   /**
     상품코드에 해당하는 상세정보 출력하는 메소드 
   */
   public static void printSelectByCode(Goods goods){
	   if(goods == null) System.out.println(goods.getCode() + "는 잘못되어 검색할수 없습니다.");
	   else {
		   System.out.println("******"+goods.getCode() +"의 상세보기 *****");
		   System.out.printf(" %s | ", goods.getCode());
		   System.out.printf(" %s | ", goods.getName());
		   System.out.printf(" %s | ", goods.getPrice());
		   System.out.printf("%s%n", goods.getExplain());
	   }
   }


}