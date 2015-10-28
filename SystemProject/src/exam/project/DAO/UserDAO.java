package exam.project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import exam.project.DTO.UserData;

public class UserDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//회원등록
	public boolean insertUser(UserData user){

		String sql = "insert into userData values(?,?,?,?,?)";

		boolean ok = false;


		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getRePwd());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getSex());

			int rs = pstmt.executeUpdate();

			if(rs>0){
				ok = true;
				System.out.println("가입성공");
			}else{
				System.out.println("가입실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}// end of insertUser

	//회원등록
	public ArrayList<UserData> getUserList(){

		String sql ="select * from userData order by name asc";
		ArrayList<UserData> data = new ArrayList<UserData>();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				String sId = rs.getString("id");
				String sPwd = rs.getString("Pwd");
				String sRePwd = rs.getString("rePwd");
				String sName = rs.getString("name");
				String sSex = rs.getString("sex");

				UserData ud = new UserData(sId, sPwd, sRePwd, sName, sSex);

				data.add(ud);

			}//end of while
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}


