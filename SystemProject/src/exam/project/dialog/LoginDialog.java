package exam.project.dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exam.project.frame.MovieFrame;

public class LoginDialog extends JDialog {
	
	public static final String CloseAction = null;
	private MovieFrame MF;
	private JButton btn1,btnClose;
	private JLabel id,pwd,test;
	private JPanel p1,p2,p3,p4;
	private JTextField idInput;
	private JPasswordField pwdInput;
	private Container con = getContentPane();
	
	
	public LoginDialog(MovieFrame MF){
		
		super(MF,"�α���",false);
		this.MF = MF;
		this.setSize(300,200);
		this.setVisible(true);
		
		loginUi();
		eventListener();
	}
	public void loginUi(){
			
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
			
		p1.setLayout(new GridLayout(0,1,20,5));	
		id = new JLabel("�α���");
		pwd = new JLabel("�н�����");
		test = new JLabel("��ư �̺�Ʈ Ȯ�ο�");

		p1.add(id);
		p1.add(pwd);
		
			
		p2.setLayout(new GridLayout(0,1,20,5));
		idInput = new JTextField();
		pwdInput = new JPasswordField();			
		p2.add(idInput);
		p2.add(pwdInput);
		
		btn1 = new JButton("�α���");
		btnClose = new JButton("���");
			
		p3.add(btn1);
		p3.add(btnClose);
		p3.add(test);
			
		con.add(p1,"West");
		con.add(p2,"Center");
		con.add(p3,"South");	
		
		
		this.setVisible(true);
				
	}
	
	public void eventListener(){	
		
		btnClose.addActionListener(new EventListener());
		btn1.addActionListener(new EventListener());
		

	}
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			String strCmd = e.getActionCommand();
			
			if(strCmd.equals("�α���")){
				test.setText("�α���");
			}
			else if(strCmd.equals("���")){
				test.setText("���");
			}
		}
			
	
		}
	
}
