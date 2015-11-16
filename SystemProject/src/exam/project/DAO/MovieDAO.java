package exam.project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root", "1234");
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
			pstmt.setString(3, movie.getMtime());
			pstmt.setString(4, movie.getActor());
			pstmt.setString(5, movie.getReservation());
			pstmt.setString(6, movie.getBanch());
			pstmt.setString(7, movie.getMdate());
			
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
	
	//영화정보확인
	public ArrayList<Movie> viewMovieInfo(){
		
		String sql = "select * from movie ";
		ArrayList<Movie> data = new ArrayList<Movie>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String sDirector = rs.getString("director");
				String sGenre = rs.getString("genre");
				String sMtime = rs.getString("mtime");
				String sActor = rs.getString("actor");
				String sReservation = rs.getString("reservation");
				String sBanch = rs.getString("banch");
				String sMdate = rs.getString("mdate");
				
				Movie mo = new Movie(sDirector, sGenre, sMtime, sActor, sReservation, sBanch, sMdate);
				data.add(mo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	


}
