package exam.project.server;

import javax.swing.*;

import java.awt.*;

public class ServerFrame extends JFrame{
	
	private JButton btn1,btn2,btn3;
	private JLabel lb;
	private Container con = getContentPane();
	
	
	public ServerFrame() {
		super("����");
		this.setSize(300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		lb = new JLabel("��������");
		
	
		con.add(lb);
		this.setLayout(new GridLayout(5,1));
		addMoiveInfo();
		reservation();
		
	}
	public void addMoiveInfo(){
		
		btn1 = new JButton("��ȭ�����Է�");
		con.add(btn1);
		this.setVisible(true);

	}
	public void reservation(){
		
		btn2 = new JButton("������");
		con.add(btn2);
		this.setVisible(true);

		
	}
}
