package ex0213;

public class ExceptionReturnExam {
     public void aa(int i) throws Exception{
    	 System.out.println("----aa------");
    	 try {
	    	 if(i==0) {
//	    		 throw new RuntimeException("예외발생"); //unchecked 예외종료
//	    		 throw new Exception("예외발생"); // checked 예외라 예외 처리를 해야함
	    		 System.exit(0);// -> 이거 만난 순간 프로그램 종료시킴 
	    	 }
	    	 System.out.println(i+"입니다.");
    	 }finally {
    	   System.out.println("----aa end------");
    	 }
     }
	public static void main(String[] args) throws Exception{
		System.out.println("**메인 시작 **");
		
		//new ExceptionReturnExam().aa(5);
		new ExceptionReturnExam().aa(0);
		
		System.out.println("***메인 끝 ***");

	}

}
