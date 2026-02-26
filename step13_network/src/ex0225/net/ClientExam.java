package ex0225.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 원래는 클라이언트랑 서버랑 다른 패키지에 만들어야하는데, 학습용이라 같은 곳이 구성
public class ClientExam {
	public ClientExam() {
		try(Socket sk = new Socket("192.168.0.16", 8000)) { // 127.0.0.1 = 내 PC 본인을 가리킴 
			
			// 서버에 데이터를 전송한다.
			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
			pw.println("접속할래영 - 송정현");
					
			// 서버가 보내온 내용을 읽는다. (왜 이것먼저냐면 우리가 지금 멀티 스레드 환경을 구축한게 아니라서, 서로 번갈아가며 동작하면서 읽기만 하면 동작 자체가 아예 안됨)
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String data = br.readLine();
			
			System.out.println("서버가 보내온 내용 = " + data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ClientExam();
	}

}
