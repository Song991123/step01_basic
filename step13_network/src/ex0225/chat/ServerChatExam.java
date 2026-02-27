package ex0225.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import ex0225.net.SendThread;

/**
 * 클라이언트와 1:1 채팅
 * */
public class ServerChatExam {
	public ServerChatExam() {
		try {
			ServerSocket server = new ServerSocket(8001);
			System.out.println("클라이언트 접속 대기 중...");
			Socket sk = server.accept();
			System.out.println(sk.getInetAddress().toString() + "님과 대화 시작합니다.");
			
			// 읽기 ---
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
						
						while(true) {
							String readData =br.readLine();
							if("exit".equals(readData)) break;
							
							System.out.println(readData);
						}
						
						System.out.println("ServerThread 종료");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println(" ServerThread 의 예외 발생");
					}finally {
						System.out.println("--모든 프로그램 종료--");
						System.exit(0);
					}
				}
			}).start();
			
			// 쓰기 ---
			new SendThread(sk, "[Server]").start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServerChatExam();
	}

}
