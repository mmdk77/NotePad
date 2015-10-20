package exam.project.dialog;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public static final Object arg0 = null;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private JPanel panel_1;
	private JButton agree,cancel;
	private JRadioButton male,female;
	private ButtonGroup sex;
	private JLabel lb_1,lb_2,lb_3,lb_4,lb_5;
	private JTextField name,id;
	private JPasswordField pwd,rePwd;
	private JLabel test;
	private Container contain = getContentPane();

	public JoinDialog(MovieFrame mf){

		super(mf,"회원가입",false);
		this.setSize(300, 500);

		joinUI();				//UI메소드 호출
		addEventListener();	//이벤트 처리 메소드

		this.setVisible(true);

	}//end of JoinDialog - 생성자

	public void joinUI(){

		panel_1 = new JPanel();		
		panel_1.setLayout(null);

		lb_1 = new JLabel(" ID : ");
		id = new JTextField("");

		lb_1.setBounds(73, 40, 30, 30);		//ID(Label) 위치와 크기설정
		panel_1.add(lb_1);
		id.setBounds(100, 41 , 130, 29);	//ID(TextField) 위치와 크기설정
		panel_1.add(id);	

		lb_2 = new JLabel(" Password : ");
		lb_3 = new JLabel(" RePassword : ");
		pwd = new JPasswordField(8);
		rePwd = new JPasswordField(8);

		lb_2.setBounds(27, 79, 100, 30);		//Password(Label) 위치와 크기설정
		lb_3.setBounds(12, 119, 100, 30);		//RePassword(Label) 위치와 크기설정
		panel_1.add(lb_2);
		panel_1.add(lb_3);

		pwd.setBounds(100, 80, 130, 29);		//Password(PasswordField) 위치와 크기설정
		rePwd.setBounds(100, 120, 130, 29);		//RePassword(PasswordField) 위치와 크기설정
		panel_1.add(pwd);						// => Password와 RePassword가 같아야 회원가입이 가능해야함
		panel_1.add(rePwd);


		lb_4 = new JLabel(" 이 름 : ");
		name = new JTextField(10);

		lb_4.setBounds(56,160,170,30);			//name(Label) 위치와 크기설정
		panel_1.add(lb_4);
		name.setBounds(100,160, 130, 29);		//name(TextField) 위치와 크기설정
		panel_1.add(name);

		lb_5 = new JLabel(" 성 별 : ");
		male = new JRadioButton("남성");
		female = new JRadioButton("여성");

		sex = new ButtonGroup();			//라디오 버튼 그룹생성
		sex.add(male);						//그룹- 성별(male,female) 추가
		sex.add(female);

		lb_5.setBounds(56,200,170,30);		//성별(Lable) 위치와 크기설정
		panel_1.add(lb_5);

		male.setBounds(105,195,70,40);		// 남성(RadioButton) 위치와 크기설정
		female.setBounds(180,195,70,40);	// 여성(RadioButton) 위치와 크기설정
		panel_1.add(male);					
		panel_1.add(female);				//패널에 각각 설병 추가, *그룹에 라디오버튼 넣었다고 패널에 그룹으로 추가하면 X

		agree = new JButton("확인");
		cancel = new JButton("취소");

		agree.setBounds(40, 400, 80, 50);		//확인 버튼 위치와 크기설정
		cancel.setBounds(160, 400, 80, 50);		//취소 버튼 위치와 크기설정

		panel_1.add(agree);
		panel_1.add(cancel);

		//Test 목적 라벨
		test = new JLabel("승인 테스트");
		panel_1.add(test);
		test.setBounds(200, 350, 80, 80);

		contain.add(panel_1);

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

			if(obj == agree){

				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root", "1234");

					String sql = "insert into userData values(?,?,?,?,?)";

					pstmt = con.prepareStatement(sql);

					pstmt.setString(1,id.getText());
					pstmt.setString(2, new String(pwd.getPassword()));
					pstmt.setString(3, new String(rePwd.getPassword()));
					pstmt.setString(4, name.getText());
					if(male.isSelected()){
						pstmt.setInt(5, 1);
					}else if(female.isSelected()){
						pstmt.setInt(5, 2);
					}
					pstmt.executeUpdate();
					pstmt.close();
					con.close();

				} catch (ClassNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}else if(obj == cancel){
				System.exit(0);
			}


		}
	}//end of EventAction class
}//end of JoinDialog class

