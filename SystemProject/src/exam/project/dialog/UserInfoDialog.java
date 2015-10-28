package exam.project.dialog;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exam.project.DAO.UserDAO;
import exam.project.DTO.UserData;
import exam.project.server.ServerFrame;

public class UserInfoDialog extends JDialog{

	private JTable userTable;
	private JScrollPane listSp;
	private JPanel panel_1;
	private JButton btnOk,btnCancel;
	private DefaultTableModel model;


	//추가.
	public UserInfoDialog(ServerFrame sf){
		super(sf,"사용자정보",false);
		this.setSize(500,300);


		UserInfoUI();
		addEventListener();
		this.setVisible(true);

	}
	public void UserInfoUI(){

		String culumNames[] = {"ID","Password","RePassword","Name","Gender"};
		model = new DefaultTableModel(culumNames,0);
		userTable = new JTable(model);
		listSp = new JScrollPane(userTable);
		add(listSp);

		panel_1 = new JPanel();
		btnOk = new JButton("확인");
		btnCancel = new JButton("취소");
		panel_1.add(btnOk);
		panel_1.add(btnCancel);
		add(panel_1,BorderLayout.NORTH);

	}



	public void addEventListener(){
		btnOk.addActionListener(new EventListener());
		btnCancel.addActionListener(new EventListener());
	}
	class EventListener implements ActionListener{

		UserDAO dao = new UserDAO();

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			
			UserData ud = new UserData();
		
			if(obj == btnOk){
				ArrayList<UserData> data = dao.getUserList();
				for(int i = 0; i<data.size(); i++){
					ud = data.get(i);
					Object rows[] = {ud.getId(),ud.getPwd(),ud.getRePwd(),ud.getName(),ud.getSex()};
					model.addRow(rows);
				}
		
			}else if(obj == btnCancel){
				System.exit(0);
			}

		}
	}
}

