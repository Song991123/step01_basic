package ex0205.array;
class MultiArray{
	//정수형 2차원 배열 8*9
	int arr[][] = new int[8][9];
	
	//메소드이름 :array99
	public void array99() {
		//for loop 를 사용하여 
		for(int i = 0; i < arr.length; i++) {
			System.out.println("=========="+(i+2)+"단 ==========");
			for(int j =0; j < arr[i].length; j++) {
				//배열에 곱한 (구구단)결과저장
				arr[i][j] = (i+2) * (j+1);
				//배열에 결과를 꺼내출력
				System.out.printf(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		// 향상된 for문으로 해보기 -------------
		for (int[] a : arr) {	
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		
		
	}
	public void apartManager() {
		String apart[][] = new String[10][];
		int count     = 0;
		
		for(int i = 0; i < apart.length; i++) {
			count++;
			apart[i] = new String[count];
			for(int j = 0; j < count; j++) {
				//이쁘게 보이기 위해서
				String reName = (i+1)/10 == 0? "0"+(i +1) : "" + (i+1);
				apart[i][j] = reName + "동 " + (j+1) + "호";
				System.out.printf(apart[i][j] + " | ");
			}
			System.out.println();
		}
	}
}
public class MemoryApart{
	//main메소드에서 
	public static void main(String[] args) {
		//MultiArray객체의 array99메소드호출
		new MultiArray().array99();
		new MultiArray().apartManager();
	}
}

