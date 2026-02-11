package ex0211.overriding.goods;
/**
 * 과제 : 빈 곳들의 기능을 채워라
    수행자 : 송정현
  	작성일자 : 26.02.06
  각 요청에 대한 로직(기능)을 담당할 클래스
  (등록 , 전체검색, 부분검색, 수정, 삭제 등등.....)
*/
public class GoodsService{

	//상품을 관리할 배열 선언
	private Goods [] goodsArr = new Goods [10];
	public static int count;//0 배열방에 저장 객체의 개수 
	
	/**
	 * init 메소드를 없애고, 생성자 추가
	 * 초기 데이터 세팅
	 * */
	public GoodsService(String [][] data) {
		  for(String[] goods : data) {
			  goodsArr[count++] = create(goods);
		  }
	}

   /**
      Goods를 생성해서 값을 설정하고 생성된 Goods를 리턴하는 메소드 
   */
   private Goods create(String [] row){
	   //{"A01" , "새우깡" , "2500" , "짜고 맛나다."}
	   Goods goods = new Goods(row[0], row[1], Integer.parseInt(row[2]), row[3]);
	   
	   return goods;
   }


   /**
     등록(등록실패 - 중복인경우, 배열의 길이 벗어난경우)
	 @return : 
			 0이면 상품코드 중복 ,
			 1이면 등록성공, 
			 -1이면 배열의 길이 벗어남
   */
   public InsertResult insert(Goods goods){

	   // 배열의 길이 체크
	   if(count == goodsArr.length) return InsertResult.INSERT_OUTINDEX;

	   //중복체크 
	   String code = goods.getCode();
	   if(selectByCode(code) != null) return InsertResult.INSERT_DUPLICATE;
	   
	   //문제없을 시
	   goodsArr[count++] = goods;
	   return InsertResult.INSERT_SUCCESS;
   }


   /**
     전체검색
   */
   public Goods[]  selectAll( ){
      return goodsArr;
   }

   /**
     상품코드에 해당하는 상품 검색
	 @return : 만약 code에 해당하는 값이 있으면 Goods를 리턴하고
	           없으면 null 리턴
   */
   public Goods selectByCode(String code){
	   
	   int index = indexOf(code);
	   if(index >= 0) return goodsArr[index];
       
       return null;
   }


   /**
    상품코드에 해당하는 가격, 설명 수정하기 
	@return : true이면 수정완료, false이면 수정실패
   */
   public boolean update(Goods goods){ //수정하려는 코드, 변경값 - 가격, 설명
	   Goods foundGoods = selectByCode(goods.getCode());
	   if(foundGoods == null) return false;
	   else {
		   foundGoods.setPrice(goods.getPrice());
		   foundGoods.setExplain(goods.getExplain());
		   
	       return true;
	   }
   }
   
   /**
    * 상품코드에 해당하는 객체 삭제하기
    * @param String code 
    * @return : true면 삭제 완료, false면 삭제 실패
    * */
   	public boolean delete(String code) {
   		int index = indexOf(code);
   		// 코드랑 일치하는 객체가 있는지 탐색 후, 없으면 삭제 실패
 	    if(index < 0) return false;
	   
 	    for(int i = index; i < count - 1; i++) {
 	    	goodsArr[index] = goodsArr[index+1];
 	    }

 	   goodsArr[--count] = null;
 	    
 	   
	   return true;
   }
   	
   	/**
   	 * 들어온 code와 일치하는 index값을 return하는 메소드
   	 * @param code 상품코드값
   	 * @return 인덱스 값
   	 * */
   	private int indexOf(String code) {
        for(int i = 0; i < count; i++) {
     	   if(goodsArr[i].getCode().equals(code)) {
     		   return i;
     	   }
        }
        return -1;
   	}
}