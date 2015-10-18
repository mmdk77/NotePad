package exam.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exam.project.dto.Movie;

public class MovieDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MovieDAO(){		//DB¿¬°á
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertMovieInfo(Movie movie){
		String sql = "insert into movie values(?,?,default,?,?,?,default)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movie.getDirector());
			pstmt.setString(2, movie.getGenre());
			pstmt.setString(3, movie.getActor());
			pstmt.setInt(4, movie.getReservation());
			pstmt.setInt(5, movie.getBanch());
			
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
