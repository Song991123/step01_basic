package ex0224;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIThreadExam extends JFrame{
	JTextField text1 = new JTextField(5);
	JTextField text2 = new JTextField(5);
	JButton btn = new JButton("눌려봐");
	
    public GUIThreadExam() {
    	super("GUIThreadExam 입니다.^^");
    	
    	
    	//JFrame 의 레이아웃 변경
    	super.setLayout(new FlowLayout());
    	
    	//Container위에 Component 추가 
         Container con = super.getContentPane();
         con.add(text1);
         con.add(text2);
         con.add(btn);
    	
    	//옵션 설정
    	//창크기
    	super.setSize(500, 400);
    	super.setLocationRelativeTo(null);//정중앙에 놓기
    	
    	//창보여줘.
    	super.setVisible(true);//보여줘
    	
    	//x를 클릭했을때 창 닫기 
    	super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// 시계 스레드 동작
    	new NowTimeThread().start();
    	
    	// textfield에 숫자 출력하기
    	new Thread(()-> {
    		for(int i = 1; i <= 1000; i++) {
    			text1.setText( i + ""); //내부적으로 1000이 들어오는 건 눈 깜짝할 새임.
    			try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}).start();
    	// 버튼 클릭 시 할일 - 이벤트 등록 -> 이벤트 발생 주체.addXxxListener(구현);
    	btn.addActionListener((e) ->{
    		new Thread(() -> {
    			for(char ch = 'A'; ch <= 'z'; ch++) {
    				text2.setText(ch + "");
    				try {
    					Thread.sleep(50);
    				} catch (InterruptedException exception) {
    					exception.printStackTrace();
    				}
    			}
    		}).start();
    	});
    	
    }//생성자 끝
    
/////////////////////////////////////////////////////
	/**
	 * 현재 날짜와 시간 title에 출력하는 스레드
	 */
	
    /////////////////////////////////////////////////////////
      
	public static void main(String[] args) {
		new GUIThreadExam();
		
	}
	
	/**
	 * 1초마다 동작하는 시계 Thread (Inner Class)
	 *  -> Inner Class로 outer의 클래스의 모든 필드와 메소드 접근 
	 * */
	class NowTimeThread extends Thread{
		@Override
		public void run() {
			
			while(true) {
				// 현재 시간을 가져오기
				Calendar now = Calendar.getInstance();
				
				now.get(Calendar.SECOND); // 초
				
				// JFrame 위에 title 변경
//				setTitle("제목 변경");
//				GUIThreadExam.this.setTitle("되나?");
				StringBuilder sb = new StringBuilder();

				int y = now.get(Calendar.YEAR);
				int m = now.get(Calendar.MONTH) + 1;
				int d = now.get(Calendar.DATE);

				int h = now.get(Calendar.HOUR);
				int min = now.get(Calendar.MINUTE);
				int sec = now.get(Calendar.SECOND);
				
				sb.append(y);
				sb.append("년 ");
				sb.append(m);
				sb.append("월 ");
				sb.append(d);
				sb.append("일 ");
				sb.append(h);
				sb.append(" : ");
				sb.append(min);
				sb.append(" : ");
				sb.append(sec);
				
				GUIThreadExam.this.setTitle(sb.toString());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			

		}
	}
}//클래스 끝

/////////////////////////////////
















