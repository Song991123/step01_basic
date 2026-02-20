package ex0220.set;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
//	Set<String> set = new HashSet<>();
//	Set<String> set = new TreeSet<>(); // 기본으로 정렬해줌(올림차순)
	Set<String> set = new TreeSet<String>(Collections.reverseOrder()); // comparator를 써서 정렬 기준을 바꾸기
	
	
	public SetExam(String[] args) {
		// 추가
		for(String s : args) {
			boolean re = set.add(s); // 중복안됨
			System.out.println(s + " 추가 결과 = " + re);
		}
		System.out.println("저장된 개수 = " + set.size());
		
		// Set에 저장된 데이터를 하나씩 꺼내기 위한 객체 생성
		// Iterator는 컬렉션(List, Set 등)의 요소를 순차적으로 접근하기 위한 인터페이스
		// set.iterator() : Set 안에 있는 데이터를 처음부터 끝까지 탐색할 수 있는 도구를 반환
		System.out.println("---정보 출력---");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("\n --- 요소 제거 ---");
		boolean re = set.remove("희정");
		System.out.println("제거 결과 = " + re);
		System.out.println("제거 후 : " + set); // set.toString도 오버라이딩이 되어있어서 주소가 아닌 값이 나오게 된다.
		
		System.out.println("\n --- 존재 여부 ---");
		String name = "진주";
		re = set.contains(name);
		System.out.println(name + " 존재 여부 = " + re);
		
	}



	public static void main(String[] args) {
		new SetExam(args);
	}

}
