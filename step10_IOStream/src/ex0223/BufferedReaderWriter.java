package ex0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriter{
	public BufferedReaderWriter() {
		try (BufferedReader br = new BufferedReader(new FileReader("src/ex0223/text.txt"));
			  BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0223/song.txt"))){
			
			// 한 문자 읽기
//			int i = 0;
//			while((i = br.read()) != -1) {
//				System.out.println(i + " = " + (char)i); // 앞선 예제는 byte로 읽었고, 여기는 character로 읽어들임
//			}
			String data = null;
			while((data = br.readLine()) != null) { // readLine : byte쪽에는 없고, 한줄단위로 읽어옴. 
				System.out.println(data);
				bw.write(data);
				bw.newLine(); // 개행
				bw.flush();
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new BufferedReaderWriter();
	}

}
