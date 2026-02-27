package ex0225.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import ex0225.net.SendThread;

/**
 * 서버와 1:1 채팅을 위한 클라이언트
 * */
public class ClientChatExam {
	public ClientChatExam() {
		try {
			Socket sk = new Socket("192.168.0.16", 8001);

			// 보내는 스레드
			new SendThread(sk, "[Client]").start();

			// 받는 스레드 inner class 말고 람다로
			new Thread(() -> {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
					
					while(true) {
						String readData =br.readLine();
						if("exit".equals(readData)) break;
						
						System.out.println(readData);
					}
					
					System.out.println("ClientThread 종료");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(" ClientThread 의 예외 발생");
				}finally {
					System.out.println("--모든 프로그램 종료--");
					System.exit(0);
				}
			}).start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ClientChatExam();
	}

}
