package ex0223.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class FileCopyBufferedExam implements AutoCloseable{

	public FileCopyBufferedExam(String readFile, String writeFile) {
		long start = System.nanoTime();

		try(BufferedInputStream bfInput    = new BufferedInputStream(new FileInputStream(readFile));
				BufferedOutputStream bfOutput = new BufferedOutputStream(new FileOutputStream(writeFile, true));) {
			// readFile에 있는 내용을 읽어서 writeFile에 저장한다. (Buffered 사용)
			
			
			byte[] buffer = new byte[1024];
			int readCount;
			// bfInput.read()만 하면 1byte씩 읽어와서 느림
			// 이렇게 하면 한 번에 1024바이트씩 읽는다.
			while((readCount = bfInput.read(buffer)) != -1) { 
				// buffer 배열에서 0번 인덱스부터 readCount개만큼 파일에 써라
			    bfOutput.write(buffer, 0, readCount);
			}
			bfOutput.flush(); // 버퍼 비우기
			System.out.println("파일 복사 완료");
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		
		long end  = System.nanoTime();
		
		System.out.println((end - start) + "ns");
	}
	public static void main(String[] args) {
		String readFile = JOptionPane.showInputDialog("읽을 파일명은?");
		String writeFile = JOptionPane.showInputDialog("저장할 파일명은?");
		
		new FileCopyBufferedExam(readFile, writeFile);
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
