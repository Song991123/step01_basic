package ex0206.array.goods;
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
      초기치 데이터를 세팅하는 메소드
	  String [][] data = new String [][]{
			 {"A01" , "새우깡" , "2500" , "짜고 맛나다."},  //---> Goods 
			 {"A02" , "고구마깡" , "3500" , "고구맛이고 달다."},  //---> Goods 
			 {"A03" , "감자깡" , "5000" , "감자맛에 고소한맛."}, // ---> Goods 
			 {"A04" , "허니버터칩" , "2200" , "달콤 하다."},
			 {"A05" , "콘칩" , "3000" , "고소하다."}
			 
		};
   */
   public void init(String [][] data){
	  for(String[] goods : data) {
		  goodsArr[count++] = create(goods);
	  }
   }//메소드끝


   /**
      Goods를 생성해서 값을 설정하고 생성된 Goods를 리턴하는 메소드 
   */
   private Goods create(String [] row){
	   //{"A01" , "새우깡" , "2500" , "짜고 맛나다."}
	   Goods goods = new Goods();
	   
	   goods.setCode(row[0]);
	   goods.setName(row[1]);
	   goods.setPrice(Integer.parseInt(row[2]));
	   goods.setExplain(row[3]);
	   
	   return goods;
   }


   /**
     등록(등록실패 - 중복인경우, 배열의 길이 벗어난경우)
	 @return : 
			 0이면 상품코드 중복 ,
			 1이면 등록성공, 
			 -1이면 배열의 길이 벗어남
   */
   public int insert(Goods goods){

	   // 배열의 길이 체크
	   if(count == goodsArr.length) return -1;

	   //중복체크 
	   String code = goods.getCode();
	   if(selectByCode(code) != null) return 0;
	   
	   //문제없을 시
	   goodsArr[count++] = goods;
	   return 1;
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