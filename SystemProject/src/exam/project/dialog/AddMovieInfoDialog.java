package exam.project.dialog;

import javax.swing.JDialog;

import exam.project.server.ServerFrame;

public class AddMovieInfoDialog extends JDialog {


	public AddMovieInfoDialog(ServerFrame sf){
		
		//�߰�
		super(sf,"��ȭ�����Է�",false);
		this.setSize(300,300);
		
		this.setVisible(true);
	}
}
