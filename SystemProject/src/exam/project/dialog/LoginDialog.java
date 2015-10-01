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
	
	
	public LoginDialog(MovieFrame MF){
		
		super(MF,"로그인",false);
		this.MF = MF;
		this.setSize(200,200);
		this.setVisible(true);
		
		btn1 = new JButton("로그인");
		btnClose = new JButton("취소");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
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
