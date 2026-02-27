package ex0225.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 상대측에게 데이터를 전송하는 스레드
 * */
public class SendThread extends Thread{
	String  name;
	Socket sk;
	
	public SendThread(Socket sk, String name) {
		super(name);
		this.name = name;
		this.sk = sk;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		try {
			// 상대측에 데이터를 전송한다.
			PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
			while(true) {
				String input = sc.nextLine();
				if("exit".equals(input)) {
					pw.println(input); //일단 이 사인을 보내기는 해야함.
					break;
				}
				
				pw.println(name + "보낸 내용 = " + input);
			}
			
			System.out.println(name + " Sent Thread 종료");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(name + " SendThread 의 예외 발생");
		} finally {
			System.out.println("--모든 프로그램 종료--");
			System.exit(0);
		}
	}
	
}
