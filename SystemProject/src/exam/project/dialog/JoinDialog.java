package exam.project.dialog;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import exam.project.frame.MovieFrame;

public class JoinDialog extends JDialog{
	private JPanel panel_1,panel_2,panel_3;
	private JButton agree,cancel;
	private JRadioButton male,female;
	private ButtonGroup sex;
	private JLabel lb_1,lb_2,lb_3,lb_4,lb_5;
	private JTextField name,age,id;
	private JPasswordField pwd,repwd;
	
	private JLabel test;
	
	private Container con = getContentPane();

	public JoinDialog(MovieFrame mf){

		super(mf,"ȸ������",false);
		this.setSize(300, 500);
		
		joinUI();				//UI�޼ҵ� ȣ��
		addEventListener();	//�̺�Ʈ ó�� �޼ҵ�
		
		this.setVisible(true);

	}//end of JoinDialog - ������
	
	public void joinUI(){
		
		panel_1 = new JPanel();		
		panel_1.setLayout(null);
		
		lb_1 = new JLabel(" ID : ");
		id = new JTextField();
		
		lb_1.setBounds(73, 40, 30, 30);		//ID(Label) ��ġ�� ũ�⼳��
		panel_1.add(lb_1);
		id.setBounds(100, 41 , 130, 29);	//ID(TextField) ��ġ�� ũ�⼳��
		panel_1.add(id);	
		
		lb_2 = new JLabel(" Password : ");
		lb_3 = new JLabel(" RePassword : ");
		pwd = new JPasswordField();
		repwd = new JPasswordField();
		
		lb_2.setBounds(27, 79, 100, 30);		//Password(Label) ��ġ�� ũ�⼳��
		lb_3.setBounds(12, 119, 100, 30);		//RePassword(Label) ��ġ�� ũ�⼳��
		panel_1.add(lb_2);
		panel_1.add(lb_3);
		
		pwd.setBounds(100, 80, 130, 29);		//Password(PasswordField) ��ġ�� ũ�⼳��
		repwd.setBounds(100, 120, 130, 29);		//RePassword(PasswordField) ��ġ�� ũ�⼳��
		panel_1.add(pwd);						// => Password�� RePassword�� ���ƾ� ȸ�������� �����ؾ���
		panel_1.add(repwd);
	
		
		lb_4 = new JLabel(" �� �� : ");
		name = new JTextField();
		
		lb_4.setBounds(56,160,170,30);			//name(Label) ��ġ�� ũ�⼳��
		panel_1.add(lb_4);
		name.setBounds(100,160, 130, 29);		//name(TextField) ��ġ�� ũ�⼳��
		panel_1.add(name);
		
		lb_5 = new JLabel(" �� �� : ");
		male = new JRadioButton("����");
		female = new JRadioButton("����");
		
		sex = new ButtonGroup();			//���� ��ư �׷����
		sex.add(male);						//�׷�- ����(male,female) �߰�
		sex.add(female);
		
		lb_5.setBounds(56,200,170,30);		//����(Lable) ��ġ�� ũ�⼳��
		panel_1.add(lb_5);
		
		male.setBounds(105,195,70,40);		// ����(RadioButton) ��ġ�� ũ�⼳��
		female.setBounds(180,195,70,40);	// ����(RadioButton) ��ġ�� ũ�⼳��
		panel_1.add(male);					
		panel_1.add(female);				//�гο� ���� ���� �߰�, *�׷쿡 ������ư �־��ٰ� �гο� �׷����� �߰��ϸ� X
		
		agree = new JButton("Ȯ��");
		cancel = new JButton("���");
		
		agree.setBounds(40, 400, 80, 50);		//Ȯ�� ��ư ��ġ�� ũ�⼳��
		cancel.setBounds(160, 400, 80, 50);		//��� ��ư ��ġ�� ũ�⼳��
		
		panel_1.add(agree);
		panel_1.add(cancel);
		
		//Test ���� ��
		test = new JLabel("���� �׽�Ʈ");
		panel_1.add(test);
		test.setBounds(200, 350, 80, 80);
		
		con.add(panel_1);
	
	}
	public void addEventListener(){
		agree.addActionListener(new EvnetListener());
		cancel.addActionListener(new EvnetListener());
		
	}
	class EvnetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			String strCmd = e.getActionCommand();
			if(strCmd.equals("Ȯ��")){
				test.setText("Ȯ��");   		//DB�� �����͵��� �ֵ��� ��������
			} //end of if
			else if(strCmd.equals("���")){
				test.setText("���"); 		//�����ܰ�� ���ư��� �ֵ��� ��������
			}
		}
		
	}
}