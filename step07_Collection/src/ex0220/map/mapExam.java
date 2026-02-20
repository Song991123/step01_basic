package ex0220.map;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class mapExam {
//	Map<Integer, String> map = new HashMap<Integer, String>();
	Map<Integer, String> map = new TreeMap<Integer, String>();
			
	public mapExam() {	
		// map에 추가
		map.put(20, "희정");
		map.put(10, "나영");
		map.put(40, "미미");
		map.put(20, "효리");
		map.put(10, "삼순");
		System.out.println("저장된 개수 = " + map.size());
		System.out.println("map = " + map);
		
		// map에 들어있는 key, value 꺼내기 (key와 value 한쌍 = Entry)
		
		///////////////////// 조회하는 여러가지 방법 /////////////////////
		// 모든 key의 정보를 가져옴 (일반적으로 할 경우)
//		Set<Integer> keySet = map.keySet();		// 1. 모든 key 정보를 Set에 저장
//		Iterator<Integer> it = keySet.iterator();  // 2. key를 꺼낼 수 있는 준비
//		while(it.hasNext()) {								// 3. 요소가 있다면(꺼낼 게 있다면)
//			int key = it.next();								// 4. 꺼낸 key에 해당하는 value 조회
//			String value = map.get(key);
//			System.out.println(key + "살의 " + value);
//		}
		
		// 개선된 for문으로 모든 key의 정보를 가져옴
		System.out.println("--- 개선된 for문 사용 ---");
		for(Integer key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + " & " + value);
		}
		
		// Entry 형태로 조회하기 
		System.out.println("--- Entry 형태로 조회하기 ---");
		Set<Entry<Integer, String>> set = map.entrySet();
		for(Entry<Integer, String> e : set) {
			System.out.println(e.getValue() + " & " + e.getValue());
		}
		//////////////////////////////////////////////////////////////
		
		// 삭제
		System.out.println("--- 삭제 ---");
		map.remove(20);
		System.out.println("삭제 후 = " + map);
	}

	public static void main(String[] args) {
		new mapExam();
	}

}
