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
			try {
				/*
				//읽기
				nickName = br.readLine();	//닉네임 읽기
				// 최초에 읽을 때: 닉네임, 이후에 읽을 때: 채팅내용
				*/
				
				// 닉네임 중복 체크
				while (true) {
					boolean isExist = false;	// 중복이면 true, 중복이 아니면 false
					String newName = br.readLine();
					
					for (ClientskThread th : list) {
						// Socket을 받고 바로 스레드를 list에 넣어서 자기 자신이 아니라는 것도 체크해야함
						if ((this != th) && newName.equals(th.nickName)) {
							// 이름이 중복일 때
							isExist = true;
							pw.println(isExist);
							break;
						}
					}

					if (!isExist) {
						// 이름이 중복이 아닐 때 (client에 false 전달)
						pw.println(isExist);
						nickName = newName;
						break;
					}
				}
				
				
				
				// 접속되어 있는 모든 client 에게 알린다.
				sendMessage("----- [" + nickName + "]님이 입장하셨습니다. -----");
				
				while (true) {
					String inputData = br.readLine();
					sendMessage("[" + nickName + "] " + inputData);
					
				}
				
			} catch (Exception e) {
				//e.printStackTrace();
				// client의 socket 이 끊기면 여기로 오게 된다.
				
				// 현재 스레드를 list 에서 제거한다.
				list.remove(this);
				
				// 남아있는 모든 클라이언트에게 알린다.
				sendMessage("[" + nickName + "]님이 퇴장하셨습니다.");
				
				// 서버 콘솔 창에 출력한다.
				System.out.println("[" + nickName + sk.getInetAddress() + "]님 퇴장."); 
				System.out.println("현재 인원 = " + list.size());
				
			}
		}
	}
	//////////////////////////////////////
	public static void main(String[] args) {
		new ServerGUIChatExam();
	}

}
