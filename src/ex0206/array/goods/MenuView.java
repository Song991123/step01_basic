package ex0206.array.goods;
import java.util.Scanner;
/**
 키보드 입력을 받아 각 기능을 호출해줄 View
*/
public class MenuView{

 private Scanner sc = new Scanner(System.in);
 private GoodsService service = new GoodsService(); //전역변수 초기화

  /**
    전체 메뉴를 출력하는 메소드 
  */
  public void printMenu(String [][] data){

      //전달 받은 초기치 데이터를 서비스에 전달해서 배열에 저장한다.
      service.init(data);
      
	  while(true){
		  String menu =
			        "---------------------------------------------------------------------------\n" +
			        "1.등록     2.전체검색      3.상품코드검색    4. 수정하기     5. 삭제하기     9.종료\n" +
			        "----------------------------------------------------------------------------\n";
         
		 int menuChoice = readInt(menu + "메뉴 선택 > ");

		 switch(menuChoice){
             case 1 : 
				 this.inputInsert() ; break;
			 case 2 : 
				 Goods [] goodsArr = service.selectAll(); 
			     EndView.printSelectAll(goodsArr);
			      break;
			 case 3 : 
				 this.inputSelectByCode(); break;
			 case 4 : 
				 this.inputUpdate() ; break;
			 case 5 :
				 this.inputDelete(); break;
			 case 9 : 
				 System.out.println("다음에 또 이용해주세요. 프로그램 종료합니다.");
				 System.exit(0); 
			 break;
			 default: System.out.println("메뉴는 1~5 or 9 만 입력해주세요.");

		 }//switch문

	  }//while문

  } //printMenu끝

  /**
     등록관련 키보드 입력
  */
  public void inputInsert(){
	  Goods goods = new Goods();
	  
       //키보드입력 4개 받기 
	   System.out.print("상품코드 > ");
	   String code = sc.nextLine();

	   System.out.print("상품이름 > ");
	   String name = sc.nextLine();
	   
	   int price = readInMin("상품가격 > ", 1);

	   System.out.print("상품설명 > ");
	   String explain = sc.nextLine();
	   
	   goods.setCode(code);
	   goods.setName(name);
	   goods.setPrice(price);
	   goods.setExplain(explain);
	   
	   int result = service.insert(goods);

	   if(result==-1)
		  EndView.printMessage("더이상 등록할 수 없습니다.");
	   else if(result==0)
		  EndView.printMessage(code+"는 중복이므로 등록할수 없습니다.");
	   else 
           EndView.printMessage("상품이 등록되었습니다.");
  }

  /**
    상품코드 검색 키보드 입력
  */
  public void inputSelectByCode(){
       System.out.print("검색하려는 상품코드 > ");
	   String code = sc.nextLine();

	  Goods goods = service.selectByCode( code );
	  if(goods==null){
          EndView.printMessage(code+"는 잘못되어 검색할수 없습니다.");
	  }else{
          EndView.printSelectByCode(goods);
	  }
  }

  /**
    수정하기 키보드 입력 
  */
  public void inputUpdate(){
	   Goods goods = new Goods();
	  
       //키보드입력 4개 받기 
	   System.out.print("수정하려는 상품코드 > ");
	   String code = sc.nextLine();
	   
	   int price = readInMin("변경 상품가격 > ", 1);
	   
	   System.out.print("변경 상품설명 > ");
	   String explain = sc.nextLine();
	   
	   
	   //위 3개의 정보를 하나의 Goods객체로 만든다.
	   goods.setCode(code);
	   goods.setPrice(price);
	   goods.setExplain(explain);
	   
	   
	   if(service.update(goods) ){
          EndView.printMessage("상품이 수정되었습니다.");
	   }else{
          EndView.printMessage("상품이 수정되지않았습니다.");
	   }

  }
  /**
   * 삭제하기 키보드 입력
   * */
  public void inputDelete(){
	  
	  System.out.println("삭제하려는 상품코드 > ");
	  String code = sc.nextLine();
	  
	  Goods goods = service.selectByCode( code );
	  if(goods==null){
          EndView.printMessage(code+"는 존재하지 않습니다.");
          return;
	  }else{
		  System.out.println("*** 상품 정보 ***");
          EndView.printSelectByCode(goods);
	  }
	  
	  System.out.println("정말로 삭제하시겠습니까?(y/n)");
	  String isConfirmed = sc.nextLine();
	  
	  if(isConfirmed.equalsIgnoreCase("y")) {
		  
		   if(service.delete(code)){
		          EndView.printMessage("상품이 삭제되었습니다.");
			   }else{
		          EndView.printMessage("상품이 삭제되지 못했습니다.");
			   }
	  }
	  else {
		  EndView.printMessage("삭제가 취소되었습니다.");
	  }
	  
  }
  
  
  
  /**
   * price 값이 숫자로만 들어왔는지 체크하는 메소드
   * @return 사용자가 입력한 price값
   * */
  private int readInt(String message) {
	  while(true) {
		  System.out.println(message);
		  String price = sc.nextLine();
		  try {
			  return Integer.parseInt(price.trim());
		  }
		  catch(NumberFormatException e) {
			  EndView.printMessage("값을 잘못입력했습니다. 정수로만 입력해주시기 바랍니다.");
		  }
	  }
  }
  
  /**
   * 최소 가격을 만족하는지 확인하는 메소드
   * @param message 콘솔창에 출력할 메세지
   * @param minPrice 들어올 수 있는 최소 값
   * @return 사용자가 입력한 price 값
   * */
  private int readInMin(String message, int minPrice) {
	  while(true) {
		  int price = readInt(message);
		  if(minPrice > price) {
			  EndView.printMessage(minPrice + "이상의 값만 입력할 수 있습니다.");
			  continue;
		  }
		  return price;
	  }
  }
  
  //메소드끝
  


}//클래스끝