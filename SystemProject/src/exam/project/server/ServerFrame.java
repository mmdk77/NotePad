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
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		information();
		reservation();
		
	}
	public void information(){
		btn1 = new JButton("��ȭ�����Է�");
		this.add(btn1);

	}
	public void reservation(){
		btn2 = new JButton("������");
		this.add(btn2);

		
	}
}
