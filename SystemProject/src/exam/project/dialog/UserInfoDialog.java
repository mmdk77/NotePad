package exam.project.dialog;

import javax.swing.JDialog;

import exam.project.server.ServerFrame;

public class UserInfoDialog extends JDialog {

	//�߰�.
	public UserInfoDialog(ServerFrame sf){
		super(sf,"���������",false);
		this.setSize(300,300);
		
		
		
		this.setVisible(true);
		
	}
}
