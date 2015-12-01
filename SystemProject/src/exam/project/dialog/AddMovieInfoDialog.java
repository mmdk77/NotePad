package exam.project.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import exam.project.DAO.MovieDAO;
import exam.project.DTO.Movie;
import exam.project.server.ServerFrame;

public class AddMovieInfoDialog extends JDialog {

	private JPanel panel_1,panel_2;
	private JLabel label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8;
	private JTextField tf_1,tf_2,tf_3,tf_4,tf_5,tf_6,tf_7;
	private JButton btnOk,btnClose;

	public AddMovieInfoDialog(ServerFrame sf){

		//추가
		super(sf,"영화정보입력",false);
		this.setSize(300,550);

		addMoiveUI();
		addEventListener();
		this.setVisible(true);
	}

	public void addMoiveUI(){
		panel_1 = new JPanel();
		panel_2 = new JPanel();

		label_1 = new JLabel(" 영화 : ");	//영화이름
		tf_1 = new JTextField();

		label_2 = new JLabel(" 감독 : ");	//감독
		tf_2 = new JTextField();

		label_3 = new JLabel(" 장르 : "); //장르
		tf_3 = new JTextField();

		label_4 = new JLabel(" 영화시간 : ");	//영화시간
		tf_4 = new JTextField();

		label_5 = new JLabel(" 배우 : ");	//배우
		tf_5 = new JTextField();

		label_6 = new JLabel(" 개봉 : ");	//개봉 날짜
		tf_6 = new JTextField();
		
		label_7 = new JLabel(" 줄 거 리 : ");
		tf_7 = new JTextField();

		btnOk = new JButton("확인");
		btnClose = new JButton("취소");

		panel_1.setLayout(null);
		label_1.setBounds(45,10,40,55);
		panel_1.add(label_1);

		tf_1.setBounds(120,26,120,20);
		panel_1.add(tf_1);

		label_2.setBounds(45,50,70,55);
		panel_1.add(label_2);

		tf_2.setBounds(120,66,120,20);
		panel_1.add(tf_2);

		label_3.setBounds(45,90,135,55);
		panel_1.add(label_3);

		tf_3.setBounds(120,106,120,20);
		panel_1.add(tf_3);

		label_4.setBounds(45,130,120,55);
		panel_1.add(label_4);

		tf_4.setBounds(120,146,120,20);
		panel_1.add(tf_4);

		label_5.setBounds(45,170,120,55);
		panel_1.add(label_5);

		tf_5.setBounds(120,186,120,20);
		panel_1.add(tf_5);

		label_6.setBounds(45,210,120,55);
		panel_1.add(label_6);

		tf_6.setBounds(120,226,120,20);
		panel_1.add(tf_6);
		
		label_7.setBounds(45,250,120,55);
		panel_1.add(label_7);
		
		tf_7.setBounds(120,266,120,120);
		panel_1.add(tf_7);

		btnOk.setBounds(60,350,90,50);
		panel_2.add(btnOk);

		btnClose.setBounds(190,350,90,50);
		panel_2.add(btnClose);

		add(panel_1);
		add(panel_2,"South");
	}

	public Movie getMovieData(){

		Movie moviedata = new Movie();

		String sMovieName = tf_1.getText();
		String sDirector = tf_2.getText();
		String sGenre = tf_3.getText();
		String sMtime = tf_4.getText();
		String sActor = tf_5.getText();
		String sMdate = tf_6.getText();
		String sStory = tf_7.getText();
		
		moviedata.setMovieName(sMovieName);
		moviedata.setDirector(sDirector);
		moviedata.setGenre(sGenre);
		moviedata.setMtime(sMtime);    
		moviedata.setActor(sActor);
		moviedata.setMdate(sMdate);	
		moviedata.setStory(sStory);

		return moviedata;

	}

	public void addEventListener(){
		btnOk.addActionListener(new EventListener());
	}
	class EventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			MovieDAO dao = new MovieDAO();
			Movie data = getMovieData();

			if(obj == btnOk){
				boolean ok = dao.insertMovie(data);
				System.out.println("insertMovie() 호출 종료");
				if(ok){
					JOptionPane.showMessageDialog(null, "입력이 완료 되었습니다.");
				}else{
					JOptionPane.showMessageDialog(null, "입력이 정상적으로 처리되지 못했습니다.");
				}
			}else if(obj == btnClose){
				AddMovieInfoDialog.this.dispose();
			}

		}
	}
	
}