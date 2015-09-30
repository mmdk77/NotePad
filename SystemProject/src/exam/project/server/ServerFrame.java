package exam.project.server;

import javax.swing.*;

import java.awt.*;

public class ServerFrame extends JFrame{
	
	private JButton btn1,btn2,btn3;
	private JLabel lb;
	private Container con = getContentPane();
	
	
	public ServerFrame() {
		super("서버");
		this.setSize(300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		lb = new JLabel("서버관리");
		
	
		con.add(lb);
		this.setLayout(new GridLayout(5,1));
		addMoiveInfo();
		reservation();
		
	}
	public void addMoiveInfo(){
		
		btn1 = new JButton("영화정보입력");
		con.add(btn1);
		this.setVisible(true);

	}
	public void reservation(){
		
		btn2 = new JButton("예매율");
		con.add(btn2);
		this.setVisible(true);

		
	}
}
