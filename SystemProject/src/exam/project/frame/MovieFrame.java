package exam.project.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exam.project.dialog.AccountBankDialog;
import exam.project.dialog.LoginDialog;
import exam.project.dialog.MovieInfoDialog;

public class MovieFrame extends JFrame{
	
	private JPanel panel;
	private JButton movie,ago,next,reservetion,cancel;
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

		movie = new JButton(new ImageIcon("123.jpg")); //영화 포스터 사진
		ago = new JButton("◀");					  //이전영화
		next = new JButton("▶");					  //다음영화
		reservetion = new JButton("예매");					  //예매하기
		cancel = new JButton("취소");					  //취소하기

		setLayout(new FlowLayout(FlowLayout.CENTER));

		add(movie);
		add(ago);
		add(next);
		add(reservetion);
		add(cancel);

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
		reservetion.addActionListener(new EventListener());
		movie.addActionListener(new EventListener());
		
		//종료
		cancel.addActionListener(new EventListener());
		exit.addActionListener(new EventListener());
		
	}//end of addEventListener

	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();

			if(obj == login){
				LoginDialog login = new LoginDialog(MovieFrame.this);
			}
			else if(obj == reservetion){
				AccountBankDialog bank = new AccountBankDialog(MovieFrame.this);
			}
			else if(obj == movie){
				MovieInfoDialog mid = new MovieInfoDialog(MovieFrame.this);
			}
			else if(obj == cancel){
				System.exit(0);
			}
			else if(obj == exit){
				System.exit(0);
			}


		}


	}

}//end of class

