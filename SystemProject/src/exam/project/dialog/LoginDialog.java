package exam.project.dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import exam.project.DAO.UserDAO;
import exam.project.DTO.UserData;
import exam.project.frame.MovieFrame;

public class LoginDialog extends JDialog {

	public static final String CloseAction = null;
	private MovieFrame mf;
	private JButton btnLogin,btnClose;
	private JLabel id,pwd,test;
	private JPanel panel_1,panel_2,panel_3;
	private JTextField idInput;
	private JPasswordField pwdInput;
	private Container con = getContentPane();

	public LoginDialog(MovieFrame mf){

		super(mf,"로그인",false);
		this.mf = mf;
		this.setSize(300,200);

		loginUi();
		addEventListener();

		this.setVisible(true);
	}//end of LoginDialog

	public void loginUi(){

		panel_1 = new JPanel();
		panel_2 = new JPanel();
		panel_3 = new JPanel();
		id = new JLabel("      ID");
		pwd = new JLabel("Password");
		test = new JLabel("버튼 이벤트 확인용");
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		panel_1.add(id);
		panel_1.add(pwd);
		idInput = new JTextField();
		idInput.setBounds(20, 15, 144, 32);
		pwdInput = new JPasswordField();			
		pwdInput.setBounds(20, 75, 144, 32);
		panel_2.setLayout(null);
		panel_2.add(idInput);
		panel_2.add(pwdInput);

		btnLogin = new JButton("로그인");
		btnClose = new JButton("취소");

		panel_3.add(btnLogin);
		panel_3.add(btnClose);
		panel_3.add(test);

		con.add(panel_1,"West");
		con.add(panel_2,"Center");
		con.add(panel_3,"South");	

	}//end of loginUi

	public void addEventListener(){	

		btnClose.addActionListener(new EventListener());
		btnLogin.addActionListener(new EventListener());

	}//end of eventListener

	class EventListener implements ActionListener{
		UserData ud = new UserData();
		UserDAO dao = new UserDAO();

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			if(obj == btnLogin){
				char[] strPwd = pwdInput.getPassword();
				String pwd = null;
				pwd = String.copyValueOf(strPwd);
				System.out.println("Id,Pwd:"+idInput.getText()+","+pwd);
				
				if(dao.userLogin(idInput.getText(), pwd)){
					JOptionPane.showMessageDialog(null, idInput.getText()+"님 환영합니다.");
					LoginDialog.this.dispose();
				}else if(!dao.userLogin(idInput.getText(), pwd)){
					JOptionPane.showMessageDialog(null, "아이디/패스워드가 잘못되었습니다.");
				}
			}//end of if
			else if(obj == btnClose){
				LoginDialog.this.dispose();
			}//end of else if

		}//end of actionPerformed
	}//end of EventListenerClass

}//end of LoginDialogClass
