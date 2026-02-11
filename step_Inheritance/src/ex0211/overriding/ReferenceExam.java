package ex0211.overriding;

class ObjectExam{
	String value;
	
	public ObjectExam(){  
		
	}
	public ObjectExam(String str){   
		this.value = str;
	}
	
	@Override 
    public String toString() {
        return super.toString() + value;  
    }
}

class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			String s03=new String("월요일");
			ObjectExam oe1=new ObjectExam("진짜 가려고?");
			ObjectExam oe2=new ObjectExam("안녕");
			System.out.println(c);// a
			System.out.println(s01.toString());// 장희정
			System.out.println(s02);// Java
			System.out.println(s03);// 월요일
			System.out.println(oe1.toString());// 주솟값
			System.out.println(oe2);// 주솟값
			
			// 다 사실 주소값인데, String은 주소값이 안나오는 이유가 println에 오버로딩으로
			// 해당 String 값을 받으면 주소 내부 문자를 출력하도록 구성되어있기 때문이다.
			// 즉, 인수 전달된 객체 .toString()을 한 리턴값을 자동으로 출력.
			
			/**
			 * 	String은 Object의 toString을 오버로딩 하고 있음.
			 * 
			 *     public String toString() {
        				return this;
    				}
    				
    				Object에 있는 toString은 다음과 같음
    				
				    public String toString() {
        				return getClass().getName() + "@" + Integer.toHexString(hashCode());
    				}
			 * */
			
	}
}
