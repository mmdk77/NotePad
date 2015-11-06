package exam.project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exam.project.DTO.Movie;
import exam.project.DTO.UserData;

public class MovieDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	
	
	//DB연결
	public MovieDAO(){
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
	}//end of MovieDAO
	
	
	//영화정보등록
	public boolean insertMovie(Movie movie){

		String sql = "insert into movieData values(?,?,?,?,?,?,?)";

		boolean ok = false;


		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movie.getDirector());
			pstmt.setString(2, movie.getGenre());
			pstmt.setTime(3, movie.getMtime());
			pstmt.setString(4, movie.getActor());
			pstmt.setInt(5, movie.getReservation());
			pstmt.setInt(6, movie.getBanch());
			pstmt.setDate(7, movie.getMdate());
			int rs = pstmt.executeUpdate();

			if(rs>0){
				ok = true;
				System.out.println("입력성공");
			}else{
				System.out.println("입력실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}// end of insertUser
	


}
