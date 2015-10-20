package exam.project.dialog;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exam.project.frame.MovieFrame;
import exam.project.server.ServerFrame;

public class MovieInfoDialog extends JDialog {

	private JList<String> movieList;
	private JTextArea ta;
	private JScrollPane sp;

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

		String [] moiveName = {"사도","베테랑","메이즈러너","탐정","암살"};
		movieList = new JList<String>(moiveName);
		sp = new JScrollPane(movieList);
		ta = new JTextArea(10,30);
		ta.setText("선택하셈");
		add(ta,BorderLayout.CENTER);
		add(sp,BorderLayout.WEST);
	}
	
	public void addEventListener(){
		movieList.addListSelectionListener(new EventListener());
	}

	class EventListener implements ListSelectionListener,ActionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if(movieList.getSelectedValue() == "사도"){
				ta.setText("사도 영화정보");
			}else if(movieList.getSelectedValue() == "베테랑"){
				ta.setText("베테랑 영화정보");
			}else if(movieList.getSelectedValue() == "메이즈러너"){
				ta.setText("메이즈 영화정보");
			}else if(movieList.getSelectedValue() == "탐정"){
				ta.setText("탐정 영화정보");
			}else if(movieList.getSelectedValue() == "암살"){
				ta.setText("암살 영화정보");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	}


}
