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

		super(mf,"����â",false);
		this.mf = mf;
		this.setSize(400, 300); 
		accountUI();
		addEventListener();
		this.setVisible(true); 
	}// end of AccountBankDialog - ������

	public void accountUI(){

		panel_1 = new JPanel();

		bank = new JLabel(" ���� : ");
		String ph[] = {"�������","��������","�츮����","�ϳ�����","��������","��������","��������"};  //DB?�� �ִ� ���������� �ҷ����̴¹���� ����ϵ����ؾ���.
		cb = new JComboBox<String>(ph) ; 											//ArrayList , Vector�� �������� ������ ����.

		cardNum = new JLabel(" ī���ȣ : ");											//īƮ��ȣ 4�ڸ��� �ʵ� ���� 4���� ����.
		tf1 = new JTextField();							

		pwd = new JLabel(" ��й�ȣ : ");
		pwdF1 = new JPasswordField();

		cardPwd = new JLabel(" ���������� ��й�ȣ : ");
		pwdF2 = new JPasswordField();

		account = new JButton("����");
		cancel = new JButton("���");

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

		
		test = new JLabel("���� �׽�Ʈ");
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
			
			if(strCmd.equals("����")){
				test.setText("Ȯ��");   		// DB���� �������� �����ͼ� �� �� ��������
			} //end of if
			if(obj == account){
				
			}else if(obj == cancel){
				AccountBankDialog.this.dispose();
			}
		}//end of actionPerformed
		
	}//end of EventListener class

} //end of AccountBankDialog class


