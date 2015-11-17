package exam.project.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exam.project.dialog.AccountBankDialog;
import exam.project.dialog.JoinDialog;
import exam.project.dialog.LoginDialog;
import exam.project.dialog.MovieInfoDialog;


public class MovieFrame extends JFrame{

	private JPanel panel_1,panel_2,panel_3;
	private JLabel lb1;
	private JButton movie_1,movie_2,movie_3,movie_4,movie_5,ago,next,reservetion,cancel;
	private JMenuBar menubar;
	private JMenu homeMenu;
	private JMenuItem login,join,exit;
	private SpinnerModel model;
	private JSpinner spinner;
	
	private Container con = getContentPane();

	public MovieFrame(){	//영화예매화면

		super("영화예매"); 			//프로그램 타이틀
		setResizable(false);
		this.setSize(300,350);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		createMenuBar();
		movieInfo();
		movieSchedule();
		addEventListener();

		this.setVisible(true);
	} //end of MoiveFrame

	private void createMenuBar(){					//Menu만들기

		panel_1 = new JPanel();
		menubar = new JMenuBar();		//메뉴를 넣을 bar의 객체 생성
		homeMenu = new JMenu("홈");		//메뉴 객체 생성

		this.setJMenuBar(menubar);
		menubar.add(homeMenu);

		login = new JMenuItem("로그인");
		join = new JMenuItem("회원가입");
		exit = new JMenuItem("종료");
		

		homeMenu.add(login);	//홈메뉴에 "로그인" 추가
		homeMenu.add(join);		//홈메뉴에 "회원가입"추가
		homeMenu.add(exit);		//홈메뉴에 "종료" 추가
		
		
		menubar.add(homeMenu);


	}//end of createMenuBar

	public void movieInfo(){
		con.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_2 = new JPanel();
		con.add(panel_2);
		movie_1 = new JButton(new ImageIcon("사도.png")); //영화 포스터 사진
		movie_2 = new JButton(new ImageIcon("베테랑.png"));
		movie_3 = new JButton(new ImageIcon("메이즈러너.png"));
		movie_4 = new JButton(new ImageIcon("탐정.png"));
		movie_5 = new JButton(new ImageIcon("암살.png"));
		
		panel_2.add(movie_1);
		
		panel_1 = new JPanel();
		con.add(panel_1);
		ago = new JButton("◀");
		next = new JButton("▶");
		reservetion = new JButton("예매");
		cancel = new JButton("취소");
		
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.add(ago);
		panel_1.add(next);
		panel_1.add(reservetion);
		panel_1.add(cancel);

	}//end of MoviInfo

	public void movieSchedule(){

		model = new SpinnerDateModel();
		spinner = new JSpinner(model);
		lb1 = new JLabel(" 날짜/시간 "); //날짜: 년/월/일
		panel_3 = new JPanel();
		con.add(panel_3);
		
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_3.add(lb1);
		panel_3.add(spinner);


	}//end of movieSchedule

	public void addEventListener(){
		
		//menuBar 이벤트
		login.addActionListener(new EventListener());
		join.addActionListener(new EventListener());
		
		//화면 버튼 이벤트
		reservetion.addActionListener(new EventListener());
		movie_1.addActionListener(new EventListener());
		
		
		//종료
		cancel.addActionListener(new EventListener());
		exit.addActionListener(new EventListener());

	}//end of addEventListener

	class EventListener implements ActionListener,ListSelectionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();

			if(obj == login){
				LoginDialog login = new LoginDialog(MovieFrame.this);
			}else if(obj == reservetion){
				AccountBankDialog bank = new AccountBankDialog(MovieFrame.this);
			}else if(obj == movie_1){
				MovieInfoDialog mid = new MovieInfoDialog(MovieFrame.this);
			}else if(obj == join){
				JoinDialog join = new JoinDialog(MovieFrame.this);
			}else if(obj == cancel || obj == exit){
				System.exit(0);
			}else if(obj == ago){
				//버튼 image 바꿔야함
			}else if(obj == next){
				//버튼 image 바꿔야함
			}

		}//end of actionPerformed

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub

		}
	}//end of EventActionClass

}//end of class

