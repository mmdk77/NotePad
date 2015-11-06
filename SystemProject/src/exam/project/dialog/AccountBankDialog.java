package exam.project.dialog;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exam.project.frame.MovieFrame;

public class AccountBankDialog extends JDialog{

	private MovieFrame mf;
	private JPanel panel_1;
	private JLabel bank,cardNum,pwd,cardPwd;
	private JTextField tf1; 
	private JPasswordField pwdF1,pwdF2; 
	private JButton account,cancel; 
	private JComboBox<String> cb;
	
	private JLabel test;

	public AccountBankDialog(MovieFrame mf){

		super(mf,"결제창",false);
		this.mf = mf;
		this.setSize(400, 300); 
		accountUI();
		addEventListener();
		this.setVisible(true); 
	}// end of AccountBankDialog - 생성자

	public void accountUI(){

		panel_1 = new JPanel();

		bank = new JLabel(" 은행 : ");
		String ph[] = {"기업은행","신한은행","우리은행","하나은행","국민은행","외한은행","농협은행"};  //DB?에 있는 은행정보로 불러들이는방법을 고안하도록해야함.
		cb = new JComboBox<String>(ph) ; 											//ArrayList , Vector로 가능하지 않을까 싶음.

		cardNum = new JLabel(" 카드번호 : ");											//카트번호 4자리씩 필드 또한 4개로 분할.
		tf1 = new JTextField();							

		pwd = new JLabel(" 비밀번호 : ");
		pwdF1 = new JPasswordField();

		cardPwd = new JLabel(" 공인인증서 비밀번호 : ");
		pwdF2 = new JPasswordField();

		account = new JButton("결제");
		cancel = new JButton("취소");

		panel_1.setLayout(null);
		bank.setBounds(45,10,40,55);
		panel_1.add(bank);

		cb.setBounds(120,26,120,20);
		panel_1.add(cb);

		cardNum.setBounds(45,50,70,55);
		panel_1.add(cardNum);

		tf1.setBounds(120,66,120,20);
		panel_1.add(tf1);

		pwd.setBounds(45,90,135,55);
		panel_1.add(pwd);

		pwdF1.setBounds(120,106,120,20);
		panel_1.add(pwdF1);

		cardPwd.setBounds(45,130,135,55);
		panel_1.add(cardPwd);

		pwdF2.setBounds(200,146,120,20);
		panel_1.add(pwdF2);


		account.setBounds(60,200,70,30);
		panel_1.add(account);

		cancel.setBounds(190,200,70,30);
		panel_1.add(cancel);

		
		test = new JLabel("승인 테스트");
		panel_1.add(test);
		test.setBounds(80, 200, 80, 80);
		
		this.add(panel_1);

	}// end of accountUI
	
	public void addEventListener(){
		
		account.addActionListener(new EventListener());
		cancel.addActionListener(new EventListener());
		
	}// end of addEventListener
	
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			String strCmd = e.getActionCommand();
			
			if(strCmd.equals("결제")){
				test.setText("확인");   		// DB에서 은행정보 가져와서 비교 후 승인절차
			} //end of if
			if(obj == account){
				
			}else if(obj == cancel){
				AccountBankDialog.this.dispose();
			}
		}//end of actionPerformed
		
	}//end of EventListener class

} //end of AccountBankDialog class


