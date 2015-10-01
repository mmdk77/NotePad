package exam.project.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exam.project.dialog.LoginDialog;

public class MovieFrame extends JFrame{
	private JButton btn1,btn2,btn3,btn4,btn5;
	private JMenuBar menubar;
	private JMenu homeMenu;
	private JMenuItem login,exit;
	
	private SpinnerModel model;
	private JSpinner spinner;
	
	private Container con = getContentPane();
	
	public MovieFrame(){	//영화예매화면
		
		super("영화예매"); 			//프로그램 타이틀
		this.setSize(300,350);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		createMenuBar();
		movieInfo();
		movieSchedule();
		addEventListener();
		
	} //end of MoiveFrame
	
	private void createMenuBar(){					//Menu만들기
		
		menubar = new JMenuBar();		//메뉴를 넣을 bar의 객체 생성
		homeMenu = new JMenu("홈");		//메뉴 객체 생성
		
		
		this.setJMenuBar(menubar);
		menubar.add(homeMenu);
		
		login = new JMenuItem("로그인");
		exit = new JMenuItem("종료");
		
		homeMenu.add(login);	//홈메뉴에 "로그인" 추가
		homeMenu.add(exit);		//홈메뉴에 "종료" 추가
		
	}//end of createMenuBar
	
	public void movieInfo(){
	
		btn1 = new JButton(new ImageIcon("123.jpg")); //영화 포스터 사진
		btn2 = new JButton("◀");					  //이전영화
		btn3 = new JButton("▶");					  //다음영화
		btn4 = new JButton("예매");					  //예매하기
		btn5 = new JButton("취소");					  //취소하기
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		this.setVisible(true);
	
	
	}//end of MoviInfo
	
	public void movieSchedule(){
		
		model = new SpinnerDateModel();
		spinner = new JSpinner(model);
	    
	    JLabel label = new JLabel(" 날짜/시간 "); //날짜: 년/월/일
	    JPanel panel = new JPanel();
	    panel.add(label,BorderLayout.WEST);
	    panel.add(spinner,BorderLayout.EAST);
	    add(panel);

	    this.setVisible(true);
	   
	}//end of movieSchedule
	
	public void addEventListener(){
		login.addActionListener(new EventListener());
		
	}//end of addEventListener
	
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			if(obj == login){
				LoginDialog login = new LoginDialog(MovieFrame.this);
			}
			
		}
		
		
	}
	
}//end of class

