package exam.project.dialog;

import javax.swing.JDialog;

import exam.project.server.ServerFrame;

public class UserInfoDialog extends JDialog {

	//추가.
	public UserInfoDialog(ServerFrame sf){
		super(sf,"사용자정보",false);
		this.setSize(300,300);
		
		
		
		this.setVisible(true);
		
	}
}
