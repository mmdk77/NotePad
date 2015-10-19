package exam.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import exam.project.dialog.JoinDialog;
import exam.project.dto.Movie;
import exam.project.dto.UserData;

public class UserDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO(){		//DB¿¬°á
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","1234");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public int insertUserInfo(UserData user){
		
		String sql = "insert into movie values(?,?,?,?,?)";

		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getRePwd());
			pstmt.setString(4, user.getName());

			


			int result;

			result = pstmt.executeUpdate();

			if(result != 0)
				return result;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}
}

