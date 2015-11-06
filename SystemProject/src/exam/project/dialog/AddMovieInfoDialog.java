package exam.project.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exam.project.DAO.MovieDAO;
import exam.project.DAO.UserDAO;
import exam.project.DTO.Movie;
import exam.project.DTO.UserData;
import exam.project.server.ServerFrame;

public class AddMovieInfoDialog extends JDialog {

	private JPanel panel_1,panel_2;
	private JLabel label_1,label_2,label_3,label_4,label_5,label_6,label_7;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	private JButton btnOk,btnClose;

	public AddMovieInfoDialog(ServerFrame sf){

		//추가
		super(sf,"영화정보입력",false);
		this.setSize(300,450);

		addMoiveUI();
		addEventListener();
		this.setVisible(true);
	}

	public void addMoiveUI(){
		panel_1 = new JPanel();
		panel_2 = new JPanel();

		label_1 = new JLabel(" 감독 : ");
		tf1 = new JTextField();

		label_2 = new JLabel(" 장르 : ");
		tf2 = new JTextField();

		label_3 = new JLabel(" 영화시간 : ");
		tf3 = new JTextField();

		label_4 = new JLabel(" 배우 : ");
		tf4 = new JTextField();

		label_5 = new JLabel(" 예약 : ");
		tf5 = new JTextField();

		label_6 = new JLabel(" 좌석 : ");
		tf6 = new JTextField();

		label_7 = new JLabel(" 날짜 : ");
		tf7 = new JTextField();

		btnOk = new JButton("확인");
		btnClose = new JButton("취소");

		panel_1.setLayout(null);
		label_1.setBounds(45,10,40,55);
		panel_1.add(label_1);

		tf1.setBounds(120,26,120,20);
		panel_1.add(tf1);

		label_2.setBounds(45,50,70,55);
		panel_1.add(label_2);

		tf2.setBounds(120,66,120,20);
		panel_1.add(tf2);

		label_3.setBounds(45,90,135,55);
		panel_1.add(label_3);

		tf3.setBounds(120,106,120,20);
		panel_1.add(tf3);

		label_4.setBounds(45,130,120,55);
		panel_1.add(label_4);

		tf4.setBounds(120,146,120,20);
		panel_1.add(tf4);

		label_5.setBounds(45,170,120,55);
		panel_1.add(label_5);

		tf5.setBounds(120,186,120,20);
		panel_1.add(tf5);

		label_6.setBounds(45,210,120,55);
		panel_1.add(label_6);

		tf6.setBounds(120,226,120,20);
		panel_1.add(tf6);

		label_7.setBounds(45,250,120,55);
		panel_1.add(label_7);

		tf7.setBounds(120,266,120,20);
		panel_1.add(tf7);

		btnOk.setBounds(60,350,90,50);
		panel_2.add(btnOk);

		btnClose.setBounds(190,350,90,50);
		panel_2.add(btnClose);

		add(panel_1);
		add(panel_2,"South");
	}

	public Movie getMovieData(){

		Movie moviedata = new Movie();

		String sDirector = tf1.getText();
		String sGenre = tf2.getText();
		String sMtime = tf3.getText();
		String sActor = tf4.getText();
		String sReservation = tf5.getText();
		String sBanch = tf6.getText();
		String sMdate = tf7.getText();

		moviedata.setDirector(sDirector);
		moviedata.setGenre(sGenre);
		moviedata.setMdate(sMtime);     // <---뭘까...
		moviedata.setActor(sActor);
		moviedata.setReservation(sReservation);
		moviedata.setBanch(sBanch);
		moviedata.setMdate(sMdate);		// <---뭘까..\

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
					JOptionPane.showInputDialog(this, "입력이 완료 되었습니다.");
				}else{
					JOptionPane.showInputDialog(this, "입력이 정상적으로 처리되지 못했습니다.");
				}
			}else if(obj == btnClose){
				System.exit(0);
			}

		}
	}
	
}