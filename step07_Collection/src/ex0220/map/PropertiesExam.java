package ex0220.map;

import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExam {
	Properties pro = new Properties();
	
	public PropertiesExam() {
		// 직접 저장
		pro.setProperty("id", "jang");
		pro.setProperty("age", "10");
		pro.setProperty("addr", "10");
		
		// 모든 key 정보 가져오기
		for(String key : pro.stringPropertyNames()) {
			System.out.println("키 정보 = " + key);
			String value = pro.getProperty(key);
			System.out.println("값 정보 = " + value);
		}
		
	} // 생성자 끝
	
	/////////////////////////////////////////////////////////

	/**
	 * 외부의 ~.properties파일을 로딩하는 법 2가지
	 * 1. IO를 이용
	 * 2. ResourceBundel을 이용
	 * 
	 */
	
	/**
	 * IO 이용 
	 */
	public void test01() throws Exception{
		pro.clear(); // 초기화
		// File를 읽는 것들은 기본적으로 src 파일을 기준으로 생각한다.
//		pro.load(new FileInputStream("src/ex0220/map/info.properties"));
		
		
//		2. 클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
		//PropertiesExam.class 클래스가 있는 위치(폴더)가 기준
//		InputStream inputStream = PropertiesExam.class.getResourceAsStream("info.properties");
//		pro.load(inputStream);
		
//		//3.클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
//		InputStream inpupStream = 
//		getClass().getResourceAsStream("Info.properties"); 
//		 pro.load(inpupStream);
			  
		
//		4.ClassLoader의 모든 경로에서 파일 읽음. 보통 resources 폴더의 파일 읽을때 사용.
		InputStream inpupStream = 
				this.getClass().getClassLoader().getResourceAsStream("a.properties"); 
//				this.getClass().getClassLoader().getResourceAsStream("src/ex0220/map/Info.properties"); 
		pro.load(inpupStream);

		
		// 모든 key 정보 가져오기
		for(String key : pro.stringPropertyNames()) {
			String value = pro.getProperty(key);
			System.out.println("키 정보 = " + key + " | 값 정보 = " + value);	
		}
	}
	/**
	 * ResourceBundle 이용 
	 */
	public void test02() {
		// ResourceBundle은 ~.properties 파일을 로딩하는 전용 클래스
		ResourceBundle rb = ResourceBundle.getBundle("a"); // classes 폴더를 기준으로 a.properties 로딩
		for(String key : rb.keySet()) {
			String value = rb.getString(key);
			System.out.println(key + " = " + value);
		}
	}
	
	public static void main(String[] args) throws Exception{
		PropertiesExam pe =  new PropertiesExam();
		System.out.println("=============================");
//		pe.test01(); 
		pe.test02();
		System.out.println("---------------");
		//pe.test02();
		
	}

}
