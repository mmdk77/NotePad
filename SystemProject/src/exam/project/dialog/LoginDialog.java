package exam.project.dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exam.project.frame.MovieFrame;

public class LoginDialog extends JDialog{
	
	public static final String CloseAction = null;
	private MovieFrame MF;
	private JButton btn1,btnClose;
	private JLabel id,pwd;
	private JTextArea idInput,pwdInput;
	private Container con = getContentPane();
	
	
	public LoginDialog(MovieFrame MF){
		
		super(MF,"�α���",false);
		this.MF = MF;
		this.setSize(200,200);
		this.setVisible(true);
		
		id = new JLabel("�α���");
		pwd = new JLabel("�н�����");
		
		idInput = new JTextArea();
		pwdInput = new JTextArea();
		
		btn1 = new JButton("�α���");
		btnClose = new JButton("���");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		con.add(id);
		con.add(pwd);
		this.add(idInput);
		this.add(pwdInput);
		this.add(btn1);
		this.add(btnClose);
		
	
		
	}
	
	public void EventListener(){	
		btnClose.addActionListener(new EventListener());
			
	}
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj==btnClose){
				
			}
			
	
		}

			
	}
	
	
}
