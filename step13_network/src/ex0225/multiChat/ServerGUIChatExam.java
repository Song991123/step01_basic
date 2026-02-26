package ex0225.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerGUIChatExam {
	Socket sk;
	List<ClientskThread> list = new ArrayList<>();

	public ServerGUIChatExam() {
		while(true) {
			try (ServerSocket server = new ServerSocket(8002)){
				System.out.println("Client 접속 대기 중");
				sk = server.accept();

				System.out.println(sk.getInetAddress() + "님 접속하셨습니다.");

				ClientskThread th = new ClientskThread();
				list.add(th);
				th.start();

				System.out.println("현재 접속 인원 : " + list.size() + "명\n");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // 생성자 끝

	/**
	 * 현재 서버에 접속해 있는 모든 클라이언트에게
	 * 동일한 메시지를 전송하는 메소드 (브로드캐스트)
	 */
	public void sendMessage(String message) {
		// list에는 현재 접속 중인 모든 클라이언트 스레드가 저장되어 있음
		for(ClientskThread th : list) {
			// 각 클라이언트가 가지고 있는 PrintWriter를 통해
	        // 해당 클라이언트 소켓으로 메시지를 전송한다.
	        // 즉, 한 명에게 보내는 것이 아니라 "접속자 전원"에게 보낸다.
			th.pw.println(message);
		}
	}
	
	/////////// Inner class //////////////
	class ClientskThread extends Thread{
		PrintWriter pw;
		BufferedReader br;
		String nickName;

		public ClientskThread() {
			try {
				pw = new PrintWriter(sk.getOutputStream(), true);
				br  = new BufferedReader(new InputStreamReader(sk.getInputStream()));


			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 생성자 끝
		
		
		@Override
		public void run() {
			// 클라이언트가 보내온 내용을 읽어서 접속한 모든 클라이언트에게 전송한다.
			try {
				nickName = br.readLine(); //대화명 저장
				
				sendMessage("[" + nickName + "] 님이 입장하셨습니다.");
				
				while(true) {
					String inputData = br.readLine();
					sendMessage("[" + nickName + "]" + inputData);
				}
			} catch (Exception e) {
				//e.printStackTrace();
				// 현재 스레드에 문제 발생
				// 현재 스레드를 list에서 제거
				
				list.remove(this); // 내가 장애가 생겼으니 this로 나를 제거.
				// 남아있는 클라이언트에게 알려준다.
				sendMessage("[" + nickName + "]님이 퇴장하셨습니다");
				
				// 서버 콘솔에 인원수 출력
				System.out.println("[" + nickName + "]님 퇴장 | 현재 인원 = " + list.size() + "명");
			}
		}
	}
	//////////////////////////////////////
	public static void main(String[] args) {
		new ServerGUIChatExam();
	}

}
