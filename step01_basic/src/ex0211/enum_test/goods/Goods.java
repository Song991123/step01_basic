package ex0211.enum_test.goods;
/**
  상품으로 속성을 관리하는 개체
*/
public class Goods{
	private String code; //상품코드 null
	private String name;//상품이름  null
	private int price;//가격 0 
	private String explain;//설명 null
	
	/**
	 * 기본생성자
	 * */
	public Goods() {
		
	}
	/**
	 * 등록용 생성자 추가
	 * */
	public Goods(String code, String name, int price, String explain) {
		this(code, price, explain); // 같은 부분이 있으니 재사용
		this.name    = name;
	}
	/**
	 * 수정용 생성자 추가
	 * */
	public Goods(String code, int price, String explain) {
		this.code    = code;
		this.price    = price;
		this.explain = explain;
	}
	
	
	// GETTER ===========================
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getExplain() {
		return explain;
	}
	// SETTER ===========================
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}

}