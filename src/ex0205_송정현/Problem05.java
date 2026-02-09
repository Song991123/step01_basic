package ex0205_송정현;
/**
 * 작성자 : 송정현 <br>
 * 작성일 : 26.02.25 <br>
 * 문제 : int arr[] = {5, 7, 1, 2, 4, 3, 8, 9, 10} 배열 방에 있는 데이터를 올림차순으로 정렬해 출력한다.<br>
 * 먼저, 코딩 전에 아래의 세 가지 알고리즘을 찾아본다.
 * */
public class Problem05 {

	public static void main(String[] args) {
		// 배열 선언
		int arr[] = {5, 7, 1, 2, 4, 3, 8, 9, 10};
		

		// 1. 선택 정렬 알고리즘
//		int temp 	  			 = 0;
//		for(int i =0; i < arr.length - 1; i++) { 
//			int minValue = arr[i];
//			int lastFoundIndex = i; 
//			
//			for(int j = i + 1; j < arr.length; j++) {
//				
//				if(minValue > arr[j]) {
//					lastFoundIndex = j;
//					minValue          = arr[j];
//				}
//			}
//			// 여태 찾아낸 값들 중 가장 작은 값과 swap
//			temp = arr[lastFoundIndex];
//			arr[lastFoundIndex] = arr[i];
//			arr[i] = temp;
//			
//		}
//		System.out.print("선택 정렬 : ");
//		for(int value : arr) {
//			System.out.print(value + " ");
//		}
		
		// 2. 버블 정렬 알고리즘
//		int temp = 0;
//		for(int i = 0; i < arr.length -1; i++) {				// i 는 0 ~ 7 까지
//			for(int j = 0; j < arr.length - i -1; j++) {		// j는  0 ~ 7- i -1 까지 
//				// 왼쪽 값이 오른쪽보다 크면 swap
//				if(arr[j] > arr[j+1]) {
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}	
//		}
//		System.out.print("버블 정렬 : ");
//		for(int value : arr) {
//			System.out.print(value + " ");
//		}
		
		// 3. 삽입 정렬 알고리즘
		for(int i = 1; i < arr.length; i++) {
			System.out.println(i);
			// key값 저장
			int key = arr[i];
			int lastIndex = i;
			// 0부터 i전까지 순회
			for(int j = i - 1; j >= 0; j--) {
				System.out.println(j);
				if(key < arr[j]) {
					arr[j+1] = arr[j];
					lastIndex = j;
				}
			}
			// swap
			arr[lastIndex] = key;	
		}
		for(int value : arr) {
			System.out.print(value + " ");
		}
	
	}

}
