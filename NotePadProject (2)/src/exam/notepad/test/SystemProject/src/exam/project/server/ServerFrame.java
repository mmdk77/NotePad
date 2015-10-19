package exam.project.server;

import javax.swing.*;

import exam.project.dialog.MovieInfoDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerFrame extends JFrame{
	
	private JButton movieInfo,reservation;
	private JLabel serverName;
	private Container con = getContentPane();
	
	
	public ServerFrame() {
		super("서버");
		this.setSize(300, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		serverName = new JLabel("서버관리");			
		con.add(serverName);
		con.setLayout(new GridLayout(5,1));
		
		addMoiveInfo();
		reservation();
		addEventListener();
		this.setVisible(true);
		
	}//end of ServerFrame
	
	public void addMoiveInfo(){
		
		movieInfo = new JButton("영화정보입력");
		con.add(movieInfo);
		this.setVisible(true);

	}//end of addMovieInfo
	
	public void reservation(){
		
		reservation = new JButton("예매율");
		con.add(reservation);
		this.setVisible(true);

		
	}//end of reservation
	
	public void addEventListener(){
		
		movieInfo.addActionListener(new EventListener());
		
	}
	
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			if(obj == movieInfo){
				MovieInfoDialog mid = new MovieInfoDialog(ServerFrame.this);
			}
			
		}
		
	}
	
}//end of class
