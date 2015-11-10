package exam.project.dialog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exam.project.frame.MovieFrame;
import exam.project.server.ServerFrame;

public class MovieInfoDialog extends JDialog {

	private JList<String> movieList;
	private JTextArea ta;
	private JScrollPane sp;
	private JPanel panel_1,panel_2,panel_3,panel_4,panel_5,panel_6;
	private JLabel lb_1,lb_2,lb_3,lb_4,lb_5;
	private JTextField tf_1,tf_2,tf_3,tf_4,tf_5;
	private JButton img_1;

	public MovieInfoDialog(ServerFrame sf){

		super(sf,"영화정보",false);
		this.setSize(500,500);

		movieInfoUi();
		addEventListener();
		this.setVisible(true);

	}

	public MovieInfoDialog(MovieFrame mf){

		super(mf,"영화정보",false);
		this.setSize(500,500);

		movieInfoUi();
		addEventListener();
		this.setVisible(true);
	}

	public void movieInfoUi(){

		String [] movieName = {"사도","베테랑","메이즈러너","탐정","암살"};
		movieList = new JList<String>(movieName);
		sp = new JScrollPane(movieList);

		img_1 = new JButton(new ImageIcon("사도.png"));
		panel_1 = new JPanel();
		panel_1.add(sp);

		panel_2 = new JPanel(new GridLayout(1,2));
		panel_5 = new JPanel();
		panel_6 = new JPanel();

		lb_1 = new JLabel("감독 :");
		tf_1 = new JTextField();

		lb_2 = new JLabel("배우 :");
		tf_2 = new JTextField();

		lb_3 = new JLabel("장르 :");
		tf_3 = new JTextField();

		lb_4 = new JLabel("영화시간 :");
		tf_4 = new JTextField();

		lb_5 = new JLabel("개봉일 :");
		tf_5 = new JTextField();

		panel_5.add(img_1);
		panel_6.setLayout(null);

		lb_1.setBounds(30,10,30,30);
		tf_1.setBounds(70, 15, 80, 20);
		panel_6.add(lb_1);
		panel_6.add(tf_1);

		lb_2.setBounds(30,40,30,30);
		tf_2.setBounds(70,45,80,20);
		panel_6.add(lb_2);
		panel_6.add(tf_2);

		lb_3.setBounds(30,70,30,30);
		tf_3.setBounds(70,75,80,20);
		panel_6.add(lb_3);
		panel_6.add(tf_3);

		lb_4.setBounds(30,110,55,30);
		tf_4.setBounds(95,115,80,20);
		panel_6.add(lb_4);
		panel_6.add(tf_4);

		lb_5.setBounds(30,150,55,30);
		tf_5.setBounds(95,155,80,20);
		panel_6.add(lb_5);
		panel_6.add(tf_5);

		panel_2.add(panel_5);
		panel_2.add(panel_6);

		panel_3 = new JPanel();
		ta = new JTextArea(10,30);
		ta.setText("선택하셈");
		panel_3.add(ta);

		panel_4 = new JPanel(new GridLayout(2, 1));
		panel_4.add(panel_2);
		panel_4.add(panel_3);

		add(panel_1,BorderLayout.WEST);
		add(panel_4);


	}

	public void addEventListener(){
		movieList.addListSelectionListener(new EventListener());
	}

	class EventListener implements ListSelectionListener,ActionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if(movieList.getSelectedValue() == "사도"){
				img_1.setText("");
				ta.setText("영화정보1");
			}else if(movieList.getSelectedValue() == "베테랑"){
				img_1.setText("icon");
				ta.setText("영화정보2");
			}else if(movieList.getSelectedValue() == "메이즈러너"){
				img_1.setText("icon");
				ta.setText("영화정보3");
			}else if(movieList.getSelectedValue() == "탐정"){
				img_1.setText("icon");
				ta.setText("영화정보4");
			}else if(movieList.getSelectedValue() == "암살"){
				img_1.setText("icon");
				ta.setText("영화정보5");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}


}
