package exam.project.dialog;

import javax.swing.JDialog;

import exam.project.server.ServerFrame;

public class AddMovieInfoDialog extends JDialog {


	public AddMovieInfoDialog(ServerFrame sf){
		
		//추가
		super(sf,"영화정보입력",false);
		this.setSize(300,300);
		
		this.setVisible(true);
	}
}
