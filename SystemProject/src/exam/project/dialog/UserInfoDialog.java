package exam.project.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
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
	private Vector<String> v;
	private Vector<String> cols;

	//추가.
	public UserInfoDialog(ServerFrame sf){
		super(sf,"사용자정보",false);
		this.setSize(500,300);
		
		UserDAO dao = new UserDAO();
		cols = getColum();

		
		UserInfoUI();
		addEventListener();
		this.setVisible(true);

	}
	public void UserInfoUI(){
		model = new DefaultTableModel(v, cols);
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
	public Vector<String> getColum(){

		cols = new Vector<String>();

		cols.add("ID");
		cols.add("Password");
		cols.add("RePassword");
		cols.add("이름");
		cols.add("성별");


		return cols;

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

			if(obj == btnOk){
				v = dao.getUserList();
				System.out.println("V="+v);
			}else if(obj == btnCancel){
				System.exit(0);
			}
		}	
	}
}

