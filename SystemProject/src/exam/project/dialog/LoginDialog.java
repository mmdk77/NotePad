package exam.project.dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exam.project.frame.MovieFrame;

public class LoginDialog extends JDialog {

	public static final String CloseAction = null;
	private MovieFrame MF;
	private JButton btnlogin,btnClose;
	private JLabel id,pwd,test;
	private JPanel p1,p2,p3,p4;
	private JTextField idInput;
	private JPasswordField pwdInput;
	private Container con = getContentPane();


	public LoginDialog(MovieFrame MF){

		super(MF,"로그인",false);
		this.MF = MF;
		this.setSize(300,200);
		this.setVisible(true);

		loginUi();
		eventListener();
	}//end of LoginDialog
	public void loginUi(){

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		p1.setLayout(new GridLayout(0,1,20,5));	
		id = new JLabel("로그인");
		pwd = new JLabel("패스워드");
		test = new JLabel("버튼 이벤트 확인용");

		p1.add(id);
		p1.add(pwd);


		p2.setLayout(new GridLayout(0,1,20,5));
		idInput = new JTextField();
		pwdInput = new JPasswordField();			
		p2.add(idInput);
		p2.add(pwdInput);

		btnlogin = new JButton("로그인");
		btnClose = new JButton("취소");

		p3.add(btnlogin);
		p3.add(btnClose);
		p3.add(test);

		con.add(p1,"West");
		con.add(p2,"Center");
		con.add(p3,"South");	

		this.setVisible(true);

	}//end of loginUi

	public void eventListener(){	

		btnClose.addActionListener(new EventListener());
		btnlogin.addActionListener(new EventListener());


	}//end of eventListener
	
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			String strCmd = e.getActionCommand();

			if(strCmd.equals("로그인")){
				test.setText("로그인");
			} //end of if
			else if(strCmd.equals("취소")){
				test.setText("취소");
			} //end of else if (first) 
			
		}//end of actionPerformed
	}//end of EventListenerClass
	
}//end of LoginDialogClass
