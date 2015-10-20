package exam.project.server;

import javax.swing.*;

import exam.project.dialog.AddMovieInfoDialog;
import exam.project.dialog.MovieInfoDialog;
import exam.project.dialog.UserInfoDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerFrame extends JFrame{
	
	private JButton movieInfo,addMovieInfo,reservation,userInfo;
	private JLabel serverName;
	private Container con = getContentPane();
	
	
	public ServerFrame() {
		super("����");
		this.setSize(300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		serverName = new JLabel("��������");			
		con.add(serverName);
		con.setLayout(new GridLayout(5,1));
		
		moiveInfo();
		addMovieInfo();
		userInfo();
		reservation();
		addEventListener();
		
		this.setVisible(true);
		
	}//end of ServerFrame
	
	public void moiveInfo(){
		
		movieInfo = new JButton("��ȭ����Ȯ��");
		con.add(movieInfo);
	
	}//end of MovieInfo
	
	public void addMovieInfo(){
		
		addMovieInfo = new JButton("��ȭ�����Է�");
		con.add(addMovieInfo);

	}//end of addMovieInfo
	
	public void reservation(){
		
		reservation = new JButton("������");
		con.add(reservation);
		
	}//end of reservation
	
	public void userInfo(){
		
		userInfo = new JButton("���������");
		con.add(userInfo);
		
	}//end of userInfo
	
	public void addEventListener(){
		
		movieInfo.addActionListener(new EventListener());
		userInfo.addActionListener(new EventListener());
		
	}//end of EventListener
	
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			if(obj == movieInfo){
				MovieInfoDialog mid = new MovieInfoDialog(ServerFrame.this);
			}
			else if(obj == userInfo){
				UserInfoDialog uid = new UserInfoDialog(ServerFrame.this);
			}
			else if(obj == addMovieInfo){
				AddMovieInfoDialog ami = new AddMovieInfoDialog(ServerFrame.this);
			}
		}//end of actionPerformed
		
	}//end of EventListener
	
}//end of class
