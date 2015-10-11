package exam.project.dialog;

import java.awt.Container;

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
	private JPanel p1;
	private JLabel bank,cardNum,pwd,cardpwd;
	private JTextField tf1; 
	private JPasswordField pwdF1,pwdF2; 
	private JButton account,cancel; 
	private JComboBox<String> cb;

	public AccountBankDialog(MovieFrame mf){

		super(mf,"결제창",false);
		this.mf = mf;
		this.setSize(400, 300); 
		this.setVisible(true); 

		accountUi();
	}// end of AccountBankDialog - 생성자

	public void accountUi(){

		p1 = new JPanel();

		bank = new JLabel(" 은행 : ");
		String ph[]={"기업은행","신한은행","우리은행","하나은행","국민은행","외한은행","농협은행"};
		cb = new JComboBox<String>(ph) ; 

		cardNum = new JLabel(" 카드번호 : ");
		tf1 = new JTextField();

		pwd = new JLabel(" 비밀번호 : ");
		pwdF1 = new JPasswordField();

		cardpwd = new JLabel(" 공인인증서 비밀번호 : ");
		pwdF2 = new JPasswordField();

		account = new JButton("결제");
		cancel = new JButton("취소");

		p1.setLayout(null);
		bank.setBounds(45,10,40,55);
		p1.add(bank);

		cb.setBounds(120,26,120,20);
		p1.add(cb);

		cardNum.setBounds(45,50,70,55);
		p1.add(cardNum);

		tf1.setBounds(120,66,120,20);
		p1.add(tf1);

		pwd.setBounds(45,90,135,55);
		p1.add(pwd);

		pwdF1.setBounds(120,106,120,20);
		p1.add(pwdF1);

		cardpwd.setBounds(45,130,135,55);
		p1.add(cardpwd);

		pwdF2.setBounds(200,146,120,20);
		p1.add(pwdF2);


		account.setBounds(60,200,90,50);
		p1.add(account);

		cancel.setBounds(190,200,90,50);
		p1.add(cancel);

		this.add(p1);

	}// end of accountUi

} //end of class


